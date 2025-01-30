package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import tools.ExtractData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {

    public WebDriver driver;

    public DemoPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://seleniumbase.io/demo_page");
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "myButton")
    WebElement myButton;

    @FindBy (id = "readOnlyText")
    WebElement readOnlyTextField;

    @FindBy (id = "myDropdown")
    WebElement hoverDropdown;

    public void clickMyButton(){
        myButton.click();
    }

    public String getButtonText()
    {
        return myButton.getText();
    }

    public String getColour(String colour)
    {
        return ExtractData.extractWordInBrackets(colour);
    }

    public String getReadOnlyText()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].value;", readOnlyTextField);
    }

    public void expandHoverDropdown()
    {
        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform the mouse hover action
        actions.moveToElement(hoverDropdown).perform();
    }

    public WebElement initializeDropOption(int position){
        return driver.findElement(By.id("dropOption" + position));
    }
    public void clickLinkOne(WebElement element)
    {
        element.click();
    }

    public WebElement initializeDroplinkText(int position){
        WebElement element = null;
        switch (position) {
            case 1:
                element = driver.findElement(By.xpath("//h3[normalize-space()='Link One Selected']"));
                break;
            case 2:
                element =  driver.findElement(By.xpath("//h3[normalize-space()='Link Two Selected']"));
                break;
            case 3:
                element =  driver.findElement(By.xpath("//h3[normalize-space()='Link Three Selected']"));
                break;
        }
        return element;
    }

    public String getDroplinkText(WebElement element)
    {
        return element.getText();
    }
}
