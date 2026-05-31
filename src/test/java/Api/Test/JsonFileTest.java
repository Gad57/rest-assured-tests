package Api.Test;

import Api.models.User;
import Api.specs.ApiSpec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonFileTest {
    @Test
    public void createUserFromJson() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(
                new File("src/test/java/resourses/users.json"),
                User.class
        );
        given()
                .spec(ApiSpec.requestSpec)
                .body(user)
                .when()
                .post("api/users")
                .then().log().all().statusCode(201)
                .body("name",equalTo(user.getName()))
                .body("job",equalTo(user.getJob()));

    }
    @Test
    public void CreatUserSFromJson() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        List<User> users= mapper.readValue(new File("src/test/java/resourses/userss.json"),
                new TypeReference<List<User>>() {
                });
        for(User user : users){
            given().spec(ApiSpec.requestSpec)
                    .body(user)
                    .when().post("/api/users")
                    .then().statusCode(201);
        }
    }
}
