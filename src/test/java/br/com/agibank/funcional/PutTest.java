package br.com.agibank.funcional;

import br.com.agibank.BaseTest;
import br.com.agibank.Post;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PutTest extends BaseTest {
        @Test
        public void putTest(){
            int id = 1;

            Post post =
                Post.
                    builder().
                    userId(1).
                    title("Title PUT test 1").
                    body("Body PUT test 1").
                    build();

            given().
                pathParam("id",id).
                contentType(ContentType.JSON).
                body(post).
            when().
                put("{id}").
            then().
                statusCode(HttpStatus.SC_OK).
                body("title", is(post.getTitle()),
                    "body", is(post.getBody()),
                    "userId", is(post.getUserId()));
        }
}
