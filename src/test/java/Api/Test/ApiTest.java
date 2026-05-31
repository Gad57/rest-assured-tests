package Api.Test;

import Api.models.User;
import org.junit.jupiter.api.Test;

import static Api.specs.ApiSpec.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;


public class ApiTest {
    @Test
    public void apiTest(){

        given().spec(requestSpec)
                .queryParam("page", 2)
                .when().get("/api/users")
                .then()
                .log().all()
                .spec(responseSpec200)

                .body("data.first_name", hasItem("Janet"));
    }
}
