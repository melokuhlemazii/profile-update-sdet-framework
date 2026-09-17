package API;

import com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

/**
 * API Step Definitions for BDD testing
 * Use these steps in your Cucumber feature files for API validation
 */
public class APIStepDefinitions {
    private APIManager apiManager;
    private Response lastResponse;

    @Before
    public void setUp() {
        apiManager = new APIManager(APIEndpoints.BASE_URL);
    }

    // Login Steps
    @Given("I have an API client for {string}")
    public void initializeAPIClient(String baseURL) {
        apiManager = new APIManager(baseURL);
    }

    @When("I send a POST request to {string} with credentials")
    public void sendLoginRequest(String endpoint) {
        JsonObject loginBody = new JsonObject();
        loginBody.addProperty("email", "melomazibuko8@gmail.com");
        loginBody.addProperty("password", "Mwelase@1031");

        lastResponse = apiManager.post(endpoint, loginBody.toString());
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        lastResponse = apiManager.get(endpoint);
    }

    @When("I send a POST request to {string}")
    public void sendPostRequest(String endpoint) {
        lastResponse = apiManager.post(endpoint, "{}");
    }

    @When("I send a PUT request to {string} with profile data")
    public void sendPutRequest(String endpoint) {
        JsonObject profileBody = new JsonObject();
        profileBody.addProperty("firstName", "John");
        profileBody.addProperty("lastName", "Doe");
        profileBody.addProperty("email", "john@example.com");

        lastResponse = apiManager.put(endpoint, profileBody.toString());
    }

    // Response Validation Steps
    @Then("the response status code should be {int}")
    public void validateStatusCode(int expectedStatusCode) {
        APIResponseValidator.validateStatusCode(lastResponse, expectedStatusCode);
    }

    @Then("the response status should be successful")
    public void validateStatusCodeSuccess() {
        APIResponseValidator.validateStatusCodeSuccess(lastResponse);
    }

    @Then("the response content type should be {string}")
    public void validateContentType(String expectedContentType) {
        APIResponseValidator.validateContentType(lastResponse, expectedContentType);
    }

    @And("the response should contain {string}")
    public void validateResponseContains(String expectedText) {
        APIResponseValidator.validateResponseBodyContains(lastResponse, expectedText);
    }

    @And("the response time should be below {int} ms")
    public void validateResponseTime(int maxTimeMs) {
        APIResponseValidator.validateResponseTimeBelow(lastResponse, maxTimeMs);
    }

    @And("I store the auth token from response")
    public void storeAuthToken() {
        try {
            String token = lastResponse.jsonPath().getString("token");
            Assert.assertNotNull(token, "Auth token not found in response");
            apiManager.setAuthToken(token);
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract token from response: " + e.getMessage());
        }
    }

    @And("I print the response")
    public void printResponse() {
        APIResponseValidator.logResponse(lastResponse);
    }

    public Response getLastResponse() {
        return lastResponse;
    }

    public APIManager getAPIManager() {
        return apiManager;
    }
}
