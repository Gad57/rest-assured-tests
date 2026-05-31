package Api.Test;

import Api.models.User;
import org.junit.jupiter.api.Test;

import static Api.specs.ApiSpec.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class SpecTest {
    @Test
    public void specTest(){
        User user = new User();
        user.setName("Danil");
        user.setJob("QA");
        given()

                .spec(requestSpec)
                .body(user)
                .when()
                .post("/api/users")
                .then()
                .spec(responseSpec201).log().all()
                .body("name", equalTo("Danil"))
                .body("job",equalTo("QA"));

    }
}
