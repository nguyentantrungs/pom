cd C:\Test\DAClient
mvn verify -Dtest=testrunner -Dmaven.test.failuer.ignore=true -Dcucumber.options="src/test/java/features/test.feature" > "target/execution_logs.txt"