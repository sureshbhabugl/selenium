package library;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class Base {
	
	@BeforeTest
	public static void setup() {
		
		
		RestAssured.baseURI = "http://api.football-data.org";
		RestAssured.basePath = "v2";
		RestAssured.port = 80;
		
		
		//Adding proxy to our request and respoonse and monitoring the response over Fiddler.
		// Get the port number in which Fiddler is listeneing from the settings.
		//Now check on Fiddler and you can inspect the request and response.
		
		//RestAssured.proxy(8866);  // Only for proxy and its optional.
		
		RequestSpecification reqSpec = new RequestSpecBuilder()
									.addHeader("Content-Type","application/json")
									.build();
		
		RestAssured.requestSpecification = reqSpec;
				
		
		
	
		ResponseSpecification resSpec = new ResponseSpecBuilder()
										.expectStatusCode(200)
										.build();
		
		RestAssured.responseSpecification = resSpec;
	
	}

}
