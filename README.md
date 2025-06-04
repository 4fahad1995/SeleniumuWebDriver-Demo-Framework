# SeleniumuWebDriver-Demo-Framework

This project is designed and developed with the help of - 
Udemy course (Rahul Shetty - "TOP RATED #1 Master SELENIUM java 4 (Latest) course" -5 Million students learning worldWide with great collaboration)

I used knowledge gained throughout the course to develop a testing framework for a demo e-commerce application as part of my self-initiative.

The website I used for automation is Swag Labs (https://www.saucedemo.com/)

## Technology Stack:
1. Programming language - `Java`
2. Build and project management tool - `Maven`
3. Testing framework - `TestNG`
4. Automation framework - `Selenium WebDriver`

<h2 id="folder-structure">Folder Structure</h2>
<pre><code>
EComAutoProject/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pageObjectRepository/
│   │       │   ├── LoginPage.java                      //Login Page 
│   │       │   ├── PageObject.java                     //For invoking Login Page, Product Page, and Side Menu & Sub Menu Page
│   │       │   ├── ProductsPage.java                   //Product Page with Product Sort Container
│   │       │   └── SideMenu.java                       //Side Menu with Logout Button
│   │       │
│   │       ├── testBase/
│   │       │   └── BaseTest.java                       //Base class - creates driver object, properties file object. setter and getter
│   │       │                                           //methods to get WebDriver object.
│   │       └── utils/
│   │           ├── DateUtil.java                       //For date utility 
│   │           ├── ExtentReport.java                   //For generating reports
│   │           ├── ListenersImpl.java                  //For listening test case status
│   │           └── TakeScreenShot.java                 //For capturing failure screenshots and attching to reports
│
│   ├── test/
│   │   ├── java/
│   │   │   └── testCases/
│   │   │       ├── Error_Scenario_Test.java            //Test for failure scenarios automation
│   │   │       └── E2E_ECom_Automation.java            //Test for successful end to end automation
│
├── Reports/
│   └── Screenshots/
│    ├── ExecutionReport_09-12-2023 15-10-09.html
│    └── ExecutionReport_09-12-2023 15-15-37.html
│
├── test-output/
├── target/
├── pom.xml
├── testng.xml
└── README.md
</code></pre>

## Tasks:
1. Automate 3 negative scenarios and 1 successful end to end test run (described below)
2. Required Design Patterns: `Page Object + Page Factory`
5. Project should be shared on `Github`.
6. Tests should work in `Firefox` browsers.
7. If test fails, attach screenshot, date and time to your report.

## Test Plan:
### Negative Scenario-1 Invalid Username and Password
1.	Go to login page `https://www.saucedemo.com/`
2.	Enter invalid_user / wrong_pass into the fields
3.	Click 'Login' button 

Expected result: The error message when invalid user trying to login is not as expected.

### Negative Scenario-2 Verify the ability to add product to cart without login 
1.	Go to `https://www.saucedemo.com/inventory.html` directly

Expected result: Redirected to login page

### Negative Scenario-3 Verify the ability to use browser back after logout
1.	Go to login page `https://www.saucedemo.com/`
2.	Enter the required user id and password.
3.	Click 'Logout' from top left of the side menu button after login.
4.	Click the back button after logout.

Expected result: We were unable to access inventory page without login.

**How to run the Project from Local machine**
1. Pull the code into your machine and import in IDE (Eclipse/intelliJ).
2. This project is recommended to be run from testng.xml in order to generate extent reports and attach screenshots.
