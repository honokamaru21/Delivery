package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class RestApiUtils {


    public void requestSpecification(){

    }

    public void addFood(String body){
        String url = "http://" + ConfigReader.getProperty ("food.delivery.base.url") + ":"
                + ConfigReader.getProperty ("food.delivery.port.number") +"/food/cache/add";

        Response response = RestAssured.given ()
                .baseUri (url)
                .contentType (ContentType.JSON)//request type
                .accept (ContentType.JSON)//response type
                .body (body)
                .when ()
                .request ("POST");
    }

    public void listCachedFood(){
        String url = "http://" + ConfigReader.getProperty ("food.delivery.base.url") + ":"
                + ConfigReader.getProperty ("food.delivery.port.number") +"/food/cache/list";

        Response response = RestAssured.given ()
                .baseUri (url)
                .contentType (ContentType.JSON)//request type
                .accept (ContentType.JSON)//response type
                .when ()
                .request ("GET");
    }

    public void updateCachedFood(){
        String url = "http://" + ConfigReader.getProperty ("food.delivery.base.url") + ":"
                + ConfigReader.getProperty ("food.delivery.port.number") +"/food/";

        Response response = RestAssured.given ()
                .baseUri (url)
                .contentType (ContentType.JSON)//request type
                .accept (ContentType.JSON)//response type
                .when ()
                .request ("PUT");
    }

    public void commitCachedFood(){
        String url = "http://" + ConfigReader.getProperty ("food.delivery.base.url") + ":"
                + ConfigReader.getProperty ("food.delivery.port.number") +"/food/commit";

        Response response = RestAssured.given ()
                .baseUri (url)
                .contentType (ContentType.JSON)//request type
                .accept (ContentType.JSON)//response type
                .when ()
                .request ("POST");
    }
}
