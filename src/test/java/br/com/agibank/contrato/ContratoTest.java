package br.com.agibank.contrato;

import br.com.agibank.BaseTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class ContratoTest extends BaseTest {

    @Test
    public void getTest(){
        when().
            get("/posts").
        then().
            body(matchesJsonSchema(new File("src/test/resources/json_schemas/get_test_schema.json")));
    }

    @Test
    public void getTestId(){
        int id = 1;

        given().
            pathParam("id",id).
        when().
            get("/posts/{id}").
        then().
            body(matchesJsonSchema(new File("src/test/resources/json_schemas/get_test_id_schema.json")));
    }

    @Test
    public void getTestComments(){
        int postId = 1;

        given().
            pathParam("postId",postId).
        when().
            get("/comments?postId={postId}").
        then().
            body(matchesJsonSchema(new File("src/test/resources/json_schemas/get_test_comments_schema.json")));
    }

    @Test
    public void getTestCommentsPostId(){
        int postId = 1;

        given().
            pathParam("postId",postId).
        when().
            get("/comments?postId={postId}").
        then().
            body(matchesJsonSchema(new File("src/test/resources/json_schemas/get_test_comments_postId_schema.json")));
    }
}
