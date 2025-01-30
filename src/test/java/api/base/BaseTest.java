package api.base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification request;
    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI = "https://reqres.in/api";
         request = RestAssured.given();
    }
}
