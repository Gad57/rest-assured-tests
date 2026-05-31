package Api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Api.specs.ApiSpec.responseSpec200;
import static io.restassured.RestAssured.given;


//Получение выбранных имен с БД
public class ListTest {
    @Test
    public void listTests(){
        Response response = given()
                .header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2");
                response.then().spec(responseSpec200);
        List<String> names = response.jsonPath().getList("data.first_name");
        System.out.println(names);
    }
}
