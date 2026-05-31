package Api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchListTest {
    /// Например QA говорит:
    /// "Проверь, что у всех пользователей есть email"
    /// или:
    /// "Проверь, что у всех id больше 0"
    /// или:
    /// "Проверь, что нет пустых first_name"
    ///

   // "Проверь, что нет пустых first_name"
    @Test
    public void FirstNameTest(){
        Response response = given()
                .header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2");
        response.then().statusCode(200);
        List<Map<String, Object>> users = response.jsonPath().getList("data");
        for (Map<String, Object> user : users){
            System.out.println(user);
        }
    }
    //Проверка email у всех пользователей
    @Test
    public void EmailTest(){
        Response response = given()
                .header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2");
        response.then().statusCode(200);
        List<Map<String, Object>> users = response.jsonPath().getList("data");
            for (Map<String, Object> user : users){
                String email = user.get("email").toString();
                System.out.println(email);
                //убедиться что email содержит @reqres.in
                assertTrue(email.contains("@reqres.in"));

            }
    }
    // /// "Проверь, что у всех id больше 0"
    @Test
    public void IdTest(){
        Response response = given()
                .header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2");
        response.then().statusCode(200);
        List<Map<String, Object>> users = response.jsonPath().getList("data");
        for(Map<String, Object> user : users){
            int id = (int) user.get("id");
            System.out.println(id);
            //"Проверь, что у всех id больше 0"
            assertTrue(id > 0);

        }
    }
}
