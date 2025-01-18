package api;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class UserApi {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth";

    public ValidatableResponse registerUser(String requestBody) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/register")
                .then();
    }

    public ValidatableResponse deleteUser(String email) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .delete(BASE_URL + "/user", email) // Этот маршрут должен быть актуальным
                .then();
    }
}

