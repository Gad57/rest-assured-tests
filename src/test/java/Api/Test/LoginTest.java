package Api.Test;

import Api.specs.ApiSpec;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginTest {
    @Test
    public void LoginTest(){
        String body = """
                { "email": "eve.holt@reqres.in",
                   "password": "cityslicka"
                   }
                """;
        Response response = given()
                .spec(ApiSpec.requestSpec)
                .body(body)
                .when().post("/api/login");
                response.then().statusCode(200).log().all();
                String token = response.jsonPath().getString("token");
                System.out.println("TOKEN: " + token);
                assertNotNull(token);
    }
}
