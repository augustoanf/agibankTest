package br.com.agibank.excecao;

import br.com.agibank.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExcecaoTest extends BaseTest {
    @Test(dataProvider = "exceptionDatabase")
    public void notFoundTest(String id){
        given().
            pathParam("id",id).
        when().
            get("/posts/{id}").
        then().
            statusCode(HttpStatus.SC_NOT_FOUND).
            statusLine("HTTP/1.1 404 Not Found");
    }

    @Test(dataProvider = "exceptionDatabase")
    public void internalServerErrorTest(String id){
        given().
            pathParam("id",id).
            contentType(ContentType.JSON).
        when().
            put("/posts/{id}").
        then().
            statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR).
            statusLine("HTTP/1.1 500 Internal Server Error");
    }
}
