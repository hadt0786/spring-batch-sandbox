# spring-batch-sandbox
A project that shows spring batch capabilities and integration with other frameworks (http://projects.spring.io/spring-batch/)

# Project structure
Each sub project follows the structure
Maven project that consists of the following parts:
- Java main classes are under (`src/main/java/main`) with different demo samples
- Test extentions for executing tests with spring batch (`src/test/java`)

# Building project
`mvn clean package`

# Sub projects
- `spring-batch-core-components` contains spring batch components that might be used in other modules
- `spring-batch-default` contains general examples
- `spring-batch-jpa` contains jpa and hibernate examples that conflict with general examples because of spring version higher than spring batch uses

# Pom.xml
Libraries:
- spring-batch-core
- spring-batch-infrastructure
- spring-retry
- spring-jdbc for db population
- commons-dbcp2 for database connection pool
- h2 file based database for ease of db usage
- log4j logging (possibility to configure) via slf4j

Integration with:
- jpa
- hibernate
- mybatis
- mongo
- schedulers: cron and quartz

# Logging
Spring batch logging logic.
- Commons logging is used.
- Commons logging is configured to use Log4j under the hood.

# Spring batch main features demo
##`spring-batch-core-components`
Main components are under `src/main/java/org/spring/batch/infrastructure` folder.
- `completion_policy` for chunk completion
- `listeners` job and step listeners
- `model` contains model to be used in examples
- `partitioner` partitioner implementation
- `processors` step processors
- `readers` step readers
- `scheduler` scheduler components
- `validator` job validators
- `writers` job writers

##`spring-batch-default`
Main features examples are under src/main/java folder. It is simply classes with main methods, that explain the feature and ready to be executed and provide log that shows the results.
- `concurrent` for concurrent features
- `exceptional` for exceptional cases with skips, retries, failed states
- `general` for simple demos with task executor, java config, jdbc xml config
- `in_memory` with in memory simple reader/writers capabilities and integration
- `jsr352` with jsr job description example
- `mybatis` with Mybatis reader/writers capabilities and integration
- `partitioner` with partitioner functionality feature
- `retry` with two samples with stateless and stateful retry
- `scheduler` with scheduling features based on cron and quartz

## `spring-batch-jpa`
Main features examples are under src/main/java folder. It is simply classes with main methods, that explain the feature and ready to be executed and provide log that shows the results.
- `hibernate` with Hibernate reader/writers capabilities and integration (hibernate dependency has dependency conflict. To enable example uncomment hibernate dependency)
- `jpa` with JPA reader/writers capabilities and integration (hibernate dependency has dependency conflict. To enable example uncomment hibernate jpa dependency)

#  Spring batch tests (`spring-batch-default`)
Tests are under `src/test/java`
- `mongo` test with embedded and external modes *NOTE* `mvn clean pre-integration-test -Dembedmongo.wait` to run mongodb locally
- `java_config` test with spring batch java config and invocation of job
- `system_command` test with spring batch command tasklet to run command line command
- `param_passing` test of passing parameters inside one step and between steps
- `retry` test for spring-retry annotation based functionality
- `spring_integration` test for integration of spring batch with spring integration framework. Poller, Transformer, Router, Email sending bz Spring integration and job processing via spring batch.