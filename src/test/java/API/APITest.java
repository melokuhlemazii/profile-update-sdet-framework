package API;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Base API Test class for direct API testing (without Cucumber)
 * Extend this class to create specific API test classes
 */
public class APITest {
    protected APIManager apiManager;

    @BeforeClass
    public void setUp() {
        apiManager = new APIManager(APIEndpoints.BASE_URL);
    }

    /**
     * Template test for login endpoint
     * Replace endpoint URL and implement actual test logic
     */
    @Test
    public void testLoginEndpoint() {
        // TODO: Implement login test
        // 1. Create login request body with credentials
        // 2. Send POST request to LOGIN_ENDPOINT
        // 3. Validate response status code is 200
        // 4. Extract and store auth token
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
}
