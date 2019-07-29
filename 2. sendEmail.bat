cd C:\Test\Report\temp
DEL /S /Q *
xcopy C:\Test\DAClient\target /E /Y
cd C:\Test\DAClient
mvn install -Dtest=testrunner -Dmaven.test.failuer.ignore=true -Dcucumber.options="src/test/java/features/send_email_report.feature"