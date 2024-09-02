import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredGetExample {

    public static void main(String[] args) {
        // Установка базового URL
        RestAssured.baseURI = "https://postman-echo.com";

        // Отправка GET-запроса и получение ответа
        Response response = given()
                .queryParam("foo1", "bar1") // Установка параметра foo1=bar1
                .queryParam("foo2", "bar2") // Установка параметра foo2=bar2
                .header("Accept", "*/*") // Установка заголовка Accept
                .header("Cache-Control", "no-cache") // Установка заголовка Cache-Control
                .header("Postman-Token", "5c27cd7d-6b16-4e5a-a0ef-191c9a3a275f") // Установка заголовка Postman-Token
                .header("User-Agent", "PostmanRuntime/7.6.1") // Установка заголовка User-Agent
                .when()
                .get("/get") // Выполнение GET-запроса
                .then()
                .statusCode(200) // Проверка, что статус ответа 200
                .body("args.foo1", equalTo("bar1")) // Проверка, что параметр foo1 равен "bar1"
                .body("args.foo2", equalTo("bar2")) // Проверка, что параметр foo2 равен "bar2"
                .extract().response();

        // Вывод тела ответа
        System.out.println("Response body: " + response.asString());
    }
}
