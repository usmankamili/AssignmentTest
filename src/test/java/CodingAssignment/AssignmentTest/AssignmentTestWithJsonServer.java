package CodingAssignment.AssignmentTest;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import Pojo.TeamRCB;
import org.testng.Assert;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AssignmentTestWithJsonServer {
	
	//RequestSpecification for mock JSON server
	RequestSpecification request = new RequestSpecBuilder().setBaseUri("http://localhost:3000/teamRCB").build();
	//ResponseSpecification for mock JSON server
	ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	@Test
	public void validateTeamHasFourForeignPlayers()
	{
		//Get response from JSON server and get response in POJO class also verifies 200 status code
		TeamRCB[] rcb = given().spec(request).expect().defaultParser(Parser.JSON)
				.when().get()
				.then().spec(response).extract()
				.as(TeamRCB[].class);
		int totalForeignPlayers = 0;
		
		//Loop to get total foreign players in the team
		for(int i=0;i< rcb[0].getPlayer().size();i++)
		{			
			if(!rcb[0].getPlayer().get(i).getCountry().equalsIgnoreCase("India"))
				totalForeignPlayers = totalForeignPlayers + 1;		
		}
		
		//Assertion to validate if the number of foreign players in the team are 4
		Assert.assertEquals(totalForeignPlayers , 4 , "Foreign players should not be more than 4");
	}
	
	@Test
	public void validateTeamHasAtleastOneWicketKeeper()
	{		
		//Get response from JSON server and get response in POJO class also verifies 200 status code

		TeamRCB[] rcb = given().spec(request).expect().defaultParser(Parser.JSON)
				.when().get()
				.then().spec(response).extract()
				.as(TeamRCB[].class);
		int totalWicketKeeper = 0;
		
		//Loop to get total wicket keepers in the team
		for(int i=0;i< rcb[0].getPlayer().size();i++)
		{
			if(rcb[0].getPlayer().get(i).getRole().equalsIgnoreCase("Wicket-keeper"))
				totalWicketKeeper = totalWicketKeeper + 1;
		
		}
		
		//Assertion to validate if the number of wicket keepers in the team are atleast 1
		Assert.assertTrue(totalWicketKeeper>0 , "Total number of wicket keepers in the team are atleast 1"); 
		
		
	

	}
}
