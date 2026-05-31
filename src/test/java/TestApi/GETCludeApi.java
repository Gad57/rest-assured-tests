package TestApi;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GETCludeApi {
    @Test
    public void ClaudeTest(){
        given().baseUri("https://reqres.in")
                .header("x-api-key", "free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .when().get("/api/user/2")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.name", equalTo("fuchsia rose"))
                .body("data.year", equalTo(2001))
                .body("data.color", equalTo("#C74375"));
    }
}
