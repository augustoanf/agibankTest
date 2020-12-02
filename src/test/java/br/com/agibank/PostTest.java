package br.com.agibank;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PostTest extends BaseTest {
        @Test
        public void postTest(){
            Post post =
                Post.
                    builder().
                    userId(1).
                    title("Title test 1").
                    body("Body test 1").
                    build();

            given().
                contentType(ContentType.JSON).
                body(post).
            when().
                post().
            then().
                statusCode(HttpStatus.SC_CREATED).
                body("title", is(post.getTitle()),
                    "body", is(post.getBody()),
                    "userId", is(post.getUserId()));
        }

    @Test(dataProvider = "postDatabase")
    public void postTestDataProvider(int userID, String title, String body){
        Post post =
            Post.
                builder().
                userId(userID).
                title(title).
                body(body).
                build();

        given().
            contentType(ContentType.JSON).
            body(post).
        when().
            post().
        then().
            statusCode(HttpStatus.SC_CREATED).
            body("title", is(post.getTitle()),
                    "body", is(post.getBody()),
                    "userId", is(post.getUserId()));
    }
}
