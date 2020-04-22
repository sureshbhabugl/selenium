package library;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class RSAPIUtil extends RSAPIConfig{
	
		
		public static String getPlaceID() {
		
		
		String response = given()
				.body(RSAPITestData.getDynamicPlacePayload())
		.when()
				.post(RSAPIEndPoints.ADDPLACE)
		.then()
			.extract().body().asString();	
		
		JsonPath jp = new JsonPath(response);
		
		return jp.getString("place_id");
		
	
		
	}

}
