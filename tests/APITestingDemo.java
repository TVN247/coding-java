import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Demonstrates API testing using TestNG and RestAssured.
 * Note: RestAssured and TestNG dependencies must be configured in your project (e.g., Maven/Gradle).
 */
public class APITestingDemo {

    // Base URL for the API endpoint used in the tests
    private final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final String POSTS_ENDPOINT = "/posts";

    /**
     * @BeforeClass annotation ensures RestAssured is configured once before any test methods run.
     */
    @BeforeClass
    public void setup() {
        // Set the common base URI for all requests in this class
        RestAssured.baseURI = BASE_URL;
    }

    // --- TESTNG TEST METHODS ---

    @Test(description = "Verify successful GET request and status code")
    public void testGetStatusCode() {
        // Perform a GET request to the /posts endpoint
        RestAssured.given()
            .when()
                .get(POSTS_ENDPOINT)
            .then()
                // Verify the HTTP status code is 200 (OK)
                .statusCode(200)
                // Log the request and response details (useful for debugging)
                .log().all();
    }

    @Test(description = "Verify content of a specific resource using Path validation (JSON validation)")
    public void testGetSpecificResourceContent() {
        int postId = 1;
        
        // Perform GET request for post ID 1
        RestAssured.given()
            .pathParam("id", postId)
            .when()
                .get(POSTS_ENDPOINT + "/{id}")
            .then()
                .statusCode(200)
                // Use Hamcrest matchers to validate key fields in the JSON body
                .body("id", equalTo(postId))
                .body("title", notNullValue()) // Ensure title exists
                .body("userId", equalTo(1))
                .log().body();
    }

    @Test(description = "Verify POST request (creating a new resource) and validate response data")
    public void testPostRequestAndValidation() {
        // 1. Define the request body payload (in JSON format)
        String requestBody = "{\n" +
                             "  \"title\": \"foo title\",\n" +
                             "  \"body\": \"bar content\",\n" +
                             "  \"userId\": 1\n" +
                             "}";

        // 2. Perform the POST request and capture the response
        Response response = RestAssured.given()
            .contentType(ContentType.JSON) // Set the content type header
            .body(requestBody)            // Attach the JSON payload
            .when()
                .post(POSTS_ENDPOINT);

        // 3. Validation using TestNG Assertions (response object)
        
        // Verify Status Code (Expected for successful creation: 201 Created)
        assertEquals(response.getStatusCode(), 201, "Expected status code 201 for POST request.");

        // Verify content fields in the response body
        // Note: The mock API returns a new 'id' (usually 101) for a successful post.
        String actualTitle = response.jsonPath().getString("title");
        int actualUserId = response.jsonPath().getInt("userId");
        
        assertEquals(actualTitle, "foo title", "Response title does not match request title.");
        assertEquals(actualUserId, 1, "Response userId does not match request userId.");

        System.out.println("--- POST Response ---");
        response.prettyPrint();
    }
}
 {
    
}
