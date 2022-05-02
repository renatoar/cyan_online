<!-- Compiler call and Results area constructor -->
<div>
    <?php
        $executionStartTime = microtime(true);
        // Required env vars of cyan compiler
        putenv("CYAN_HOME=./Cyan/lib");        
        $java_location = exec("echo $(dirname $(dirname $(readlink $(readlink $(which javac)))))");
        putenv("JAVA_HOME_FOR_CYAN=$java_location");        

        // Code folder creation for each compilation
        $folder_session_name = exec("echo $(date +%s)");
        exec("mkdir -p code/$folder_session_name/program/main");

        // Required vars for the compiler location and aux compiling files
        $CC = "./Cyan/lib/saci.jar";
        $code = $_POST["code"];
        $input = $_POST["input"];
        $filename_code = "code/$folder_session_name/program/main/Program.cyan";	
        $filename_run = "code/$folder_session_name/program";
        $filename_in = "code/$folder_session_name/program/input.txt";
        $filename_error = "code/$folder_session_name/program/error.txt";
        $runtime_file = "code/$folder_session_name/program/runtime.txt";
        $compile = "java -jar ".$CC." -noexec ".$filename_run;
        $execute = "bash ".$filename_run."/program";
        $compile_get_error = $compile." > ".$filename_error;
        $out = "code/$folder_session_name/program/output.txt";
        
        // Write the code inputed by user
        $file_code = fopen($filename_code, "w+");
        fwrite($file_code, $code);
        fclose($file_code);
        
        // Write the value inputed by user (create even when input field ins empty)
        if(trim($input) != ""){
            $file_in=fopen($filename_in,"w+");
            fwrite($file_in, $input);
            fclose($file_in);
        }
        // Check if there's compilation time errors
        shell_exec($compile_get_error);
        $error = nl2br(file_get_contents($filename_error)); 

        // Error and Input field logic. Returns the compiled code or error text to frontend
        $compilation_time_start = microtime(true);
        if(trim($error) == ""){
            if(trim($input) == ""){
                shell_exec("$execute > $out");
                echo nl2br(file_get_contents($out));
            } else {			
                $execute = $execute." < ".$filename_in;
                shell_exec("$execute > $out");
                echo nl2br(file_get_contents($out));
            }
        } else {
            echo $error;
        }
        $executionEndTime = microtime(true);
        $seconds = $executionEndTime - $executionStartTime;
        $seconds = sprintf('%0.2f', $seconds);
        
        // Remove all files and folders created each session after 2 seconds
        exec("rm -rf code/$folder_session_name");
    ?>
</div>
<div style="color: yellow;">
    <?php
        echo "<br>";
        echo "<pr>Compiled and Executed in: $seconds s</pr>";
        echo "<br>";
    ?>
</div>
<div style="color: #00aa00;">
    <?php
        echo "<pr>Hey! <a href='http://cyan-lang.org/downloads/'>Why not install the Cyan compiler in your machine?</a></pr>"
    ?>
</div>