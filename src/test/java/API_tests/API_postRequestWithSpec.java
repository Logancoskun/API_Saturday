package API_tests;

import BaseUrl.JsonPlaceHolderUrl;
import TestData.testdata;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_postRequestWithSpec extends JsonPlaceHolderUrl {


    /*

 https://jsonplaceholder.typicode.com/posts
 When you send a Get Request make sure
 -The response status code is 200
 -The response body is accurate like the following:

{
  "userId": 3,
  "id": 22,
  "title": "dolor sint quo a velit explicabo quia nam",
  "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}


 */
    @Test
    public void test(){

        testdata td = new testdata();

        Response response = given().spec(spec).contentType(ContentType.JSON).when().body(td.postBody().toString()).post();
        response.prettyPrint();

        testdata t = new testdata();
        JSONObject actual =t.postBody();
        JsonPath expected = response.jsonPath();

        Assert.assertEquals(t.createdCode, response.getStatusCode());
        response.prettyPrint();

        Assert.assertEquals(actual.getInt("userId"), expected.getInt("userId"));
        Assert.assertEquals(actual.getInt("id"), expected.getInt("id"));
        Assert.assertEquals(actual.getString("title"), expected.getString("title"));
        Assert.assertEquals(actual.getString("body"), expected.getString("body"));

        response.prettyPrint();




    }


}
