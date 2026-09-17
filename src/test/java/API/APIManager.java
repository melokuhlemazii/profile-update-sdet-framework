package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class APIManager {
    private String baseURI;
    private Map<String, String> headers;
    private String authToken;

    public APIManager(String baseURI) {
        this.baseURI = baseURI;
        this.headers = new HashMap<>();
        RestAssured.baseURI = baseURI;
    }

    public void setAuthToken(String token) {
        this.authToken = token;
        addHeader("Authorization", "Bearer " + token);
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void clearHeaders() {
        headers.clear();
    }

    public Response post(String endpoint, Object body) {
        return RestAssured.given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(body)
                .post(endpoint);
    }

    public Response get(String endpoint) {
        return RestAssured.given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .get(endpoint);
    }

    public Response put(String endpoint, Object body) {
        return RestAssured.given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(body)
                .put(endpoint);
    }

    public Response patch(String endpoint, Object body) {
        return RestAssured.given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(body)
                .patch(endpoint);
    }

    public Response delete(String endpoint) {
        return RestAssured.given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .delete(endpoint);
    }

    public Response postMultipart(String endpoint, Map<String, Object> formData) {
        return RestAssured.given()
                .headers(headers)
                .multiPart("file", formData.get("file"))
                .formParams(formData)
                .post(endpoint);
    }

    public String getBaseURI() {
        return baseURI;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getAuthToken() {
        return authToken;
    }
}
