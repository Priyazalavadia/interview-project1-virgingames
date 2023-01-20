package com.virgingames.testsuite;

import com.virgingames.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.parsing.Parser.JSON;
import static org.hamcrest.Matchers.*;

public class FirstTest extends TestBase {

    static ValidatableResponse response;


    @Test
   public void getAllGames() {
        RestAssured.registerParser("text/plain", JSON);
        response = given()
                .when()
                .get("")
                .then().log().all().statusCode(200);


        response.body("bingoLobbyInfoResource.streams[0].streamId", equalTo(194));
        response.body("bingoLobbyInfoResource.streams[0].streamName", equalTo("Adventure"));

    }


}
