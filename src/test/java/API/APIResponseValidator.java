package API;

import io.restassured.response.Response;
import org.testng.Assert;

/**
 * Utility class for validating API responses
 */
public class APIResponseValidator {

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
                "Expected status code " + expectedStatusCode + " but got " + response.getStatusCode());
    }

    public static void validateStatusCodeSuccess(Response response) {
        int statusCode = response.getStatusCode();
        Assert.assertTrue(statusCode >= 200 && statusCode < 300,
                "Expected successful status code (200-299) but got " + statusCode);
    }

    public static void validateContentType(Response response, String expectedContentType) {
        String actualContentType = response.getContentType();
        Assert.assertTrue(actualContentType.contains(expectedContentType),
                "Expected content type to contain '" + expectedContentType + "' but got '" + actualContentType + "'");
    }

    public static void validateJsonPath(Response response, String jsonPath, Object expectedValue) {
        Object actualValue = response.jsonPath().get(jsonPath);
        Assert.assertEquals(actualValue, expectedValue,
                "JSON path '" + jsonPath + "' expected '" + expectedValue + "' but got '" + actualValue + "'");
    }

    public static void validateResponseBodyContains(Response response, String expectedText) {
        String body = response.getBody().asString();
        Assert.assertTrue(body.contains(expectedText),
                "Response body does not contain expected text: " + expectedText);
    }

    public static void validateResponseTimeBelow(Response response, long maxTimeMs) {
        long responseTime = response.getTime();
        Assert.assertTrue(responseTime < maxTimeMs,
                "Response time " + responseTime + "ms exceeded max time " + maxTimeMs + "ms");
    }

    public static void logResponse(Response response) {
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Content-Type: " + response.getContentType());
        System.out.println("Response Time: " + response.getTime() + "ms");
        System.out.println("Response Body: " + response.getBody().asString());
    }
}
