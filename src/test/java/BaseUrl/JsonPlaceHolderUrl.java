package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderUrl {

    protected RequestSpecification spec;

    @Before
    public void setSpec(){

        spec= new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/posts").build();
    }
}
