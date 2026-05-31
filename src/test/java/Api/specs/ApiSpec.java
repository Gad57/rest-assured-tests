package Api.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiSpec {
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .addHeader("x-api-key","free_user_3EJl3C4XphWSPvYUKjW3wBe76Qi")
            .setContentType(ContentType.JSON)
            .build();
    public static ResponseSpecification responseSpec200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    public static ResponseSpecification responseSpec201 = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();
}
