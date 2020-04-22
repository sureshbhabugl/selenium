package TestCases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import library.FBEndpoints;
import library.FootBallConfig;

public class BasicCRUDUsingTestConfig extends FootBallConfig{
	
	//In this example, we'll add all the endpoints in the FBEndpoints.java file
	
	@Test(description="Get all competition using legacy given, when then")
	public void getCompetitions() {
		given().
		when().
			get(FBEndpoints.COMPETITIONS).
		then();
		
		
	}
	
	
	@Test(description="Get all competition simplified")
	public void getCompetitionsSimplified() {
		get(FBEndpoints.COMPETITIONS);
		
		
	}

}
