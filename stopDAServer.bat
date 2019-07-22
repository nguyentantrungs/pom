net stop "Desktop Alerting Server"  


:WAIT
timeout /t 5 > NUL
for /f "tokens=4" %%s in ('sc query "Desktop Alerting Server" ^| find "STATE"') do if NOT "%%s"=="STOPPED" goto WAIT
echo Service is now stopped!
exit