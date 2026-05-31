package TestApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserApiTest {
    @Test
    public void getUserTest(){

        given()
                .header("x-api-key", "free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi").log().all()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"));
    }
}
