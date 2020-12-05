package br.com.agibank.healthCheck;

import br.com.agibank.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class GetTest extends BaseTest {
        @Test
        public void getTest(){
            int id = 1;

            given().
                pathParam("id",id).
            when().
                get("/{id}").
            then().
                statusCode(200).
                body("id", is(id));
        }

        @Test
        public void getTestList(){

            when().
                get().
            then().
                statusCode(HttpStatus.SC_OK);
        }
}
