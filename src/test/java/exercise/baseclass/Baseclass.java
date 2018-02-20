package exercise.baseclass;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class Baseclass {
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://services.groupkt.com/state/get/USA";
	}

}
