package library;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

public class RSAPIConfig {
	
	public static RequestSpecification requestSpecification;
	public static ResponseSpecification responseSpecification;
	
	@BeforeMethod
	public void setup() {
		
		requestSpecification = new RequestSpecBuilder()
				.setBaseUri(RSAPIEndPoints.BASEURI)
				.setBasePath(RSAPIEndPoints.BASEPATH)
				.setPort(RSAPIEndPoints.BASEPORT)
				.addHeader("Content-Type", "application/json")
				.addFilter(new RequestLoggingFilter())
				.addFilter(new ResponseLoggingFilter())
				.addQueryParam("key", "qaclick123")
				.build();
		
		responseSpecification = new ResponseSpecBuilder()
								.expectStatusCode(200)
								.expectResponseTime(lessThan(8000L), TimeUnit.MILLISECONDS)
								.build();
		
		
		RestAssured.requestSpecification = requestSpecification;
		RestAssured.responseSpecification = responseSpecification;
				
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		requestSpecification = null;
		
		responseSpecification = null;
		
		RestAssured.requestSpecification = requestSpecification;
		RestAssured.responseSpecification = responseSpecification;
				
	}

}
