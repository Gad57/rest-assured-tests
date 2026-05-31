package Api.testData;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.*;
import static org.hamcrest.Matchers.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
@Tag("wiremock")
public class WireMockTest {
    static WireMockServer wireMock = new WireMockServer(8089);
    @BeforeAll
    static void start() {
        wireMock.start(); // ← запускаем фейковый сервер
    }

    @AfterAll
    static void stop() {
        wireMock.stop(); // ← останавливаем после тестов
    }

    @Test
    public void mockGetUserTest() {
        // Настраиваем: когда придёт GET /api/users/1 → вернуть вот это
        wireMock.stubFor(get("/api/users/1")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                    {
                        "data": {
                            "id": 1,
                            "name": "Danil",
                            "job": "QA Senior"
                        }
                    }
                    """)));

        // Теперь делаем запрос к фейковому серверу
        given()
                .baseUri("http://localhost:8089")
                .when()
                .get("/api/users/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.name", equalTo("Danil"))
                .body("data.job", equalTo("QA Senior"));
    }
}
