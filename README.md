# Project Title:  
Cross-Browser Automated Testing with Selenium, TestNG, and Jenkins

# Project Description:
This project aims to automate the testing of a web application across multiple browsers, including Chrome, Firefox, and Edge, to ensure consistent user experience and functionality. The automated test framework is built using Selenium WebDriver and TestNG, with the test execution and reporting managed through a CI/CD pipeline in Jenkins.

# Key Objectives:
* Browser Compatibility: Ensure the application performs consistently on various web browsers.
* Automation: Minimize manual testing efforts through automated scripts.
* CI/CD Integration: Implement automated test execution using Jenkins.
* Reporting: Generate detailed HTML reports using Extent Reports.
* Scalability: Support for adding more browsers or test cases with minimal configuration.

# Technologies and Tools Used:
Programming Language: Java
Automation Framework: Selenium WebDriver
Test Framework: TestNG
Dependency Management: Maven
CI/CD Tool: Jenkins
Browser Drivers: Managed using WebDriverManager
Reporting: Extent Reports
Version Control: GitHub
Build Tool: Maven
Operating Systems: Windows

# Features Implemented:
## Cross-Browser Testing:
* Automates testing on multiple browsers (Chrome, Firefox, Edge).

* Uses WebDriverManager for automatic driver setup.

## Parameterized Test Execution:

* Tests are parameterized to support dynamic browser selection via TestNG XML.

* Parallel execution to speed up the testing process.

## Continuous Integration (CI):

* Jenkins pipeline triggers test execution upon code changes.

* Automated build, test, and report generation.

## Test Reporting:

* Generates comprehensive HTML reports using Extent Reports.

* Stores test results as artifacts for easy access.

## Notifications:

* Email notifications on test success or failure.
