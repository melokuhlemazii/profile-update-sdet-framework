package API;

import API.Payloads.LoginRequest;
import API.RequestBuilders.LoginRequestBuilder;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Base API Test class for direct API testing (without Cucumber)
 * Extend this class to create specific API test classes
 */
public class APITest {
    protected APIManager apiManager;

    @BeforeClass
    public void setUp() {
        apiManager = new APIManager(APIEndpoints.baseURL);
    }

    //login test
    @Test
    public void userLoginTest(){

        LoginRequestBuilder.loginUserResponse("melomazibuko8@gmail.com", "Mwelase@1031")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    /**
     * Template test for get profile endpoint
     */
    @Test
    public void testGetProfileEndpoint() {
        // TODO: Implement get profile test
        // 1. Ensure auth token is set
        // 2. Send GET request to GET_PROFILE_ENDPOINT
        // 3. Validate response status code is 200
        // 4. Validate response contains profile data
    }

    /**
     * Template test for update profile endpoint
     */
    @Test
    public void testUpdateProfileEndpoint() {
        // TODO: Implement update profile test
        // 1. Ensure auth token is set
        // 2. Create profile update request body
        // 3. Send PUT request to UPDATE_PROFILE_ENDPOINT
        // 4. Validate response status code is 200 or 201
        // 5. Validate response contains updated data
    }

    /**
     * Template test for upload profile picture endpoint
     */
    @Test
    public void testUploadProfilePictureEndpoint() {
        // TODO: Implement upload profile picture test
        // 1. Ensure auth token is set
        // 2. Create multipart request with file
        // 3. Send POST request to UPLOAD_PROFILE_PICTURE_ENDPOINT
        // 4. Validate response status code is 200 or 201
        // 5. Validate response confirms upload success
    }

    /*
    @Test(description = "Validate login endpoint returns token and HTTP 200")
    public void testLoginEndpoint() {
        String email = " ";
        String password = " ";

        JSONObject payload = LoginRequest.loginUserPayload(email, password);

        Response response = apiManager.post(APIEndpoints.LOGIN_ENDPOINT, payload.toJSONString());

        APIResponseValidator.validateStatusCode(response, 200);
        APIResponseValidator.validateContentType(response, "application/json");

        String token = null;
        try {
            token = response.jsonPath().getString("token");
            if (token == null) {
                token = response.jsonPath().getString("data.token");
            }
        } catch (Exception e) {
            // ignore
        }

        Assert.assertNotNull(token, "Auth token not found in login response");
        apiManager.setAuthToken(token);

        APIResponseValidator.logResponse(response);
    }
       */
}
