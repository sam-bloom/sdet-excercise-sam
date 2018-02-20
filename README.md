# sdet-excercise-sam

This sdet exercise project is developed using BDD framework and has four scenarios includes 2 negative and 2 positive scenarios.

Below componenets are using in this BDD framework: 
RESTassured for webservices tests
Cucumber for BDD and Test data handling
Serenity for reporting

I have used jdk 1.8 to run the profile

To run simple maven build: clean verify serenity:aggregate

To run as maven build to test all the scenarios: clean verify -Dcucumber.options="--tags @TEST" serenity:aggregate

To run as maven build only with positive test scenarios: clean verify -Dcucumber.options="--tags @POSITIVE" serenity:aggregate

To run as maven build only with positive test scenarios: clean verify -Dcucumber.options="--tags @NEGATIVE" serenity:aggregate

Report: After test execution Serenity can be accessed in /sdet-excercise-sam/target/site/serenity/index.html 
