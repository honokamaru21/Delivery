package steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;

public class Hooks {

    @Before
    public void setUp(){
        String cacheReset = "http://localhost:8082/food/resetcache";
        RestAssured.given ()
                .baseUri (cacheReset)
                .accept (ContentType.JSON)//response type
                .when ()
                .request ("POST");
    }
}
