cd "C:\Dropbox\Cyan\CC"
del saci.jar
del sacilib.jar
del saci.jar.tmp*
del sacilib.jar.tmp*
jar cvfe saci.jar saci.Saci -C bin .
"C:\Program Files\7-Zip\7z" d saci.jar .git -r
copy /Y saci.jar "C:\Dropbox\Cyan\lib"
pause
jar cvf sacilib.jar -C bin .
"C:\Program Files\7-Zip\7z" d sacilib.jar .git -r
copy /Y sacilib.jar "C:\Dropbox\Cyan\lib"
pause


