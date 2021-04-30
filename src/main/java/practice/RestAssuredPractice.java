package practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPractice {
    public static void main(String[] args) {
        String url = "http://3.20.225.112:8082/food/cache/add";
        String body = "{\n" +
                "   \"description\":\"Lagman\",\n" +
                "   \"imageUrl\": \"https:foods\",\n" +
                "   \"price\": \"15.00\",\n" +
                "   \"name\": \"Lagman\",\n" +
                "   \"foodType\": \"MainDish\"  \n" +
                "}";

        String listFoodUrl = "http://3.20.225.112:8082/food/cache/list";

        //static method from rest assured library
        //JAVA http clients - who send requests=client.
        RequestSpecification s; // responsible for parameters - authorization+ headers + body
        Response response = RestAssured.given ()
                .baseUri (listFoodUrl)
        .contentType (ContentType.JSON)//request type
        .accept (ContentType.JSON)//response type
        .when()
        .request ("GET");

        System.out.println (response.getStatusCode () + " \n" + response.getBody ().asString ());//200




        Response response2 = RestAssured
                .given ()
                .baseUri (listFoodUrl)
                .contentType (ContentType.JSON)//request type
                .accept (ContentType.JSON)//response type
                .when()
                .request ("GET");

        System.out.println (response.getStatusCode () + " \n" + response.getBody ().asString ());//200



    }
}
