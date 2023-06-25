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

public class API_GetRequetWithSpec extends JsonPlaceHolderUrl {


    @Test
    public void test(){

        spec.pathParams("pp1", 44);

        Response response = given().spec(spec).when().get("{pp1}");

        testdata td = new testdata();

        JSONObject actual = td.getBody();

        JsonPath expected = response.jsonPath();

        Assert.assertEquals(td.successCode, response.getStatusCode());
        Assert.assertEquals(actual.getInt("userId"), expected.getInt("userId"));
        Assert.assertEquals(actual.getInt("id"), expected.getInt("id"));
        Assert.assertEquals(actual.getString("title"), expected.getString("title"));
        Assert.assertEquals(actual.getString("body"), expected.getString("body"));



    }
}


