net stop "Desktop Alerting Server"  || net start "Desktop Alerting Server" 
net start "Desktop Alerting Server"

:WAIT
timeout /t 5 > NUL
for /f "tokens=4" %%s in ('sc query "Desktop Alerting Server" ^| find "STATE"') do if NOT "%%s"=="RUNNING" goto WAIT
echo Service is now running!
exit