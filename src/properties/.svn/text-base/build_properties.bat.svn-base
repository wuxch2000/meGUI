@echo off
set source=VideoFileField Dialog

set native2ascii="D:\Program Files\Java\jdk1.7.0\bin\native2ascii.exe"
REM set native2ascii=native2ascii.exe
set encode_arg=-encoding gb2312
set zh=_zh
set zh_CN=_zh_CN
set suffix=.properties

for %%s in (%source%) do %native2ascii% %encode_arg% %%s%zh%%suffix% %%s%zh_CN%%suffix%

echo convert ok
pause
