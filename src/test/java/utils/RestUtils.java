package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    private RestUtils() {
        // Private constructor to prevent instantiation
    }

    public static Response get(String baseUri, String endpoint) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.createRequestSpec(baseUri))
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response post(String baseUri, String endpoint, Map<String, Object> body) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.createRequestSpec(baseUri))
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response put(String baseUri, String endpoint, Map<String, Object> body) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.createRequestSpec(baseUri))
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response patch(String baseUri, String endpoint, Map<String, Object> body) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.createRequestSpec(baseUri))
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response delete(String baseUri, String endpoint) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.createRequestSpec(baseUri))
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}