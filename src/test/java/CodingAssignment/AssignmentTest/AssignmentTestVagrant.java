package CodingAssignment.AssignmentTest;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Pojo.TeamRCB;

import org.testng.Assert;

import Utilities.HelperClass;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class AssignmentTestVagrant {
	
	@Test
	public void validateTeamHasFourForeignPlayers()
	{
		RestAssured.baseURI = "http://localhost:3000/teamRCB";		
		TeamRCB[] rcb = given().expect().defaultParser(Parser.JSON)
				.when().get().as(TeamRCB[].class);
		int totalForeignPlayers = 0;
		for(int i=0;i< rcb[0].getPlayer().size();i++)
		{			
			if(!rcb[0].getPlayer().get(i).getCountry().equalsIgnoreCase("India"))
				totalForeignPlayers = totalForeignPlayers + 1;		
		}
		Assert.assertEquals(totalForeignPlayers , 4);
	}
	
	@Test
	public void validateTeamHasAtleastOneWicketKeeper()
	{
		RestAssured.baseURI = "http://localhost:3000/teamRCB";		
	
		
		TeamRCB[] rcb = given().expect().defaultParser(Parser.JSON)
		.when().get().as(TeamRCB[].class);
		int totalWicketKeeper = 0;
		for(int i=0;i< rcb[0].getPlayer().size();i++)
		{
			if(rcb[0].getPlayer().get(i).getRole().equalsIgnoreCase("Wicket-keeper"))
				totalWicketKeeper = totalWicketKeeper + 1;
		
		}
		Assert.assertTrue(totalWicketKeeper>0 , "Total number of wicket keepers in the team are more than 1"); 
		
		
	

	}
}
