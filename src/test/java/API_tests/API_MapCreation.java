package API_tests;

import BaseUrl.JsonPlaceHolderUrl;
import TestData.testdata;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_MapCreation extends JsonPlaceHolderUrl {



    @Test
    public  void test(){

       spec.pathParams("sungur", 70);

        testdata mapBody = new testdata();

        Map<String, Object> actual = mapBody.mapBody();


        Response response = given().spec(spec).contentType(ContentType.JSON).body(actual).put("{sungur}");

        Map<String, Object> actual1 = new HashMap<>();
        actual1.put("title", "Ahmeti");
        actual1.put("body", "Merhabam");
        actual1.put("userId", 12.0);
        actual1.put("Id", 70.0);

        Map<String, Object> expected = response.as(HashMap.class);

        Assert.assertEquals(actual1.get("title"), expected.get("title"));
        Assert.assertEquals(actual1.get("body"), expected.get("body"));
        Assert.assertEquals(actual1.get("userId"), expected.get("userId"));
        Assert.assertEquals(actual1.get("Id"), expected.get("Id"));







    }


}
