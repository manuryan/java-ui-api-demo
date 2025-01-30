package ui.data;

import org.testng.annotations.DataProvider;

public class HoverLinkData {

    @DataProvider
    public Object[][] hoverLinkData() {
        return new Object[][] {
                {1, "Link One Selected"},
                {2, "Link Two Selected"},
                {3, "Link Three Selected"}
        };
    }
}