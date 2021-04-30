package steps;

import com.google.gson.Gson;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import domains.Food;
import io.restassured.response.Response;

import java.util.List;
import java.util.logging.Logger;

public class AddFoodSteps {
    private Gson gson = new Gson();
    private Response response;
    private String body;
    List<Food> expectedFood;
    private Food food;
    static Logger logger = Logger.getLogger(AddFoodSteps.class.getName());


    @Given("^add new food to FoodDelivery with the following fields$")
    public void add_new_food_to_FoodDelivery_with_the_following_fields(DataTable arg1) throws Throwable {

    }

    @Then("^verify that status code is (\\d+)$")
    public void verify_that_status_code_is(int arg1) throws Throwable {

    }

    @Then("^verify that food has been successfully added$")
    public void verify_that_food_has_been_successfully_added() throws Throwable {

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
