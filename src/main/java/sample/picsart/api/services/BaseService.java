package sample.picsart.api.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static sample.picsart.api.config.Url.MAIN_URL;

public class BaseService {

    public static Response get(RequestSpecification requestSpecification) {
        if (((RequestSpecificationImpl) requestSpecification).getContentType().isEmpty()) {
            requestSpecification.contentType(ContentType.JSON);
        }
        Response response = requestSpecification.get();
        requestSpecification.relaxedHTTPSValidation();
        return response;
    }

    public static Response post(RequestSpecification requestSpecification) {
        if (((RequestSpecificationImpl) requestSpecification).getContentType().isEmpty()) {
            requestSpecification.contentType(ContentType.JSON);
        }
        requestSpecification.log().ifValidationFails();
        requestSpecification.relaxedHTTPSValidation();
        return requestSpecification.post();
    }

    private static RequestSpecification baseConfigRequest() {
        RequestSpecification requestSpecification = given()
                .config(RestAssured.config())
                .urlEncodingEnabled(true);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.relaxedHTTPSValidation();
        return requestSpecification;
    }

    public static RequestSpecification configRequestAPI() {
        return baseConfigRequest().baseUri(MAIN_URL);
    }

}
