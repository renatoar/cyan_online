.\saci -nojavac -noexec "C:\Dropbox\Cyan\cyanTests\empty\compileCyanLang.pyan"
pause 
cd java-for-cyan_lang
REM "C:\Program Files\Java\jdk-11.0.2\bin\javac" -Xlint:deprecation -cp ".;c:\dropbox\cyan\lib\cyanruntime.jar" cyan/lang/*.java  
"C:\Program Files\Java\jdk1.8.0_241\bin\javac" -Xlint:deprecation -cp ".;c:\dropbox\cyan\lib\cyanruntime.jar" cyan/lang/*.java  

jar cf cyan.lang.jar cyan
move cyan.lang.jar ..
cd ..
pause
REM ../../cyanTests/java-for-empty/cyan/io/*.java
REM ;C:\Dropbox\Cyan\lib\cyan.io.jar;C:\Dropbox\Cyan\cyanTests\java-for-empty