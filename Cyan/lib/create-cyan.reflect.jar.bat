.\saci -nojavac -noexec "C:\Dropbox\Cyan\cyanTests\empty\compileCyan_reflect.pyan" -java -cp "C:\Dropbox\Cyan\lib\sacilib.jar;C:\Dropbox\Cyan\lib\cyanruntime.jar"

pause 
cd "C:\Dropbox\Cyan\cyanTests\java-for-empty"

dir /s /B *.java > sources.txt

REM "C:\Program Files\Java\jdk-11.0.2\bin\javac" -Xlint:deprecation -cp ".;C:\Dropbox\Cyan\lib\sacilib.jar;C:\Dropbox\Cyan\lib\cyan.lang.jar;c:\dropbox\cyan\lib\cyanruntime.jar" @sources.txt

"C:\Program Files\Java\jdk1.8.0_241\bin\javac" -Xlint:deprecation -cp ".;C:\Dropbox\Cyan\lib\sacilib.jar;C:\Dropbox\Cyan\lib\cyan.lang.jar;c:\dropbox\cyan\lib\cyanruntime.jar" @sources.txt

REM "C:\Dropbox\Cyan\cyanTests\java-for-empty\cyan\reflect\*.java"  "C:\Dropbox\Cyan\cyanTests\java-for-empty\cyan\lang\*.java" 

pause

jar cf cyan.reflect.jar cyan\reflect\*.class cyan\lang\*.class
 
move cyan.reflect.jar "C:\Dropbox\Cyan\lib"

pause

