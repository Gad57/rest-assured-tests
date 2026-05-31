package Api.Test;

import Api.specs.ApiSpec;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SoftAssertTest {
    @Epic("API")
    @Feature("Users")
    @Story("Create User")
    @Description("Проверка успешного создания пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void softAssertTests(){
        Response response = given()
                .filter(new AllureRestAssured())
                .spec(ApiSpec.requestSpec)
                .when()
                .get("/api/users/2");
        response.then().statusCode(200);
        String firstName = response.jsonPath().getString("data.first_name");
        String email = response.jsonPath().getString("data.email");
        Integer id = response.jsonPath().getInt("data.id");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(firstName)
                .as("Проверка имени")
                .isEqualTo("Janet");
        softly.assertThat(email)
                .as("Проверка почты")
                .isEqualTo("janet.weaver@reqres.in");
        softly.assertThat(id)
                .as("проверка айди")
                .isEqualTo(2);
        softly.assertAll();
    }
}
