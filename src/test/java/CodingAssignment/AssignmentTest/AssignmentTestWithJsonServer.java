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
	
	RequestSpecification request = new RequestSpecBuilder().setBaseUri("http://localhost:3000/teamRCB").build();
	ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	@Test
	public void validateTeamHasFourForeignPlayers()
	{
		TeamRCB[] rcb = given().spec(request).expect().defaultParser(Parser.JSON)
				.when().get()
				.then().spec(response).extract()
				.as(TeamRCB[].class);
		int totalForeignPlayers = 0;
		for(int i=0;i< rcb[0].getPlayer().size();i++)
		{			
			if(!rcb[0].getPlayer().get(i).getCountry().equalsIgnoreCase("India"))
				totalForeignPlayers = totalForeignPlayers + 1;		
		}
		Assert.assertEquals(totalForeignPlayers , 4 , "Foreign players should not be more than 4");
	}
	
	@Test
	public void validateTeamHasAtleastOneWicketKeeper()
	{		
		TeamRCB[] rcb = given().spec(request).expect().defaultParser(Parser.JSON)
				.when().get()
				.then().spec(response).extract()
				.as(TeamRCB[].class);
		int totalWicketKeeper = 0;
		for(int i=0;i< rcb[0].getPlayer().size();i++)
		{
			if(rcb[0].getPlayer().get(i).getRole().equalsIgnoreCase("Wicket-keeper"))
				totalWicketKeeper = totalWicketKeeper + 1;
		
		}
		Assert.assertTrue(totalWicketKeeper>0 , "Total number of wicket keepers in the team are more than 1"); 
		
		
	

	}
}
