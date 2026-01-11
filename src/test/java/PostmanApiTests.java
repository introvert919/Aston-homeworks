import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/* Перейдите в сервис Postman.
Войдите в свой аккаунт и скачайте себе коллекцию Postman Echo.
Написать автотесты для каждого метода из папки Request Methods
(проверка тела ответа (просто сравнить значения всех полей) и кода ответа). */


public class PostmanApiTests
{
    private static final String baseUri = "https://postman-echo.com";

    @BeforeEach
    public void setUp()
    {
        RestAssured.baseURI = baseUri;
    }


    @Test
    public void getTest()
    {
        given().
        contentType(ContentType.JSON).
                formParam("foo1", "bar1").
                formParam("foo2", "bar2").
                when().get("/get").
                then().
                log().all().

                statusCode(200).
                body(
                        "args.foo1", is("bar1"),
                        "args.foo2", is("bar2"),
                        "headers.host", is("postman-echo.com"),
                        "headers.accept", is("*/*"),
                        "headers.accept-encoding", is("gzip, br"),
                        "headers.content-type", is("application/json; charset=UTF-8"),
                        "headers.x-forwarded-proto", is("https"),
                        "headers.user-agent", is("Apache-HttpClient/4.5.3 (Java/11.0.29)"),
                        "url", is("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                );
    }

    @Test
    void postTextTest()
    {
        given().
                contentType(ContentType.JSON).
                body("This is expected to be sent back as part of response body.").
                when().post("/post").
                then().
                //log().all().

                statusCode(200).
                body("$", hasKey("args"), // В пустом объекте нет значений, не с чем сравнивать. Можно определить только наличие ключа.
                        "data", is("This is expected to be sent back as part of response body."),
                        "$", hasKey("files"),
                        "$", hasKey("form"),
                        "headers.host", is("postman-echo.com"),
                        "headers.user-agent", is("Apache-HttpClient/4.5.3 (Java/11.0.29)"),
                        "headers.accept-encoding", is("gzip, br"),
                        "headers.accept", is("*/*"),
                        "headers.x-forwarded-proto", is("https"),
                        "headers.content-type", is("application/json; charset=UTF-8"),
                        "headers.content-length", is("58"),
                        "$", hasKey("json"),
                        "url", is("https://postman-echo.com/post")
                );
    }

    @Test
    public void postFormDataTest()
    {
        JSONObject data = new JSONObject();
        data.put("foo1", "bar1");
        data.put("foo2", "bar2");

        given().
                contentType(ContentType.JSON).

                body(data.toString()).
                post("/post").
                then().
                //log().all().

                statusCode(200).
                body("$", hasKey("args"),
                        "data.foo1", is("bar1"),
                        "data.foo2", is("bar2"),
                        "$", hasKey("files"),
                        "$", hasKey("form"),
                        "headers.host", is("postman-echo.com"),
                        "headers.user-agent", is("Apache-HttpClient/4.5.3 (Java/11.0.29)"),
                        "headers.accept-encoding", is("gzip, br"),
                        "headers.accept", is("*/*"),
                        "headers.x-forwarded-proto", is("https"),
                        "headers.content-type", is("application/json; charset=UTF-8"),
                        "headers.content-length", is("29"),
                        "json.foo1", is("bar1"),
                        "json.foo2", is("bar2"),
                        "url", is("https://postman-echo.com/post")
                );
    }

    @Test
    public void putTest()
    {
        given().
                contentType(ContentType.JSON).
                body("This is expected to be sent back as part of response body.").
                when().put("/put").
                then().
                //log().all().

                statusCode(200).
                body("$", hasKey("args"),
                        "data", is("This is expected to be sent back as part of response body."),
                        "$", hasKey("files"),
                        "$", hasKey("form"),
                        "headers.host", is("postman-echo.com"),
                        "headers.user-agent", is("Apache-HttpClient/4.5.3 (Java/11.0.29)"),
                        "headers.accept-encoding", is("gzip, br"),
                        "headers.accept", is("*/*"),
                        "headers.x-forwarded-proto", is("https"),
                        "headers.content-type", is("application/json; charset=UTF-8"),
                        "headers.content-length", is("58"),
                        "$", hasKey("json"),
                        "url", is("https://postman-echo.com/put")
                );
    }

    @Test
    public void patchTest()
    {
        given().
                contentType(ContentType.JSON).
                body("This is expected to be sent back as part of response body.").
                when().patch("/patch").
                then().
                //log().all().

                statusCode(200).
                body("$", hasKey("args"),
                        "data", is("This is expected to be sent back as part of response body."),
                        "$", hasKey("files"),
                        "$", hasKey("form"),
                        "headers.host", is("postman-echo.com"),
                        "headers.user-agent", is("Apache-HttpClient/4.5.3 (Java/11.0.29)"),
                        "headers.accept-encoding", is("gzip, br"),
                        "headers.accept", is("*/*"),
                        "headers.x-forwarded-proto", is("https"),
                        "headers.content-type", is("application/json; charset=UTF-8"),
                        "headers.content-length", is("58"),
                        "$", hasKey("json"),
                        "url", is("https://postman-echo.com/patch")
                );
    }

    @Test
    public void deleteTest()
    {
        given().
                contentType(ContentType.JSON).
                body("This is expected to be sent back as part of response body.").
                when().delete("/delete").
                then().
                //log().all().

                statusCode(200).
                body("$", hasKey("args"),
                        "data", is("This is expected to be sent back as part of response body."),
                        "$", hasKey("files"),
                        "$", hasKey("form"),
                        "headers.host", is("postman-echo.com"),
                        "headers.user-agent", is("Apache-HttpClient/4.5.3 (Java/11.0.29)"),
                        "headers.accept-encoding", is("gzip, br"),
                        "headers.accept", is("*/*"),
                        "headers.x-forwarded-proto", is("https"),
                        "headers.content-type", is("application/json; charset=UTF-8"),
                        "headers.content-length", is("58"),
                        "$", hasKey("json"),
                        "url", is("https://postman-echo.com/delete")
                );
    }
}









