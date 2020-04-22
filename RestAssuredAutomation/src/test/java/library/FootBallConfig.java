package library;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class FootBallConfig {
	
	
	//Creating a common Request and Response specification objects
	
	public static RequestSpecification requestSpecification;
	public static ResponseSpecification responseSpecification;
	
	@BeforeMethod
	public static void setup() {
		
		requestSpecification = new RequestSpecBuilder()
								.setBaseUri(FBEndpoints.BASEURI)
								.setBasePath(FBEndpoints.BASEPATH)
								.setPort(FBEndpoints.BASEPORT)
								.addHeader("Content-Type", "application/json")
								.addFilter(new RequestLoggingFilter())    //***IMPORTANT*** This filter is to turn on the logging feature in the request
								.addFilter(new ResponseLoggingFilter())   //***IMPORTANT*** This filter is to turn on the logging feature in the response
								.build();
		
		responseSpecification = new ResponseSpecBuilder()
								.expectStatusCode(200)
								.build();
		
		RestAssured.requestSpecification = requestSpecification;
		RestAssured.responseSpecification = responseSpecification;
		
		
	}

	

}
