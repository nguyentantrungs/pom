set MY_SESSION_ID=unknown
for /f "tokens=2-4" %%a in ('quser') do @if "%%c"=="Active" set MY_SESSION_ID=%%a
%windir%\System32\tscon.exe %MY_SESSION_ID% /dest:console