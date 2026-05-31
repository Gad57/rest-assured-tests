package Api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static Api.specs.ApiSpec.responseSpec200;
import static io.restassured.RestAssured.given;

// Дает по индексу определенные данные по запросу
public class ListMapTest {
    @Test
    public void ListMapTests(){
        Response response = given()
                .header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2");
               response.then().statusCode(200);
        List<Map<String, Objects>> users = response.jsonPath().getList("data");
        Map<String,Objects> firstUser = users.get(0);

        System.out.println("Имя: " + firstUser.get("first_name"));
        System.out.println("Email:" + firstUser.get("email"));

    }
}
