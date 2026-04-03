Arogga Automation Framework
A robust Hybrid Selenium Automation Framework designed for testing the Arogga web application. This project implements the Page Object Model (POM) design pattern combined with Data-Driven Testing for maximum scalability and maintainability.

🚀 Project Features
Design Pattern: Page Object Model (POM).

Build Tool: Maven.

Testing Framework: TestNG.

Data-Driven: Integrated with Apache POI to read test data from Excel.

Logging: log4j for detailed execution logs.

Reporting: Extent Reports for rich HTML reports with embedded screenshots.

Event Listening: Custom WebDriverListener for automatic action logging.

----

Folder Structure:
├── src/main/java
│   ├── pages/            # Page Object classes (Business logic)
│   ├── uistore/          # Element Locators (XPaths, CSS Selectors)
│   └── utils/            # Framework Utilities (Base setup, Excel, Reports, Screenshots)
├── src/test/java
│   └── runner/           # TestNG execution files
├── config/               # Global properties and environment settings
├── testdata/             # Excel files for data-driven testing
├── logs/                 # Execution log files
├── reports/              # Generated HTML test reports
├── testng.xml            # Test suite configuration
└── pom.xml               # Project dependencies and plugins

----
🛠️ Prerequisites
Java JDK 11 or higher.

Maven installed and configured in system PATH.

Chrome or Firefox browser installed.

🏃 How to Run the Tests
1. Using Terminal/CLI
Navigate to the project root directory and execute:
mvn clean test

📊 Reports & Logs
Execution Report: After running tests, open reports/execution-report.html in any browser to view the visual results and screenshots.

Logs: Detailed step-by-step logs can be found in logs/logfile.log.

🔧 Configuration
You can modify global settings in config/browser.properties:

Change browser=chrome to browser=firefox to switch browsers.

Update the url to point to different environments (Staging/Production).

📝 Test Scenarios Included
Login Module Test:

Navigating to the homepage.

Interacting with the footer and Careers link.

Testing the Referral Code functionality with external data.

Verifying OTP error messages.
