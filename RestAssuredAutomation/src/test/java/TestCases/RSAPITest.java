package TestCases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;  // Remember to import this statically
import static org.hamcrest.Matchers.*;


import library.RSAPIConfig;
import library.RSAPIEndPoints;
import library.RSAPITestData;
import library.RSAPIUtil;

public class RSAPITest extends RSAPIConfig{
	
	public String placeID; // Variable to hold the placeID
	
	// Creating a new place
	@Test(description="Adding a place into the system")
	public static void addPlace() {
		
		given()
				.body(RSAPITestData.getPlacePayload())
		.when()
				.post(RSAPIEndPoints.ADDPLACE)
		.then();		
	}
	
	
	//Searching the default value from the database using the pLcae ID from the maps API
	@Test(description = "To get the default place ID")
	public void getPlaceUsingDEFAULTPlaceID() {
	
		given()
			.queryParam("place_id", RSAPITestData.DEFAULT_PLACE_ID)
		.when()
			.get(RSAPIEndPoints.GETPLACE)
		.then()
			.assertThat()
			.body("name",equalTo("Frontline house"));
		
	}
	
	
	//Test to get the dynamic placeID and search for the place ID in get
	@Test(description="To get the place id dynamically")
	public void getDynamicPlaceID() {
		 
		placeID = RSAPIUtil.getPlaceID();  // This method returns a dynamic placeID based on default test data
		
		given()
			.queryParam("place_id", placeID)
		.when()
			.get(RSAPIEndPoints.GETPLACE)
		.then()
			.assertThat()
			.body("name",equalTo("SaddleBred Blvd House"));
		
	}
	
	//Test to update the address in the response with valid placeID picked from previous test
	@Test(description="Update the place with new data", dependsOnMethods= {"getDynamicPlaceID"})
	public void changePlaceUsingDyamicPlaceID() {
		given()
			.queryParam("place_id", placeID)
			.body(RSAPITestData.updatePlace(placeID))
		.when()
			.put(RSAPIEndPoints.PUTPLACE)
		.then()
			.assertThat()
			.body("msg", equalTo("Address successfully updated"));
		
	}
	
	//Test to update the values in the response with valid placeID picked from previous test
	@Test(description="Delete the newly added place", dependsOnMethods= {"getDynamicPlaceID"})
	public void deletePlaceUsingDynamicPlaceID() {
	
		given()
			.queryParam("place_id", placeID)
			.body(RSAPITestData.deletePlace(placeID))
		.when()
			.delete(RSAPIEndPoints.DELETEPLACE)
		.then()
			.assertThat()
			.body("status", equalTo("OK"));
		
	}
	
	
	

}
