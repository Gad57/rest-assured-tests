package Api.Test;

import Api.models.CastomFilter;
import Api.models.User;
import Api.specs.ApiSpec;
import lombok.Builder;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FakerApiTest {

    @Test
    public void FakerApiTests(){
        Faker faker = new Faker();
        User user = User.builder()
                .name(faker.name().firstName())
                .job(faker.job().title())
                .build();
        given().filter(new CastomFilter())
                .spec(ApiSpec.requestSpec)
                .body(user)
                .when().post("/api/users")
                .then().log().all().statusCode(201);

    }
}
