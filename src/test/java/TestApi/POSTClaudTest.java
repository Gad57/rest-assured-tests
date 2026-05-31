package TestApi;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class POSTClaudTest {
    @Test
    public void PostTest(){
        given().baseUri("https://reqres.in")
                .header("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
                .contentType(ContentType.JSON)
                .body(""" 
                        {
                         "name": "Danil",
                        "job" : "Qa Senior"}
                        
                        """).
        when()
                .post("/api/users")
                .then().statusCode(201).body("name",equalTo("Danil")).body("job",equalTo("Qa Senior"));

    }
}
