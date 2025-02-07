package api.data;

import org.testng.annotations.DataProvider;

public class ApiData {

    @DataProvider
    public Object[][] userPostRequest() {
        return new Object[][] {
                {"morpheus", "leader"}
        };
    }
}