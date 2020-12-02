package br.com.agibank;

import br.com.agibank.BaseTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class GetTestSchemaValidation extends BaseTest {

        @Test
        public void getTest(){
            int id = 1;

            given().
                pathParam("id",id).
            when().
                get("/{id}").
            then().
                body(matchesJsonSchema(new File("src/test/resources/json_schemas/get_test_schema.json")));
        }

        @Test
        public void getListTest(){
            when().
                get().
            then().
                body(matchesJsonSchema(new File("src/test/resources/json_schemas/get_list_test_schema.json")));
        }
}
