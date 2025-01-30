package ui.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import tools.DriverFactory;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser)
    {
        driver = DriverFactory.getDriver(browser);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}