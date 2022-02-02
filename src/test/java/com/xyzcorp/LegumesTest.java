package com.xyzcorp;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LegumesTest {
    //Rest-Assure
        /*[
        [0] {
                 "description": "Root vegetable, usually orange",
                 "name": "Carrot"
            },
        [1] {
                 "description": "Summer squash",
                 "name": "Zucchini"
            }
         ]*/
    @Test
    public void testGetLegumes() {
        given()
                .relaxedHTTPSValidation()
                .accept(ContentType.JSON)
                .when()
                .get("https://staging.tiered-planet.net/mild-temper/legumes")
                .then()
                .assertThat()
                .body("[1].name", equalTo("Zucchini"));
    }
}
