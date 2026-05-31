package TestApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class PutUsTest {
    @Test
    public void putTest(){
        String body = """ 
                {
                "name": "Danil",
                "job": "Senior QA"}
                """;
        given().header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType("application/json")
                .body(body)
                .log()
                .all().
                when()
                .put("https://reqres.in/api/users/2")
                .then().log().all()
                        .statusCode(200).body("name", equalTo("Danil"))
                .body("job",equalTo("Senior QA"));
    }
}
