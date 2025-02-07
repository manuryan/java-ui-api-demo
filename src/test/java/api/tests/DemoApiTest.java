package api.tests;

import api.data.ApiData;
import api.payload.UserPostRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoApiTest extends api.base.BaseTest {

    @Test
    @Story("Retrieve a list of users")
    @Description("This test verifies that a list of users can be retrieved and is accurate.")
    @Severity(SeverityLevel.MINOR)
    public void testGetRequest(){

        Response response = request.get("/users/2");

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        String email = response.jsonPath().getString("data.email");
        Assert.assertEquals(email, "janet.weaver@reqres.in", "Email does not match");

        String firstName = response.jsonPath().getString("data.first_name");
        Assert.assertEquals(firstName, "Janet", "First name does not match");
    }

    @Test (dataProvider = "userPostRequest", dataProviderClass = ApiData.class)
    @Story("Add new users")
    @Description("This test verifies that a user can be created.")
    @Severity(SeverityLevel.NORMAL)
    public void testPostRequest(String firstName, String jobTitle) {

        // Send the POST request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(UserPostRequest.requestBody(firstName, jobTitle))
                .when()
                .post("/posts");

        // Print the response body for debugging
        response.then().log().all();

        // Validate the status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201, "Expected status code 201");

        // Validate the response body
        String responseName = response.jsonPath().getString("name");
        Assert.assertEquals(responseName, firstName, "Expected name to be " + firstName);

        String title = response.jsonPath().getString("job");
        Assert.assertEquals(title, jobTitle, "Expected job to be " + jobTitle);

        int userId = response.jsonPath().getInt("id");
        Assert.assertTrue(userId > 0, "Expected userId to be a valid number");
    }
}