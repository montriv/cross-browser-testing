package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import config.BrowserFactory;

public class LoginTest {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        test = extent.createTest("Login Test on " + browser);

        driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        test.info("Navigated to Login Page");
    }

    @Test
    public void testLogin() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        test.info("Entered credentials and clicked login");
        
        driver.navigate().to("https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
        test.pass("Login successful");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            test.info("Browser closed");
        }
        extent.flush();
    }
}
