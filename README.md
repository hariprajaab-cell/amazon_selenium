Amazon Add to Cart Automation (Selenium + TestNG)

This project automates the Amazon Add to Cart and Checkout flow using Selenium WebDriver, TestNG, and Extent Reports.
It demonstrates end-to-end automation including login, product search, add-to-cart, cart validation, and checkout steps.

🚀 Tech Stack Used
  Java
  Selenium WebDriver
  TestNG
  Extent Reports
  Log4j
  Maven
  ChromeDriver

📌 Features Automated
  Open Amazon website
  Login using valid credentials
  Search for a product
  Add product to cart
  Validate cart count
  Navigate to cart
  Proceed to checkout
  Select payment method (UPI)
  Verify UPI ID
  Continue checkout flow
  Generate detailed Extent Report

⚠️ Important Note (Manual Steps)

 Due to Amazon security restrictions, the following steps CANNOT be automated and are handled manually:
"I’m not a robot" (CAPTCHA)
 OTP verification during login
🔹 Once these manual steps are completed, the remaining flow is fully automated using Selenium + TestNG.

🧪 Framework Design

  Page Object Model (POM)
    LoginPOM → Handles login functionality
    SearchPOM → Handles product search
  Retry Mechanism
    Implemented using IRetryAnalyzer
  Reporting
    Detailed execution report using Extent Reports
  Logging
    Logging implemented using Log4j


How to Run the Test :

Clone the repository:
  git clone https://github.com/your-username/amazon-add-to-cart-automation.git
Open the project in your IDE (Eclipse / IntelliJ)
Ensure:
  Chrome browser is installed
  ChromeDriver version matches your Chrome version
Run the TestNG test:
  Addtocart_Testcase.java

During execution:
  Complete CAPTCHA manually
  Enter OTP manually when prompted
