package test.testApis;

import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Story("Test apis")
public class firstTest {
    Response response;
    String account_no="1534999";

    @Test(priority = 1)
    public static void getResponseBody(){

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
    }

    @Test(priority = 2)
    public static void getResponseStatus(){
        String url="http://demo.guru99.com/V4/sinkministatement.php";
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }
    @Test(priority = 3)
    public static void getResponseHeaders(){
        String url="https://dummy.restapiexample.com/api/v1/employees";
        String response = new String();
        String headers = "Date=Tue, 21 Nov 2023 11:17:57 GMT";
         response = String.valueOf(given().when().get(url).then().extract()
                .headers());
         System.out.println("Response is "+response);

         //Assert.assertEquals(response.contains(headers), headers);
       // System.out.println("Now The headers in the response "+ response);
                  /*given().when().get(url).then().extract()
                        .headers()).validate_common_responseheaders(Response headers);*/
    }
    @Test(priority = 4)
    public static void assertResponseHeader(){
        int i =1;
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        // Get all the headers and then iterate over allHeaders to print each header
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for(Header header : allHeaders) {
            System.out.println("Key "+ i+":" + header.getName() + " Value: " + header.getValue());
        i++;
        }
    }

}