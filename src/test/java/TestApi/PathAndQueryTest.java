package TestApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PathAndQueryTest {
    @Test
    public void PertQueryTest(){
        given().header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType("application/json")
                .pathParam("id",2)
                .when().get("https://reqres.in/api/users/{id}")
                .then().statusCode(200).body("data.first_name",equalTo("Janet"));
    }
    @Test
    public void QueryTest(){
        given().header("x-api-key", "free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .queryParam("page",2)
                .when().get("https://reqres.in/api/users")
                .then().statusCode(200).body("page",equalTo(2));
    }
}
