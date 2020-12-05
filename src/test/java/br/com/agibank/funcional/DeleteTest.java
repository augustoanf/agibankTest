package br.com.agibank.funcional;

import br.com.agibank.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends BaseTest {
        @Test
        public void deleteTest(){
            int id = 1;

            given().
                pathParam("id",id).
            when().
                delete("/posts/{id}").
            then().
                statusCode(HttpStatus.SC_OK);
        }
}
