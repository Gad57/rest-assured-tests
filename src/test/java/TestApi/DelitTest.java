package TestApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DelitTest {
    @Test
    public void DeliteTests(){
        given().header("x-api-key", "free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType("application/json").log().all()
                .when()

                .delete("https://reqres.in/api/users/2")
                .then().statusCode(204);
    }
}
