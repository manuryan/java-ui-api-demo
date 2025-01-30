package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import ui.data.HoverLinkData;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.pages.DemoPage;

public class DemoTest extends ui.base.BaseTest {
    @Test (description = "First Test in Demo Project")
    @Story("User clicks on button to reveal colour")
    @Description("This test verifies that the color retrieve matches the click.")
    @Severity(SeverityLevel.MINOR)
    public void firstTest() {
        DemoPage demoPage = new DemoPage(driver);
        demoPage.clickMyButton();
        String buttonText = demoPage.getButtonText();
        String color = demoPage.getColour(buttonText);
        String readOnlyText = demoPage.getReadOnlyText();
        Assert.assertEquals("The Color is " + color, readOnlyText);
    }

    @Test (dataProvider = "hoverLinkData", dataProviderClass = HoverLinkData.class)
    @Story("User hovers over link for dropdown menu")
    @Description("This test each click in the menu against the text revealed.")
    @Severity(SeverityLevel.CRITICAL)
    public void secondTest(int position, String linkText)
    {
        DemoPage demoPage = new DemoPage(driver);
        demoPage.expandHoverDropdown();
        demoPage.clickLinkOne(demoPage.initializeDropOption(position));
        Assert.assertEquals(demoPage.getDroplinkText(demoPage.initializeDroplinkText(position)), linkText);
    }
}