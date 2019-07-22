cd C:\Test\DAClient
mvn clean install -Dtest=testrunner -Dmaven.test.failuer.ignore=true -Dcucumber.options="src/test/java/features/test.feature"
cmd /k