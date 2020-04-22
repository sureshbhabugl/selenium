package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import library.Base;

// Here we are extending Base class to use the default/top level URI, BasePath and port from rest assured level.

public class BasicCRUD  extends Base{
	
	
	@Test
	public static void getCompetition() {
		
		given().
				log().all().
		when()
				.get("competitions/").
		then().
				log().all();
				
		
	}

}
