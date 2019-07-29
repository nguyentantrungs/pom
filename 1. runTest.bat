cd C:\Test\DAClient
mvn clean verify -Dtest=testrunner -Dmaven.test.failuer.ignore=true -Dcucumber.options="src/test/java/features/test.feature" > "target/execution_logs.txt"