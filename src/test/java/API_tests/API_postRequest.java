package API_tests;

import BaseUrl.JsonPlaceHolderUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_postRequest  {
    /*
    https://jsonplaceholder.typicode.com/posts

Send the following POST request to the URL:

{
 "title": "API",
 "body": "API ogrenmek guzel",
 "userId": 10
}

-Verify that the response status code is 201,
-Verify that the content type is application/json
-Verify that the new posted body is accurate. (Do not verify the ID)

{
 "title": "API",
 "body": "API ogrenmek guzel",
 "userId": 10
}

 */
    @Test
    public void test(){

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject body1 = new JSONObject();
        body1.put("title", "API");
        body1.put("body", "API ogrenmek guzel");
        body1.put("userId", 10);

        Response response = given().contentType(ContentType.JSON).when().body(body1.toString()).post(url);

        response.then().assertThat().statusCode(201).contentType(ContentType.JSON);

        JSONObject actual = new JSONObject();
        actual.put("title", "API");
        actual.put("body", "API ogrenmek guzel");
        actual.put("userId", 10);

        JsonPath expected = response.jsonPath();

        Assert.assertEquals(actual.get("title"), expected.get("title"));
        Assert.assertEquals(actual.get("body"), expected.get("body"));
        Assert.assertEquals(actual.get("userId"), expected.get("userId"));
    }


}
