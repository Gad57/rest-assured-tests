package TestApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ResponseTest {
    @Test
    public void responseTests(){
        String body = """
                { "name": "Danil",
                "job": "QA"
                }
                """;
        Response response =
                given().header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                        .contentType(ContentType.JSON).body(body)
                        .when().post("https://reqres.in/api/users");
        response.then().statusCode(201);
        String id = response.jsonPath().getString("id");
        String name = response.jsonPath().getString("name");
        System.out.println(id);
        System.out.println(name);
    }
}
