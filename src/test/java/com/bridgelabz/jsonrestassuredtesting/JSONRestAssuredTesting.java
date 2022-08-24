package com.bridgelabz.jsonrestassuredtesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JSONRestAssuredTesting {

    int id;

    //    ================================POST====================
    @Test
    public void apostRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"3 States\",\n" +
                        "        \"author\": \"chetan bhagat\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"JAVA\",\n" +
                        "        \"author\": \"H.K\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .post(" http://localhost:3000/posts");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    public void bgetRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void cputRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"Marigold\",\n" +
                        "        \"author\": \"chetan \"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"JAVA\",\n" +
                        "        \"author\": \"Mr. Nataraj\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .put("http://localhost:3000/posts/2");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    //    ==============================================COMMENTS============================
    @Test
    public void epostRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"body\": \"Hello\",\n" +
                        "    \"postId\": 1\n" +
                        "}")
                .when()
                .post("http://localhost:3000/comments");
        response.prettyPrint();
        id = response.path("id");

        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    public void fgetRequestForComments() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/comments");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void gputRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "        \"body\": \"happy independent day\",\n" +
                        "        \"postId\": 1\n" +
                        "}")
                .when()
                .put("http://localhost:3000/comments/11");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    //    ==========================================PROFILE==========================
    @Test
    public void ipostRequestForProfile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\" : 1,\n" +
                        "    \"name\": \"Ashwini Dilip Shirsath\",\n" +
                        "    \"Address\" : \"Tulsi Nagar, plot no. 11\",\n" +
                        "    \"Email\" : \"ashwinishirsath@gmail.com\"\n" +
                        "\n" +
                        "}")
                .when()
                .post("http://localhost:3000/profile");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    public void jgetRequestForProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(" http://localhost:3000/profile");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void kputRequestForProfile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\" : 1,\n" +
                        "    \"name\": \"Ashwini Dilip Shirsath\",\n" +
                        "    \"Address\" : \"Nandurbar, plot no. 11\",\n" +
                        "    \"Email\" : \"ashwinishirsath@gmail.com\"\n" +
                        "\n" +
                        "}")
                .when()
                .put("http://localhost:3000/profile");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void ldeleteRequestForProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(" http://localhost:3000/profile");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
