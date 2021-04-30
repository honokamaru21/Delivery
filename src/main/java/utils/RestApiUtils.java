package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;

public class RestApiUtils {
    private static final String URL =ConfigReader.getProperty ("food_delivery_base_url");

    public RequestSpecification requestSpecification(){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }

    public Response addFood(String body){

        return requestSpecification()
                .baseUri (URL)
                .body (body)
                .when ()
                .post("/food/cache/add");
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
