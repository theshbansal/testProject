package apiHelpers;


import commonutils.PropertyUtils;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class SpecBuilder {
    public static RequestSpecification getRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://demoqa.com/BookStore/v1/Books")
                .log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }

}

