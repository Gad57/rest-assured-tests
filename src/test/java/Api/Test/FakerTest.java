package Api.Test;

import Api.models.User;
import net.datafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FakerTest {
    @Test
    public void fakerTests(){
        Faker faker = new Faker();
        User user = new User();
        user.setName(faker.name().firstName());
        user.setJob(faker.job().title());
        Response response = given()
                .header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("https://reqres.in/api/users");
        response.then().statusCode(201);
        System.out.println("ID: " + response.jsonPath().getString("id"));
        String id = response.jsonPath().getString("id");
        assertNotNull(id);

    }
}
