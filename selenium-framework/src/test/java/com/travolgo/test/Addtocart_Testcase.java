package com.travolgo.test;

import java.time.Duration;
import org.testng.Assert;
import org.testng.ITestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.travolgo.pages.LoginPOM;
import com.travolgo.pages.SearchPOM;

public class Addtocart_Testcase {
	// Do login using LoginPOM and search using SearchPOM
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	private static Logger logger = LogManager.getLogger(Addtocart_Testcase.class);

	@BeforeSuite
	// extent report use this then line 64
	public void setupReport() {
		String reportPath = System.getProperty("user.dir") + "/reports/Amazon_AddToCart_Report.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

		spark.config().setDocumentTitle("Amazon Automation Test Report");
		spark.config().setReportName("Add To Cart Test Execution Report");
		spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Hariprajaa");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		logger.info("✅ Extent report initialized");
	}
	@BeforeTest
	void setup() {
		driver = new ChromeDriver();
//		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.get(
				"https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5km84u9k2k_e&adgrpid=155259813113&hvpone=&hvptwo=&hvadid=674842289479&hvpos=&hvnetw=g&hvrand=5565983177309888141&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062046&hvtargid=kwd-304880464215&hydadcr=14450_2316420&gad_source=1");
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		WebElement website = driver.findElement(By.id("APjFqb"));
//		website.sendKeys("amazon.in",Keys.ENTER);
//		WebElement open = driver.findElement(By.xpath("//div[@class='GUyUUb']//div//div[@class='uEierd']//div//div//span[contains(text(),'Shop online at Amazon India')]"));
//		open.click();
//		logger.info("opened amazon");
	}
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Addingtocart() {
		test = extent.createTest("Add to Cart Test");
		try {
			// Login section LoginPOM
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement login_module = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
			login_module.click();
			test.info("Clicked login module");
			LoginPOM ls = new LoginPOM(driver);
			ls.Email_value("archana1575@gmail.com");
			ls.Click_continue_button();
			ls.Password_value("hariprajaa13");
			ls.Click_signin_button();
			test.info("Entered login credentials");
			test.pass("Logged in successfully");
			// Search section SearchPOM
			SearchPOM search = new SearchPOM(driver);
			search.search_field("pencil box for kids");
			test.info("Searched for product");
			test.pass("Search implemented sucessfully");
			// Add to cart
			WebElement add_button = driver.findElement(By.id("a-autoid-7-announce"));
			add_button.click();
			test.info("Clicked add to cart button");
			// Validate cart count
			WebElement cart_count = driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
			int cart_value = Integer.parseInt(cart_count.getText());
			Assert.assertTrue(cart_value > 0, "Item added successfully");
			test.pass("✅ Item successfully added to cart");
			// go to cart
			WebElement cart_button = driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']"));
			cart_button.click();
			// click buy button
			WebElement Buy_button = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
			Buy_button.click();
			// continue
			WebElement continue_button = driver.findElement(
					By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[2]/div/div/span[1]/span/span/span/a"));
			continue_button.click();
			// radio button
			WebElement Radio_button = driver.findElement(By.xpath(
					"/html/body/div[5]/div[1]/div/div/div[2]/div/div[9]/div[2]/div[2]/div/div/div[1]/form/div/div/div/div/div[5]/div/div/div/div/div[1]/div/label/input"));
			Radio_button.click();
			// enter upi id
			WebElement upi_id = driver.findElement(By.xpath("//input[@placeholder='Enter UPI ID']"));
			upi_id.sendKeys("hariprajaa05-1@okhdfcbank");
			// verify button
			WebElement verify_button = driver
					.findElement(By.xpath("//input[@name='ppw-widgetEvent:ValidateUpiIdEvent']"));
			verify_button.click();
			// click continue
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[contains(text(),'Please press continue to complete the purchase')]")));
			test.info("Success message appeared!");
			// Wait until the Continue button is clickable, then click
			WebElement continueButton = wait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@id=\"checkout-secondary-continue-button-id\"]")));
			continueButton.click();
			test.info("Continue button clicked!");
			Thread.sleep(2000);
			WebElement againcontinueButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"/html/body/div[5]/div[1]/div/div/div[1]/div/div[3]/div/div/form/span[1]/span/span/input")));
			againcontinueButton.click();
			test.info("Continue button clicked!");
		} catch (Exception e) {
			test.fail("Test failed due to exception: " + e.getMessage());
			logger.error("Test failed", e);
			Assert.fail("Test failed: " + e.getMessage());
		}
	}

	@AfterSuite
	public void tearDown() {
		// ✅ Step 4: Flush report at the end
		if (driver != null) {
			// driver.quit();
		}
		extent.flush();
		logger.info("📄 Report generated successfully!");
	}
}
