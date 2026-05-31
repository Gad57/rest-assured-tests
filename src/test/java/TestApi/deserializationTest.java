package TestApi;

import io.restassured.http.ContentType;
import Api.models.User;
import Api.models.UserResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class deserializationTest {
    @Test
    public void deserializTest() {
        User user = new User();
        user.setName("Danil");
        user.setName("QA");
        UserResponse response =
        given().header("x-api-key", "free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON).body(user)
                .when().post("https://reqres.in/api/users")
                .then().statusCode(201).extract().as(UserResponse.class);


    }
}