import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostmanApiTests
{
@Test
    public void GetTest()
    {
         given()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200)

             //   .assertThat("Buddy", response.jsonPath().getString("name"), "Pet name mismatch");
                .body("name(0)", equalTo("bar1"));


            //   .and()
            //  .extract().response();
//System.out.println(response.getBody().asString());





    }



}
