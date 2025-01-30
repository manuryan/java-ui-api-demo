# **E2E UI Test Framework**
This project is a simple End-to-End (E2E) UI testing framework built with a combination of tools to ensure to showcase API and UI Automation.

## **Tools Used**
Java: The primary programming language for writing test scripts.
Maven: A build automation tool used to manage dependencies and the project's lifecycle.
TestNG: The testing framework for running and organizing tests.
Allure: A reporting framework to generate attractive, user-friendly reports for test execution results.
GitHub Actions: A CI/CD tool for automating the testing process.

## **Features**
End-to-End Testing: Verifies the full workflow of the application by simulating real user interactions.
Parallel Test Execution: Showcasing API and UI tests running in parallel.
Detailed Reporting: Allure generates detailed and user-friendly reports after test execution.
CI/CD Pipeline: GitHub Actions automates the running of tests with every code change.

---

## **Getting Started**

### **Prerequisites**

- Java 11 or higher
- Maven 3.6+ or higher
- GitHub account (for CI/CD integration)

### **Installation**
Clone the repository:

'git clone https://github.com/manuryan/java-ui-api-demo.git
cd java-ui-api-demo'

### **Install dependencies using Maven:**

`mvn clean install`

### **Build and Run Tests**
To build the project and run all tests, use the following Maven commands:

`mvn clean install -DskipTests
mvn test`

---

## **Viewing the Allure Report**

The latest Allure report for this project can be viewed online:

[here:](https://manuryan.github.io/java-ui-api-demo)
