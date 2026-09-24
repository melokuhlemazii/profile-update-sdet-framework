package API.RequestBuilders;

import API.Payloads.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static API.APIEndpoints.baseURL;
import static API.Payloads.LoginRequest.loginUserPayload;

public class LoginRequestBuilder {

    private static String authToken;

    public static Response loginUserResponse(String email, String password) {

        String apiPath = "/APIDEV/login";
        Response response = RestAssured.given()
                .baseUri(baseURL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .body(loginUserPayload(email, password).toJSONString())
                .log().all()
                .post()
                .then().extract().response();
        authToken = response.jsonPath().getString("data.token");
        return response;
    }

    public static String getAuthToken() {
        return authToken;
    }
}

