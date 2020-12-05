package br.com.agibank.funcional;

import br.com.agibank.BaseTest;
import io.restassured.specification.Argument;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

public class GetTest extends BaseTest {
    @Test
    public void getTest(){

        when().
            get("/posts").
        then().
            statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getTestId(){
        int postId = 1;

        given().
            pathParam("id",postId).
        when().
            get("/posts/{id}").
        then().
            statusCode(200).
            body("id", is(postId));
    }

    @Test
    public void getTestIdComments(){
        int postId = 1;
        given().
            pathParam("id",postId).
        when().
            get("/posts/{id}/comments").
        then().
            statusCode(200).
            body("postId",hasItem(postId));
    }

    @Test
    public void getTestFilterPostId(){
        int postId = 1;

        given().
            pathParam("postId",postId).
        when().
            get("/comments?postId={postId}").
        then().
            statusCode(HttpStatus.SC_OK).
            body("postId",hasItem(postId));
    }

    @Test
    public void getTestFilterId(){
        int id = 1;

        given().
            pathParam("id",id).
        when().
            get("/comments?id={id}").
        then().
            statusCode(HttpStatus.SC_OK).
            body("id",hasItem(id));
    }

    @Test
    public void getTestFilterName(){
        String name = "id labore ex et quam laborum";

        given().
                pathParam("name",name).
                when().
                get("/comments?name={name}").
                then().
                statusCode(HttpStatus.SC_OK).
                body("name",hasItem(name));
    }

    @Test
    public void getTestFilterEmail(){
        String email = "Eliseo@gardner.biz";

        given().
            pathParam("email",email).
        when().
            get("/comments?email={email}").
        then().
            statusCode(HttpStatus.SC_OK).
            body("email",hasItem(email));
    }

    @Test
    public void getTestFilterBody(){
        String body = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium";

        given().
            pathParam("body",body).
        when().
            get("/comments?body={body}").
        then().
            statusCode(HttpStatus.SC_OK).
            body("body",hasItem(body));
    }
}
