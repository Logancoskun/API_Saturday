package API_tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_getRequest {

    /*

    https://jsonplaceholder.typicode.com/posts/44

    -Get URL
    -The response status code is 200,
    -The content type is JSON,
    -In Response body verify the userId is 5,
    -In Response body verify the title is: "optio dolor molestias sit"

 */
    @Test
    public void test01(){

        String url ="https://jsonplaceholder.typicode.com/posts/44";
        Response response = given().when().get(url);

        response.then().assertThat().statusCode(200);

        response.then().assertThat().contentType(ContentType.JSON);

        JSONObject actual = new JSONObject();
        actual.put("userId", 5);
        actual.put("title", "optio dolor molestias sit");

        JsonPath expected = response.jsonPath();

        Assert.assertEquals(actual.get("userId"), expected.get("userId"));
        Assert.assertEquals(actual.get("title"), expected.get("title"));
        response.prettyPrint();


    }
}
