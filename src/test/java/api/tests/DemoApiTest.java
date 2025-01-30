package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoApiTest extends api.base.BaseTest {

    @Test
    @Story("Retrieve a list of users")
    @Description("This test verifies that a list of users can be retrieved and is accurate.")
    @Severity(SeverityLevel.MINOR)
    public void testGetUser(){

        Response response = request.get("/users/2");

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        String email = response.jsonPath().getString("data.email");
        Assert.assertEquals(email, "janet.weaver@reqres.in", "Email does not match");

        String firstName = response.jsonPath().getString("data.first_name");
        Assert.assertEquals(firstName, "Janet", "First name does not match");
    }
}