package Api.Test;

import Api.specs.ApiSpec;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class autoChainTest {
    @Test
    public void UseTokenTest(){
        String loginBody = """
                { 
                "email": "eve.holt@reqres.in",
                "password": "cityslicka"
                }
                """;
        Response response = given()
                .spec(ApiSpec.requestSpec)
                .body(loginBody)
                .when().post("api/login");
        response.then().statusCode(200).log().all();
        String token = response.jsonPath().getString("token");
        System.out.println("TOKEN:" + token);
        String userBody = """
                {
                "name": "Danil",
                "job": "QA"
                }
                """;
        given().spec(ApiSpec.requestSpec)
                .header("Authorization", "Bearer " + token)
                .body(userBody)
                .when().post("api/users")
                .then().statusCode(201).log().all();
    }
}
