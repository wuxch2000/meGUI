@echo off
SET jar_path=%CD%
SET bin_path=%jar_path%/../bin
SET jar_file=%jar_path%\meGUI.jar
SET menifest_file=%jar_path%\Manifest.txt
SET content_dir=config convert gui images log xml properties

SET jar_command="D:\Program Files\Java\jdk1.7.0\bin\jar.exe"

cd %bin_path%

echo building %jar_file% ...
REM echo %jar_command% vcfm %jar_file% %menifest_file% %content_dir%
%jar_command% cfm %jar_file% %menifest_file% %content_dir%

echo done!

cd %jar_path%

REM jar cf
