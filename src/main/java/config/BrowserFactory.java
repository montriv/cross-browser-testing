package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeOptions;

public class BrowserFactory {
    public static WebDriver getDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
/*            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
                return new EdgeDriver(edgeOptions); */
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}
