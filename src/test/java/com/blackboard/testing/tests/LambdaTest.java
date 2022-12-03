package com.blackboard.testing.tests;

import static com.blackboard.testing.lambda.logger.LoggerContainer.LOGGER;
import static io.restassured.RestAssured.given;

import com.blackboard.testing.common.LambdaBaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Test.class)
public class LambdaTest extends LambdaBaseTest {

    @Test
    public void getWeatherDetails() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "https://demoqa.com/BookStore/v1/Books");
        String responseBody = response.getStatusLine();
        LOGGER.log("Status line is " + responseBody);
    }

    @Test
    public void getBookDetails() {
        given()
                .when()
                .get("https://demoqa.com/BookStore/v1/Books")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }
}
