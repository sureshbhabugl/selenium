package library;

public class RSAPITestData {
	
	public static String getPlacePayload() {
	
			String createPlace = "{\n" + 
			"  \"location\": {\n" + 
			"    \"lat\": -38.383494,\n" + 
			"    \"lng\": 33.427362\n" + 
			"  },\n" + 
			"  \"accuracy\": 50,\n" + 
			"  \"name\": \"Frontline house\",\n" + 
			"  \"phone_number\": \"(+91) 983 893 3937\",\n" + 
			"  \"address\": \"255, QA Blvd, Mount Laurel, NY\",\n" + 
			"  \"types\": [\n" + 
			"    \"shoe park\",\n" + 
			"    \"shop\"\n" + 
			"  ],\n" + 
			"  \"website\": \"http://google.com\",\n" + 
			"  \"language\": \"French-IN\"\n" + 
			"}\n" + 
			"";
	
		return createPlace;
	}
	
	
	public static String getDynamicPlacePayload() {
	
		String dynamicPlacePayload= "{\n" + 
			"  \"location\": {\n" + 
			"    \"lat\": -38.383494,\n" + 
			"    \"lng\": 33.427362\n" + 
			"  },\n" + 
			"  \"accuracy\": 50,\n" + 
			"  \"name\": \"SaddleBred Blvd House\",\n" + 
			"  \"phone_number\": \"(+91) 983 893 3937\",\n" + 
			"  \"address\": \"255, QA Blvd, Mount Laurel, NY\",\n" + 
			"  \"types\": [\n" + 
			"    \"shoe park\",\n" + 
			"    \"shop\"\n" + 
			"  ],\n" + 
			"  \"website\": \"http://google.com\",\n" + 
			"  \"language\": \"French-IN\"\n" + 
			"}\n" + 
			"";
		return dynamicPlacePayload;
	}
	
	
	public static String updatePlace(String placeID) {
		String updatePlace= "{\n" + 
	
			"    \"location\": {\n" + 
			"        \"lat\": 38.383494,\n" + 
			"        \"lng\": -33.427362\n" + 
			"    },\n" + 
			"    \"accuracy\": 100,\n" + 
			"    \"name\": \"Albany Glen\",\n" + 
			"    \"phone_number\": \"(+1) 614 732 2134\",\n" + 
			"    \"address\": \"-6475, Ulfstead Street, Columbus, OH, 43230\",\n" + 
			"    \"types\": [\n" + 
			"        \"shoe park\",\n" + 
			"        \"shop\"\n" + 
			"    ],\n" + 
			"    \"website\": \"http://google.com\",\n" + 
			"    \"language\": \"English-IN\",\n" + 
			"    \"key\":\"qaclick123\",\n" + 
			"    \"place_id\":\""+placeID+"\"\n" + 
			"}";
		
		return updatePlace;
	}
	
	
	public static String deletePlace(String placeID) {
		String deletePlace= "{\n" + 
				"    \"place_id\":\""+placeID+"\"\n" + 
				"}";
		
		return deletePlace;
	}
	
	
	public static String DEFAULT_PLACE_ID = "8030186d6b8a035f0896299508dc263f";
	
	
	public static void assertExample() {
		
		
		
	}

}
