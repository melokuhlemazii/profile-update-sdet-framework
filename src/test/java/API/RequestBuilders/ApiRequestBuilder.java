package API.RequestBuilders;

import API.APIEndpoints;
import API.Payloads.PayloadBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.nio.file.Path;

public class ApiRequestBuilder {

    private String authToken;

    public Response loginUserResponse(String email, String password) {
        Response response = RestAssured.given()
                .baseUri(APIEndpoints.baseURL)
                .basePath(APIEndpoints.LOGIN_ENDPOINT)
                .contentType(ContentType.JSON)
                .body(PayloadBuilder.loginUserPayload(email, password))
                .post();

        authToken = response.jsonPath().getString("data.token");
        return response;
    }

    public Response getProfileResponse() {
        return authenticatedRequest()
                .get(APIEndpoints.GET_PROFILE_ENDPOINT);
    }

    public Response updateProfileResponse(String firstName, String lastName) {
        return authenticatedRequest()
                .contentType(ContentType.JSON)
                .body(PayloadBuilder.updateProfilePayload(firstName, lastName))
                .put(APIEndpoints.UPDATE_PROFILE_ENDPOINT);
    }

    public Response uploadProfileImageResponse(Path imagePath) {
        File imageFile = imagePath.toFile();
        if (!imageFile.exists()) {
            throw new IllegalArgumentException("Image file not found: " + imagePath);
        }

        return authenticatedRequest()
                .multiPart("profileImage", imageFile, "image/jpeg")
                .multiPart("replaceExisting", "true")
                .post(APIEndpoints.UPLOAD_PROFILE_IMAGE_ENDPOINT);
    }

    private io.restassured.specification.RequestSpecification authenticatedRequest() {
        if (authToken == null || authToken.isBlank()) {
            throw new IllegalStateException("Login must succeed before calling authenticated profile endpoints");
        }

        return RestAssured.given()
                .baseUri(APIEndpoints.baseURL)
                .auth()
                .oauth2(authToken);
    }

    public String getAuthToken() {
        return authToken;
    }
}
