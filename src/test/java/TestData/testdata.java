package TestData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class testdata {


    /*{
        "userId": 5,
            "id": 44,
            "title": "optio dolor molestias sit",
            "body": "temporibus est consectetur dolore\net libero debitis vel velit laboriosam quia\nipsum quibusdam qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae"
    /*

     */


    public int successCode = 200;

    public int createdCode = 201;

    public JSONObject getBody(){
        JSONObject js = new JSONObject();
        js.put("userId", 5);
        js.put("id", 44);
        js.put("title", "optio dolor molestias sit");
        js.put("body", "temporibus est consectetur dolore\n" +
                "et libero debitis vel velit laboriosam quia\n" +
                "ipsum quibusdam qui itaque fuga rem aut\n" +
                "ea et iure quam sed maxime ut distinctio quae");
        return js;



    }
    public JSONObject postBody() {
        JSONObject js1 = new JSONObject();
        js1.put("userId", 3);
        js1.put("id", 101);
        js1.put("title", "dolor sint quo a velit explicabo quia nam");
        js1.put("body", "eos qui et ipsum ipsam suscipit aut\n" +
                "nsed omnis non odio\n" +
                "nexpedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nnam impedit esse");
        return js1;
    }

      public Map mapBody(){

          Map<String, Object> body4 = new HashMap<>();
          body4.put("title", "Ahmeti");
          body4.put("body", "Merhabam");
          body4.put("userId",  12.0);
          body4.put("Id", 70.0);

          return body4;


        }
      }


