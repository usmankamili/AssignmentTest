package CodingAssignment.AssignmentTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import Utilities.HelperClass;

public class AppTests {

	public static void main(String[] args) {
		RestAssured.baseURI = "http://localhost:3000/teamRCB";
		
		String response = given().log().all().header("Content-Type", "application/json")
		.when().get()
		.then().assertThat().statusCode(200).extract().response().asString();

	//	System.out.println(response);
		
		JsonPath js =  HelperClass.convertToJson(response);
		String loc =  js.getString("location[0]");
		
		System.out.println(loc);
		
		Assert.assertEquals(loc, "Bangalore");
		System.out.println(js.getString("player[0].size()"));

	}

}
