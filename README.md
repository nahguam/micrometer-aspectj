# Micrometer AspectJ `@Timed` Examples

# Compile-Time Weaving

* Requires `aspectjrt` as a runtime dependency
* Requires `aspectj-maven-plugin` to weave aspects during compilation
* Requires that the original `micrometer-core` dependency is excluded at runtime so only weaved classes are available
* Metrics are available in tests when built by Maven 
* Metrics are only available in tests in Intellij Ultimate 

Run example: 
```shell
mvn clean package -f micrometer-assertj-ctw
java \
  -jar micrometer-aspectj-ctw/target/micrometer-aspectj-ctw-1.0-SNAPSHOT.jar
```

# Load-Time Weaving

* Requires `aspectjweaver` as a javaagent at runtime
* Requires a configured `aop.xml` on the classpath at runtime
* Metrics are only available at runtime, not when built by Maven or in IDE

Run example:
```shell
mvn clean package -f micrometer-assertj-ltw
java \
  -javaagent:micrometer-aspectj-ltw/target/dependency/aspectjweaver-1.9.20.jar \
  -jar micrometer-aspectj-ltw/target/micrometer-aspectj-ltw-1.0-SNAPSHOT.jar
```
