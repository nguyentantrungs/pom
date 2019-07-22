cd C:\Test\Report
del /Q /S *
xcopy C:\Test\DAClient\target /E
cd C:\Test\DAClient
mvn install -Dtest=testrunner -Dmaven.test.failuer.ignore=true -Dcucumber.options="src/test/java/features/send_email_report.feature"
cmd /k