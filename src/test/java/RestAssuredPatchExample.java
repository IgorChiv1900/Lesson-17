import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredPatchExample {

    public static void main(String[] args) {
        // Установка базового URL
        RestAssured.baseURI = "https://postman-echo.com";

        // Данные для отправки в теле запроса
        String requestBody = "This is expected to be sent back as part of response body.";

        // Отправка PATCH-запроса и получение ответа
        Response response = given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "sails.sid=s%3AzTpnqphYUXumToE1VvvRaKBjqqyAqKmo.luZEJRv7scEapVFQQCsvbbD8Z1Tx%2BBL3qgHoShXjQ0Y")
                .body(requestBody)
                .when()
                .patch("/patch") // Выполнение PATCH-запроса
                .then()
                .statusCode(200) // Проверка, что статус ответа 200
                .body("data", equalTo(requestBody)) // Проверка, что тело ответа содержит отправленные данные
                .extract().response();

        // Вывод тела ответа
        System.out.println("Response body: " + response.asString());
    }
}
