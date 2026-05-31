package Api.Test;

import Api.specs.ApiSpec;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ShemasTest {
    @Test
    public void shemasTest(){
        String body = """
                {
                "name": "Danil",
                "job": "QA"
                }
                """;
        given()
                .spec(ApiSpec.requestSpec)
                .body(body)
                .when()
                .post("/api/users")
                .then()
                .spec(ApiSpec.responseSpec201)
                .body(matchesJsonSchemaInClasspath("schemas/createUserSchema.json"));
    }
}
