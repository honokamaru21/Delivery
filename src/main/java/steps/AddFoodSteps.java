package steps;

import com.google.gson.Gson;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import domains.AddNewFoodRequestBody;
import domains.Food;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.RestApiUtils;

import java.util.List;
import java.util.logging.Logger;

public class AddFoodSteps {
    private Gson gson = new Gson();
    private Response response;
    RequestSpecification request;
    String convertedJavaObjectRequestBody;
    private String body;
    List<Food> expectedFood;
    private Food food;
    static Logger logger = Logger.getLogger(AddFoodSteps.class.getName());
 //   RestApiUtils restApiUtils = new RestApiUtils ();


    @Given("^add new food to FoodDelivery with the following fields$")
    public void add_new_food_to_FoodDelivery_with_the_following_fields(List<Food> listOfFood) throws Throwable {
//        food = new Food ();
//        food.setDescription ("Wine");
//        food.setImageUrl ("https:foods.com");
//        food.setPrice (20.00);
//        food.setName ("Merlot");
//        food.setFoodType ("Beverages");

        expectedFood = listOfFood;
        String url = "http://localhost:8082/food/cache/add";
        for (Food food : listOfFood) {
            body = gson.toJson(food);
           // response = restApiUtils.addFood (body);
        }
        response = RestAssured.given()
        .baseUri(url)
                .contentType(ContentType.JSON)//accept request body in JSON format
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .request("POST");


       // logger.info ("Adding new food: " + food.getDescription ());
    }

    @Then("^verify that status code is (\\d+)$")
    public void verify_that_status_code_is(int statusCode) throws Throwable {
        response.then().assertThat().statusCode(statusCode);
      //  logger.info("Verifying status code: " + statusCode);
    }

    @Then("^verify that food has been successfully added$")
    public void verify_that_food_has_been_successfully_added() throws Throwable {
        List<Food> cachedFood = gson.fromJson(response.asString(), AddNewFoodRequestBody.class).getFoodCached ();
        Assert.assertEquals("Food do not match", expectedFood, cachedFood);
      //  logger.info("Food has been add to cache successfully");
    }

    @Given("^add new food to FoodDelivery without image url$")
    public void add_new_food_to_FoodDelivery_without_image_url(DataTable arg1) throws Throwable {

    }

    @Then("^verify response error message \"([^\"]*)\"$")
    public void verify_response_error_message(String arg1) throws Throwable {

    }

    @Given("^add new food to FoodDelivery without price$")
    public void add_new_food_to_FoodDelivery_without_price(DataTable arg1) throws Throwable {

    }

    @Given("^add new food to FoodDelivery without name$")
    public void add_new_food_to_FoodDelivery_without_name(DataTable arg1) throws Throwable {

    }

    @Given("^add new food to FoodDelivery without food type$")
    public void add_new_food_to_FoodDelivery_without_food_type(DataTable arg1) throws Throwable {

    }

    @Given("^add new food to FoodDelivery with invalid food type$")
    public void add_new_food_to_FoodDelivery_with_invalid_food_type(DataTable arg1) throws Throwable {

    }


}
