package apiHelpers;

import io.qameta.allure.Allure;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class RestMethodsHelpers {

    /**
     * @param path    Path parameter for URL
     * @param payload Payload for post call
     * @return On success returns response object
     */
    public static Response post(String path, Object payload) {
        return given(SpecBuilder.getRequestSpec()).
                body(payload).
                contentType("application/json; charset=UTF-8").
                when().post(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().response();
    }

    /**
     * @param path This is path parameter
     * @return Returns response object
     */
    public static Response get(String path) {
        return given(SpecBuilder.getRequestSpec()).
                when().get(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().response();
    }

    /**
     * @param path    Pass the path for update call
     * @param payload Updated payload needs to be passed
     * @return Returns response object
     */

    public static Response update(String path, Object payload) {
        return given(SpecBuilder.getRequestSpec()).
                body(payload).
                contentType("application/json; charset=UTF-8").
                when().put(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().response();
    }

    /**
     *
     * @param path path for patch
     * @param payload Updated payload for patch
     * @return response
     */
    public static Response patch(String path, Object payload) {
        return given(SpecBuilder.getRequestSpec()).
                body(payload).
                contentType("application/json; charset=UTF-8").
                when().patch(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().response();
    }

    /**
     * @param path Path of the resource to be deleted
     * @return
     */
    public static Response delete(String path) {
        return given(SpecBuilder.getRequestSpec()).
                when().delete(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().response();
    }

    public static Response deleteWithPayload(String path, Object payload) {
        return given(SpecBuilder.getRequestSpec()).
                body(payload).
                contentType("application/json; charset=UTF-8").
                when().delete(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().response();
    }

    public static void validate_common_responseheaders(Response response) {
        Headers allheaderList = response.getHeaders();
        String breadcrumbidHeader = allheaderList.getValue("breadcrumbid");
        String contentTypeHeader = allheaderList.getValue("Content-Type");
        Allure.step("Validate if breadcrumBID is present");
        Assert.assertNotNull(breadcrumbidHeader, "BreadcrumbID is not null" + breadcrumbidHeader);
        Allure.step("Validate if content type is present");
        Assert.assertNotNull(contentTypeHeader, "contentTypeHeader is not null" + contentTypeHeader);
    }
}
