package TestApi;

import io.restassured.http.ContentType;


import Api.models.User;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserTest {
    @Test
    public void serializationTest(){
        User user = new User();
        user.setName("Danil");
        user.setJob("QA");
        given()
                .header("x-api-key", "free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("https://reqres.in/api/users")
                .then().log().all().statusCode(201);
    }
}
