# SeleniumuWebDriver-Demo-Framework

This project is designed and developed with the help of - 
Udemy course (Rahul Shetty - "TOP RATED #1 Master SELENIUM java 4 (Latest) course" -5 Million students learning worldWide with great collaboration)

I used knowledge gained throughout the course to develop a testing framework for a demo e-commerce application as part of my self-initiative.

## Technology Stack:
1. Programming language - `Java`
2. Build and project management tool - `Maven`
3. Testing framework - `TestNG`
4. Automation framework - `Selenium WebDriver`

## Tasks:
1. Automate 4 scenarios (described below)
2. Required Design Patterns: `Page Object + Page Factory`
5. Project should be shared on `Github`.
6. Tests should work in `Chrome` browsers.
7. Add switch in code to run tests `locally`/ using `Selenium Grid`/ `SauceLabs`/ `Docker` (user can give params - url, port, etc)
8. If test fails, attach screenshot, date and time, browser, platform version to your report
9. Add cleanup

## Test Plan:
### AP-1 Verify the ability to login
1.	Go to login page `https://rahulshettyacademy.com/client/`
2.	Fill required fields 
3.	Click 'Login' button 

Expected result: You were able to login 

### AP-2 Verify the ability to add products to cart 
1.	Login 
2.	Add 3 different products to cart 
3.	Go to shopping cart

Expected result: All 3 products are in the cart and subtotal is correct 

### AP-3 Verify the ability to select country to place order
1.	Go to payments page 
2.	Search country and select it.
3.	Click 'PLACE ORDER'

Expected result: We were able to select country and place order

### AP-4 Verify whether the order has been placed correctly
1.	Click 'PLACE ORDER' 
2.	Verify the confirmation message for the order.

Expected result: Order is confirmed and message `THANKYOU FOR THE ORDER.` is displayed.

**How to run the Project from Local machine**
1. Pull the code into your machine and import in IDE (Eclipse/intelliJ).
