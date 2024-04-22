# Teladoc Challenge 

This repository contains a challenge for https://www.way2automation.com/angularjs-protractor/webtables/ 

The test are build with `selenium-cucumber-java`, a BDD (Behavior-Driven Development) framework with Cucumber (v 3.0.0) and Java.

##Installation & Prerequisites

1. JDK 1.8+ 
2. Maven 
4. IDE 
- Required Plugins:
   - Maven
   - Cucumber
5. Browser driver 

## Running Sample Tests

Open the CLI. On the project directory Then, run the following command to execute the features: `mvn clean test`. 
By default, this command will invoke the google chrome browser and execute the tests.

- To run a specific feature use the command: `mvn test -Dcucumber.options="classpath:features/my_first.feature"`.





## Reporters

Once you have run your tests, you can generate various types of reports. This `selenium-cucumber-java` framework use allure reports.


## Reporting

### Allure Report

To generate an Allure report make sure you have allure cli command installed and configure, you can use one of the following commands:

After execute `mvn clean test`, open a CLI and move to the target folder then execute 
`allure generate --clean` for create de report 
`allure open` for open the report on the browser

