package Api.Test;

import Api.models.User;
import Api.specs.ApiSpec;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ExampleTest {
    @Test
    public void ExampleTest(){

    Response response =
         given().spec(ApiSpec.requestSpec)
                .when().get("/api/users?page=2")
        .then().log().all().extract().response();

    }
}
