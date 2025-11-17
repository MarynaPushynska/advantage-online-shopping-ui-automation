Advantage Online Shopping — UI Automation Framework


Automated UI Testing Framework using Java, Selenium, Cucumber, TestNG (POM Architecture)
**Created by Maryna Pushynska**


🚀 Project Overview:

This is an automated UI testing framework for the Advantage Online Shopping website.
The project follows:
 • Java + Selenium WebDriver
 • Cucumber (BDD)
 • JUnit Runner
 • Page Object Model (POM)
 • Full regression + smoke test suite
 • Reusable utilities + centralized configuration

The goal of the project is to demonstrate professional skills in:

✔ UI test automation
✔ architecture design
✔ BDD approach
✔ writing scalable and maintainable automated tests
✔ working with Git & GitHub

📁 Project Structure

advantage-online-shopping-ui-automation
│
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── com.maryna.advantage
│   │   │   │   ├── pages          → Page Object classes
│   │   │   │   ├── step_definitions → Cucumber step definitions
│   │   │   │   ├── runners        → Test runners (Smoke/Regression)
│   │   │   │   ├── utilities      → Driver, ConfigReader, BrowserUtils
│   │   ├── resources
│   │   │   └── feature            → Cucumber feature files
│
├── pom.xml
├── configuration.properties
├── README.md   ← you are here ❤️


🔧 Technologies Used:

Tool / Library Purpose
Java 17 Programming language
Selenium WebDriver UI automation
Cucumber JVM BDD scenarios
JUnit Test runner
Maven Dependency management
Page Object Model (POM) Framework architecture
Git / GitHub Version control


⚙️ How to Run Tests:

✔ 1. Clone the repository
https://github.com/MarynaPushynska/advantage-online-shopping-ui-automation.git

✔ 2. Open in IntelliJ IDEA
File → Open → select project folder.

✔ 3. Install Maven dependencies
IntelliJ will load automatically — or run:

mvn clean install
✔ 4. Configure browser in configuration.properties

baseUrl=https://www.advantageonlineshopping.com/#/

browser=chrome

timeout=10

✔ 5. Run Smoke Suite

Go to:
runners → CukesRunner.java
Right-click → Run


🧪 Test Scenarios

My suite includes:

✔ Login Tests
 • Successful login
 • Failed login
 • Logout validation

✔ Registration Tests
 • Register new unique user
 • Attempt to register existing user
 • Validation message checks

✔ Search Tests
 • Search by keyword
 • Validate search results
 • Open first product

✔ Product Page Tests
 • Add product to cart
 • Validate PDP details
 • Open product from search

✔ Cart Tests
 • Add item to cart
 • Validate cart quantity
 • Validate specific product is present
 • Remove item

✔ Checkout Tests
 • Open checkout
 • Validate order information
 • Payment screen navigation

✔ Profile Tests
 • Open My Account
 • Validate user data
 • Navigate through profile tabs


Author:
Maryna Pushynska
QA Automation Engineer
📍 Austin, TX
📧 pushinskam@gmail.com
