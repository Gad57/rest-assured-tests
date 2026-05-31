package Api.Test;

import Api.specs.ApiSpec;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Error404Test extends ApiSpec {
    // ОШИБКА ПРИ КОТОРОЙ НЕТ СУЩЕСТВУЮЩЕГО ТОКЕНА
    @Test
    public void Error404Tests(){
        given().spec(requestSpec)
                .when()
                .get("/api/users/999")
                .then().statusCode(404).log().all();
    }
    // ОШИБКА ГДЕ НЕТ ТОКЕНА
    @Test
    public void Error401Tests(){
        given()

                .when()
                .get("https://reqres.in/api/users/2")
                .then().statusCode(401).log().all();
    }
    // ОШИБКА 400 НЕ ПРАВТИЛЬНЫЕ ДАННЫЕ
    @Test
    public void Error400Test(){
        given().spec(requestSpec)
                .body("{}")
                .when().post("/api/users")
                .then().statusCode(201).log().all();
    }
    @Test
    public void NegativeTest(){
        String body = """
                {
                "email": "eve.holt@reqres.in"
                }
                """;
        given().spec(requestSpec)
                .body(body)
                .when()
                .post("/api/login")
                .then().log().all()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }
}

