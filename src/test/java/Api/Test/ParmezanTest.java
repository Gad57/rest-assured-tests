package Api.Test;

import Api.models.CastomFilter;
import Api.models.User;
import Api.specs.ApiSpec;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParmezanTest {

    //Проверяем разных пользователей
    @ParameterizedTest
    @ValueSource(strings = {
            "QA",
            "Developer",
            "Manager"
    })
    public void parmezanTest(String job){
        User user = new User();
        user.setName("Danil");
        user.setJob(job);
        given().filter(new CastomFilter()).spec(ApiSpec.requestSpec)
                .body(user)
                .when().post("/api/users")
                .then().statusCode(201)
                .body("job",equalTo(job));
    }
    //Когда нужно несколько параметров
    @ParameterizedTest
    @CsvSource({
            "Danil, QA",
            "Alex, Dev",
            "John, Manager"
    })
    public void csvTest(String name, String job){
        User user = new User();
        user.setName(name);
        user.setJob(job);
        given().spec(ApiSpec.requestSpec)
                .body(user)
                .when().post("/api/users")
                .then().statusCode(201)
                .body("name", equalTo(name))
                .body("job",equalTo(job));
    }
}
