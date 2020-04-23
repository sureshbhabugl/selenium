package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import library.RSAPITestData;

public class AssertionTest {

	/*
	 * 
	 * 1. Print No of courses returned by API
	 * 
	 * 2.Print Purchase Amount
	 * 
	 * 3. Print Title of the first course
	 * 
	 * 4. Print All course titles and their respective Prices
	 * 
	 * 5. Print no of copies sold by RPA Course
	 * 
	 * 6. Verify if Sum of all Course prices matches with Purchase Amount
	 * 
	 * 
	 * 
	 */

	@Test(description = "1. Print No of courses returned by API", priority = 1)
	public static void numberOfCoursesTest() {

		JsonPath js = new JsonPath(RSAPITestData.assertExample());

		int courseCount = js.get("courses.size()");

		System.out.println("Courses count = " + courseCount);

		System.out.println("Default Website = " + js.getString("dashboard.website"));

	}

	@Test(description = "2.Print Purchase Amount", priority = 2)
	public static void printPurchaseAmount() {
		JsonPath js = new JsonPath(RSAPITestData.assertExample());

		System.out.println("Purchase Amount = " + js.getString("dashboard.purchaseAmount"));
	}

	@Test(description = "3.Print Title of the first course", priority = 3)
	public static void printTitleOfFirstCourse() {
		JsonPath js = new JsonPath(RSAPITestData.assertExample());

		System.out.println("Purchase Amount = " + js.getString("courses[0].title"));
	}

	@Test(description = "4.Print All course titles and their respective Prices", priority = 4)
	public static void printAllCourseTitleAndPrice() {
		JsonPath js = new JsonPath(RSAPITestData.assertExample());

		int courseCount = js.getInt("courses.size()");

		for (int i = 0; i < courseCount; i++) {
			System.out.println("Course Name  = " + js.getString("courses[" + i + "].title"));
			System.out.print("Course Price  = " + js.getString("courses[" + i + "].price"));
		}
	}

	@Test(description = "5.Print no of copies sold by RPA Course", priority = 5)
	public static void printRPACourseCopies() {
		JsonPath js = new JsonPath(RSAPITestData.assertExample());

		int courseCount = js.getInt("courses.size()");
		int i = 0;

		while (i < courseCount) {
			if (js.getString("courses[" + i + "].title").equalsIgnoreCase("RPA")) {
				System.out.println("Number of RPA Course copies available = " + js.getInt("courses[" + i + "].copies"));
				break;
			}
			i++;
		}

	}

	@Test(description = "6.Verify if Sum of all Course prices matches with Purchase Amount", priority = 6)
	public static void verifyTotalWithIndividualItems() {
		JsonPath js = new JsonPath(RSAPITestData.assertExample());

		int courseCount = js.getInt("courses.size()");

		int purchasePrice = js.getInt("dashboard.purchaseAmount");

		int result = 0;

		for (int i = 0; i < courseCount; i++) {
			result = result + js.getInt("courses[" + i + "].price") * js.getInt("courses[" + i + "].copies");

		}

		Assert.assertEquals(purchasePrice, result);

	}

}
