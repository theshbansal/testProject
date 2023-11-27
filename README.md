
## Purpose :

This Project contains API QE automation for Utils module using Rest assured, TestNG, and Allure reports

## Tools / libraries used :

1. Java
2. Rest Assured
3. TestNG
4. Maven
5. Allure

## Steps to start:

1. Fork and clone the repository on local system
2. Import maven project in your favourite IDE (Eclipse/Intellij)
3. Execute the following Maven command's
    - mvn clean :- To clean the maven repo
    - mvn install :- To install the maven requirments
4. Include/Exclude testcases using TestNG.xml file.

```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="SFTP Token Tests">
    <test name="API Validations">
        <classes>
            <class name="com.caseapis.externalcaseapi.V1Token_POST"/>
            <class name="createCaseV1"/>
        </classes>
    </test>
</suite>
```

## How to start execution

Run following maven command

```
mvn clean test
```

## How to view allure reports

1. Install allure on fedora with following commands

```
sudo apt-add-repository ppa:qameta/allure
sudo apt-get update
sudo apt-get install allure
```

2. Once test case execution is complete run below command

```
 allure serve allure-results
```