# OrangeHRM Selenium Automation Framework

## Overview

This project is a Selenium-based automation framework designed for testing the OrangeHRM web application. It includes a set of test cases and page object classes to improve test maintainability and readability.

## Features

* Page Object Model (POM): Organizes UI elements and interactions into reusable page classes.
* TestNG Framework: Used for test execution, reporting, and management.
* WebDriver Management: Uses WebDriver to automate browser interactions.
* Modular Design: Separates test logic, page interactions, and base setup for better maintainability.
* Test Cases:
   
     * Login
     * User Registration
     * Employee Creation
     * Search Functionality
     * News feed (Share Photo and Video)

## Getting Started

### Prerequisites

* Java Development Kit (JDK): Version 8 or higher.
* Web Browser: Chrome 
* IDE (Integrated Development Environment): IntelliJ IDEA, Eclipse, or similar.
* Selenium WebDriver: Included as a dependency (see `pom.xml`).
* WebDriverManager: Included as a dependency to manage the browser drivers.

### Installation

1.  **Clone the repository:**

    ```bash
    git clone (https://github.com/buddhini12/Selenium_WebAutomation.git)
    ```

2.  **Open the project in your IDE:**

    * Import the project as a Maven project.

3.  **Set up dependencies:**

    * The project uses Maven to manage dependencies. Your IDE should automatically download the required libraries (Selenium WebDriver, TestNG, etc.) when you build the project.
    * If you face any issues, ensure that your IDE is configured to use the correct Maven settings and that your internet connection is working.

4.  **Configure Browser Driver:**

    * This project uses WebDriverManager, so you do not need to manually download and configure the browser drivers.

### Configuration

* **Base URL:** The base URL for the OrangeHRM application is defined in the `BaseTest.java` class. You can modify it there if needed:

    ```java
    protected String orangeHRMUrl = "[https://opensource-demo.orangehrmlive.com/web/index.php/auth/login]";
    ```

* **Test Data:** Test data (usernames, passwords, etc.) is currently hardcoded in the test classes. For more robust testing, consider using external data sources like Excel files or property files. If you use external files, create a  `resources`  directory.

### Running the Tests

1.  **Build the project:** Use your IDE's build command (e.g., "Build Project" in IntelliJ IDEA) or use the Maven command:

    ```bash
    mvn clean install
    ```

2.  **Run the tests:**

    * In your IDE, locate the test classes (under `src/test/java`) or the TestNG configuration file (if you have one).
    * Right-click on the class or configuration and select "Run" (or a similar option).
    * TestNG will execute the tests, and the results will be displayed in the IDE's console or test runner window.
    * You can also run the tests from the command line using Maven:

        ```bash
        mvn test
        ```

## Test Results

* Test results are displayed in the IDE's console or test runner, depending on how you run the tests. TestNG provides a detailed report of the test execution, including the number of tests passed, failed, and skipped.
* The reports are typically stored in the `target/surefire-reports` directory.

## Page Object Classes

* `BasePage`: Provides common functionality for all page classes (WebDriver initialization, waiting for elements, etc.).
* `LoginPage`: Handles interactions on the OrangeHRM login page.
* `RegistrationPage`: Handles interactions on the Registration Page.
* `AddEmployeePage`: Handles interactions on the Add Employee page.
* `SearchPage`: Handles interactions on the Search Page.
* `NewsPage`: Handles interactions on the News Page.

## Test Cases

* `LoginTest`: Tests the login functionality.
* `RegistrationTest`: Tests the Registration functionality.
* `AddEmployeeTest`: Tests the functionality of adding a new employee.
* `SearchUserTest`: Tests the functionality of adding a new employee.
* `NewsPageTest`: Tests the News feed functionality.


