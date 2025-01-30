package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver getDriver(String browser){
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                // Create ChromeOptions object
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // Run Chrome in headless mode
                options.addArguments("--disable-gpu"); // Disable GPU for headless mode

                // Create ChromeDriver instance with options
                driver = new ChromeDriver(options);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
