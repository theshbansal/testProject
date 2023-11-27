package test.testApis;

import apiHelpers.RestMethodsHelpers;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class basicTests {
    @Test(priority = 1)
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
        System.out.println(("Headers=>" + response.headers()));

    }

    @Test(priority = 2)
    public void GetWeatherDetailsCondensed() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Get the RequestSpecification of the request that is to be sent
        // to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Call RequestSpecification.get() method to get the response.
        // Make sure you specify the resource name.
        Response response = httpRequest.get("");

        // Response.asString method will directly return the content of the body
        // as String.
        System.out.println("Response Body is =>  " + response.asString());
    }

    @Test(priority = 3)
    public void GetBookDetailswithstatusCode() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("");

        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/,
                "Correct status code returned");
        //Assert.assertEquals(statusCode /*actual value*/, 401 /*expected value*/, "Correct status code returned");
    }

    @Test(priority = 4)
    public void IteratingHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        // Get all the headers and then iterate over allHeaders to print each header
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }

    @Test(priority = 5)
    public void GetBookHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
//  header with a given name.
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
//  header with a given name.
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
//  header with a given name. Header = Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
    }

    @Test(priority = 6)
    public void ValidateBookHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
//  header with a given name. Header = Content-Type
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
//  header with a given name. Header = Server
        String serverType = response.header("Server");
        Assert.assertEquals(serverType /* actual value */, "nginx/1.17.10 (Ubuntu)" /* expected value */);

    }
    @Test(priority = 7)
    public void ValidateResponseBody(){
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        System.out.println("Response : "+response);
    }
    @Test(priority = 8)
    @Description("Find account by calling User")
    public void getCurrentBook(){
        RestMethodsHelpers instance = new RestMethodsHelpers();
        Response response = RestMethodsHelpers.get("https://demoqa.com/BookStore/v1/Books");
        Assert.assertEquals(response.getStatusCode(),200);
        Object jsonPathObj=response.jsonPath();
        System.out.println("Object: "+jsonPathObj);
        //String userAccountNumber= ((JsonPath) jsonPathObj).getString("accountNumber");
       // Assert.assertNotNull(userAccountNumber);
        //System.out.println(userAccountNumber);

    }
}
