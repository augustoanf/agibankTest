package br.com.agibank;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import static io.restassured.RestAssured.*;

@Listeners({ExtentITestListenerAdapter.class})
public abstract class BaseTest {
    @BeforeClass
    public static void preCondicao(){

        baseURI = "https://jsonplaceholder.typicode.com";

        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @DataProvider
    public Object[][] getDatabase(){
        return new Object[][]{
                {
                        1
                },
                {
                        2
                },
                {
                        3
                },
                {
                        4
                },
                {
                        5
                },
                {
                        6
                },
                {
                        7
                },
                {
                        8
                },
                {
                        9
                },
                {
                        10
                },
        };
    }

    @DataProvider
    public Object[][] exceptionDatabase(){
        return new Object[][]{
                {
                        "0"
                },
                {
                        "a"
                },
                {
                        "$"
                },
                {
                        "-1"
                },
                {
                        "-5"
                },
                {
                        "z"
                },
                {
                        "*a2"
                },
                {
                        "15.2"
                },
                {
                        "1.4"
                },
                {
                        "1.4ab"
                }
        };
    }

    @DataProvider
    public Object[][] postDatabase(){
        return new Object[][]{
                {
                    1,
                    "Title 1",
                    "Body 1"
                },
                {
                    1,
                    "Title 2",
                    "Body 2"
                },
                {
                    1,
                    "Title 3",
                    "Body 3"
                },
                {
                    1,
                    "Title 4",
                    "Body 4"
                },
                {
                    1,
                    "Title 5",
                    "Body 5"
                },
                {
                    1,
                    "Title 6",
                    "Body 6"
                },
                {
                    1,
                    "Title 7",
                    "Body 7"
                },
                {
                    1,
                    "Title 8",
                    "Body 8"
                },
                {
                    1,
                    "Title 9",
                    "Body 9"
                },
                {
                    1,
                    "Title 10",
                    "Body 10"
                },
        };
    }
}
