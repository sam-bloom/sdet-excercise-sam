package exercise.cucumber.serenity;


import java.util.HashMap;
import java.util.List;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import excercise.cucumber.steps.USAStatesSteps;
import static org.junit.Assert.*;

public class SerenityTestSteps {
	
	static String verifyMsg = "No matching state found for requested code";
	static String nullValue ="[]";
	
	@Steps
	USAStatesSteps steps;
	
	@When("^User sends a GET request to the endpoint,they must get back a valid status code 200$")
	public void get_request_to_endpoint_get_valid_status_code(){
		
		steps.verify_Status_Code_200_For_All_endpoint().statusCode(200);
	}

	@When("^Users sends a incorrect HTTP method,then they must get back status code 405$")
	public void users_sends_a_incorrect_HTTP_method_then_they_must_get_back_status_code() {
		
		steps.verify_Status_Code_404_For_Incorrect_HTTP_Method().log().all();
	}

	@When("^Users sends invalid resources,then they must get back verify no match found message$")
	public void users_sends_invalid_resources_then_they_must_get_back_status_code() {
		
		List<HashMap<String,Object>> noMatchFoundMsg = steps.verify_No_Match_Found_message_For_Invalid_Resource();
		System.out.println(noMatchFoundMsg+":noMatchFoundMsg..........");
		
		assertTrue("verify no match found message.",noMatchFoundMsg.toString().contains(verifyMsg));
	}

	@When("users provides state code or abbrivation (.*),Then capital (.*) and largest city (.*) names should be retrieved$")
	public void users_provides_state_code_or_abbrivation(String state, String capital_name, String largest_city_name) {
		
		List<HashMap<String,Object>> capital = steps.get_Capital_Name(state);
		List<HashMap<String,Object>> largestCity = steps.get_Largest_City_Name(state);
		
		assertTrue("Mismatch in actual and expected Capital name.",capital.contains(capital_name));
		assertTrue("Mismatch in actual and expected Largest city name.",largestCity.contains(largest_city_name));
	}
	
	@When("users provides invalid state code or abbrivation (.*),Then no match found message names should be retrieved$")
	public void users_provides_invalid_state_code_or_abbrivation(String state) {
		
		List<HashMap<String,Object>> capital = steps.get_Capital_Name(state);
		List<HashMap<String,Object>> largestCity = steps.get_Largest_City_Name(state);
		
		assertTrue("Invalid state code provided.",capital.toString().contains(nullValue));
		assertTrue("Invalid state code provided.",largestCity.toString().contains(nullValue));
	}
	


}
