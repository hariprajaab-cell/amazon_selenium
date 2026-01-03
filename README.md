Amazon Add to Cart Automation (Selenium + TestNG)

This project automates the Amazon Add to Cart and Checkout flow using Selenium WebDriver, TestNG, and Extent Reports.
It demonstrates end-to-end automation including login, product search, add-to-cart, cart validation, and checkout steps.

🚀 Tech Stack Used :
  Java,
  Selenium WebDriver,
  TestNG,
  Extent Reports,
  Log4j,
  Maven,
  ChromeDriver.

📌 Features Automated :
  Open Amazon website,
  Login using valid credentials,
  Search for a product,
  Add product to cart,
  Validate cart count,
  Navigate to cart,
  Proceed to checkout,
  Select payment method (UPI),
  Verify UPI ID,
  Continue checkout flow,
  Generate detailed Extent Report.

⚠️ Important Note (Manual Steps) :

 Due to Amazon security restrictions, the following steps CANNOT be automated and are handled manually:
1)"I’m not a robot" (CAPTCHA)
2) OTP verification during login
🔹 Once these manual steps are completed, the remaining flow is fully automated using Selenium + TestNG.

🧪 Framework Design:

 1) Page Object Model (POM)
    LoginPOM → Handles login functionality
    SearchPOM → Handles product search
 2) Retry Mechanism
    Implemented using IRetryAnalyzer
 3) Reporting
    Detailed execution report using Extent Reports
 4) Logging
    Logging implemented using Log4j


How to Run the Test :

1)Clone the repository:
  git clone https://github.com/your-username/amazon-add-to-cart-automation.git,
2)Open the project in your IDE (Eclipse / IntelliJ)
3)Ensure:
  Chrome browser is installed
  ChromeDriver version matches your Chrome version
4)Run the TestNG test:
  Addtocart_Testcase.java

5)During execution:
  Complete CAPTCHA manually
  Enter OTP manually when prompted
