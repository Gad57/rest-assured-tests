package TestApi;

import io.restassured.http.ContentType;
import Api.models.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class RegressTest {
    private final static String URL = "https://reqres.in/";
    @Test
    public void  regresTest(){
        List<UserData> user = given().header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .log().all()
                .when()

                .get(URL + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        user.stream().forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(user.stream().allMatch(x ->x.getEmail().endsWith("@regres.in") ));
    }
}
