package library;


import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

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
								.build();
				
	}

}
