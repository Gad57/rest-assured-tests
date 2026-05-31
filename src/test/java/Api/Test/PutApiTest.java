package Api.Test;

import Api.specs.ApiSpec;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutApiTest {
    @Test
    public void putApiTest(){
        String body = """
                {
                "name" : "DanilROMA",
                "job" : "QA Senior"
                }
                """;
        given().spec(ApiSpec.requestSpec)
                .body(body)
                .when()
                .put("/api/users/2")
                .then().statusCode(200).log().all()
                .body("name",equalTo("DanilROMA"))
                .body("job",equalTo("QA Senior"));
    }
    @Test
    public void PutTest(){
        String body = """
                {
                "job": "Lead QA"
                }
                """;
        given().spec(ApiSpec.requestSpec)
                .body(body)
                .when().patch("/api/users/2")
                .then().log().all()
                .body("job",equalTo("Lead QA"));
    }
    @Test
    public void DeliteTest(){
        given().spec(ApiSpec.requestSpec)
                .when().delete("/api/users/2")
                .then().statusCode(204);
    }
}
