package practice;

import com.google.gson.Gson;
import domains.AddNewFoodRequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class RestAssuredTest {

//    @Before
//    public void setUp() {
//        String cacheReset = "http://localhost:8082/food/resetcache";
//        RestAssured.given ()
//                .baseUri (cacheReset)
//                .accept (ContentType.JSON)//response type
//                .when ()
//                .request ("POST");
//    }

    @Test
    public void Test() {
        String listFoodUrl = "http://localhost:8082/food/cache/list";

        //static method from rest assured library
        //JAVA http clients - who send requests=client.
        RequestSpecification s; // responsible for parameters - authorization+ headers + body
        Response response = RestAssured.given ()
                .baseUri (listFoodUrl)
                .contentType (ContentType.JSON)//request type
                .accept (ContentType.JSON)//response type
                .when ()
                .request ("GET");

        System.out.println (response.getStatusCode () + " \n" + response.getBody ().asString ());//200
        Assert.assertEquals (200, response.getStatusCode ());

    }

    @Test
    public void Test2() {
        String url = "http://localhost:8082/food/cache/add";
       // RestAssured.baseURI = "http://localhost:8082/food/";
        String body = "{\n" +
                "   \"description\":\"Lagman\",\n" +
                "   \"imageUrl\": \"https:foods\",\n" +
                "   \"price\": \"15.00\",\n" +
                "   \"name\": \"Lagman\",\n" +
                "   \"foodType\": \"MainDish\"  \n" +
                "}";

        //static method from rest assured library
        //JAVA http clients - who send requests=client.

        Response response = RestAssured.given ()
                .baseUri (url)
                .contentType (ContentType.JSON)//request type
                .accept (ContentType.JSON)//response type
                .body (body)
                .when ()
                .request ("POST");

        System.out.println (response.getStatusCode () + " \n" + response.getBody ().asString ());
        Assert.assertEquals (200, response.getStatusCode ());
    }

    @Test
    public void Test3() {
        String url = "http://localhost:8082/food/cache/add";
        String body = "{\n" +
                "            \"description\": \"Turkish Baklava\",\n" +
                "            \"imageUrl\": \"https:foods.com\",\n" +
                "            \"price\": 10.00,\n" +
                "            \"name\": \"Baklava\",\n" +
                "            \"foodType\": \"Appetizers\"\n" +
                "        }";

        //static method from rest assured library
        //JAVA http clients - who send requests=client.

        Response response = RestAssured.given ()
                .baseUri (url)
                .contentType (ContentType.JSON)//request type
                .accept (ContentType.JSON)//response type
                .body (body)
                .when ()
                .request ("POST");

        System.out.println (response.getStatusCode () + " \n" + response.getBody ().asString ());
        Assert.assertEquals (200, response.getStatusCode ());
        Assert.assertTrue (response.getBody ().asPrettyString ().contains ("Turkish Baklava"));

    }

    @Test
    public void Test4() {

        String url = "http://localhost:8082/food/cache/add";
        String body = "{\n" +
                "   \"description\":\"Lagman\",\n" +
                "   \"imageUrl\": \"https:foods\",\n" +
                "   \"price\": \"25.00\",\n" +
                "   \"name\": \"Lagman\",\n" +
                "   \"foodType\": \"MainDish\"  \n" +
                "}";

        Response response = RestAssured.given()
                .baseUri(url)
                .contentType(ContentType.JSON)//accept request body in JSON format
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .request("POST");

        Assert.assertEquals(200, response.getStatusCode());


        System.out.println(response.getBody().asPrettyString());
        Gson gson = new Gson();
        //fromJson(String json, WhichClass to convert it to?)
        AddNewFoodRequestBody convertedToJavaObjectResponseBody
                = gson.fromJson(response.getBody().asString(), AddNewFoodRequestBody.class);

        Assert.assertEquals(1, convertedToJavaObjectResponseBody.getFoodCached().size());
        Assert.assertEquals("Lagman", convertedToJavaObjectResponseBody.getFoodCached().get(0).getDescription());
        //Assert.assertEquals(15.0,convertedToJavaObjectResponseBody.getFoodCached().get(0).getPrice(), 0);
    }
}
