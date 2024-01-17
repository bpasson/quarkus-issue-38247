package org.acme.quarkus.rest;

import org.acme.quarkus.entity.TestRecordOne;
import org.acme.quarkus.entity.TestRecordTwo;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.jboss.resteasy.reactive.common.util.RestMediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ReproducerTest {

    @Test
    void shouldGetCorrectSelfLinkForRecordOne() {

        Response response = given()
                .contentType(RestMediaType.APPLICATION_JSON)
                .accept(RestMediaType.APPLICATION_JSON)
                .body(new TestRecordOne(1L, 10L, "One"))
                .post("/api/one")
                .andReturn();

        assertThat(response.getStatusCode()).isEqualTo(201);

        response = given().accept(RestMediaType.APPLICATION_HAL_JSON)
                .get("/api/one/1")
                .thenReturn();

        // self link should have the @Id annotated value, and not the id field
        assertThat(response.body().jsonPath().getString("_links.self.href")).endsWith("/api/one/1");
    }

    @Test
    void shouldGetCorrectSelfLinkForRecordTwo() {
        Response response = given()
                .contentType(RestMediaType.APPLICATION_JSON)
                .accept(RestMediaType.APPLICATION_JSON)
                .body(new TestRecordTwo(2L, "Two"))
                .post("/api/two")
                .andReturn();

        assertThat(response.getStatusCode()).isEqualTo(201);

        response = given().accept(RestMediaType.APPLICATION_HAL_JSON)
                .get("/api/two/2")
                .thenReturn();

        // self link should have the @Id annotated value, and not be blank
        assertThat(response.body().jsonPath().getString("_links.self.href")).endsWith("/api/two/2");
    }
}
