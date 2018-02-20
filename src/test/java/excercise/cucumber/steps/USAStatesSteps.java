package excercise.cucumber.steps;

import java.util.HashMap;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class USAStatesSteps {

	String param1;
	String param2;
	
	@Step
	public ValidatableResponse verify_Status_Code_200_For_All_endpoint(){
		return SerenityRest.rest()
		.given()
		.when()
		.get("/all")
		.then();
		
	}
	
	@Step
	public ValidatableResponse verify_Status_Code_404_For_Incorrect_HTTP_Method(){
		return SerenityRest.rest()
		.given()
		.when()
		.post("")	//sends incorrect HTTP method 'post' instead of 'get'
		.then();
		
	}
	
	@Step
	public List<HashMap<String,Object>> verify_No_Match_Found_message_For_Invalid_Resource(){
		
		return SerenityRest.rest()
				.given()
				.when().get("23456")
				.then()
				.extract()
				.path("RestResponse.messages");
		
	}
	
	@Step
	public List<HashMap<String,Object>> get_Capital_Name(String state) {

		if (state.length()==2) {
			param1 = "RestResponse.result.findAll{it.abbr=='";
			param2 = "'}.capital"; }
			
		else {
			param1 = "RestResponse.result.findAll{it.name=='";
			param2 = "'}.capital";
		}
		
		return SerenityRest.rest()
				.given()
				.when().get("/all")
				.then().statusCode(200)
				.extract()
				.path(param1 +state+ param2);
	}
	
	@Step
	public List<HashMap<String,Object>> get_Largest_City_Name(String state) {

		if (state.length()==2) {
			param1 = "RestResponse.result.findAll{it.abbr=='";
			param2 = "'}.largest_city"; }
			
		else {
			param1 = "RestResponse.result.findAll{it.name=='";
			param2 = "'}.largest_city";
		}
		
		return SerenityRest.rest()
				.given()
				.when().get("/all")
				.then().statusCode(200)
				.extract()
				.path(param1 +state+ param2);
	}

	
	
}
