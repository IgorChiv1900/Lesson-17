import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredPostExample {

    public static void main(String[] args) {
        // Установка базового URL
        RestAssured.baseURI = "https://postman-echo.com";

        // Отправка POST-запроса с данными формы и получение ответа
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("x-forwarded-proto", "https")
                .header("x-forwarded-port", "443")
                .header("host", "postman-echo.com")
                .header("x-amzn-trace-id", "Root=1-63e0c942-584c7dab4a1c52d34d581b03")
                .header("content-length", "19")
                .header("user-agent", "PostmanRuntime/7.30.1")
                .header("accept", "*/*")
                .header("cache-control", "no-cache")
                .header("postman-token", "159c6495-8e5f-4ce0-bacd-ac399a86ec03")
                .header("accept-encoding", "gzip, deflate, br")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post") // Выполнение POST-запроса
                .then()
                .statusCode(200) // Проверка, что статус ответа 200
                .body("form.foo1", equalTo("bar1")) // Проверка, что тело ответа содержит правильные данные формы
                .body("form.foo2", equalTo("bar2"))
                .extract().response();

        // Вывод тела ответа
        System.out.println("Response body: " + response.asString());
    }
}
