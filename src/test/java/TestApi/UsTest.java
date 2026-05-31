package TestApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UsTest {
    @Test
    public void UsTest(){
        String body = "{\n" + "\"name\": \"Danil\",\n"
                + "\"job\": \"Automation QA\"\n"+"}";
        given().header("x-api-key", "free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType("application/json").body(body).log().all()

                .when().post("https://reqres.in/api/users")

                .then().log().all().statusCode(201).body("name",equalTo("Danil"))
                .body("job",equalTo("Automation QA"));
    }
}
