package br.com.agibank.healthCheck;

import br.com.agibank.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class HealthCheckTest extends BaseTest {
        @Test
        public void getPostsTest(){

            when().
                get("/posts").
            then().
                statusCode(HttpStatus.SC_OK);
        }
}
