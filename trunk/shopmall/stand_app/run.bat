@echo off
set CLASSPATH=.\bin;
rem Add all jars....
for %%i in (".\lib\*.jar") do call ".\cpappend.bat" %%i
for %%i in (".\lib\*.zip") do call ".\cpappend.bat" %%i

java -cp "%CLASSPATH%" -Xms128m -Xmx512m com.eh.jingdong.GetProductDetail
pause