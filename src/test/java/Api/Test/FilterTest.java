package Api.Test;

import Api.models.CastomFilter;
import Api.specs.ApiSpec;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FilterTest {
    @Test
    public void FilterTest(){
        Response response =
        given().filter(new CastomFilter())
                .spec(ApiSpec.requestSpec)
                .when().get("/api/users");
        response.then().statusCode(200);
        String user = response.jsonPath().getString("data.email");
        System.out.println(user);
    }
}
