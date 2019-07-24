taskkill /f /im explorer.exe && start explorer.exe
:WAIT
timeout /t 5 > NUL
exit 0