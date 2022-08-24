package CodingAssignment.AssignmentTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;
import Utilities.HelperClass;
import io.restassured.path.json.JsonPath;


public class AssignmentTestsWithJson {
	JsonPath teamRcbJson; 
	
	// BeforeSuite hook to get JSON by using JsonPath before the execution of all the tests
	@BeforeSuite
	public void BeforeExecution()
	{
		teamRcbJson = HelperClass.teamRcbJson();
	}
	
	@Test
	public void validateTeamHasFourForeignPlayers()
	{
		int totalForeignPlayers = 0;
		
		//Loop to get total foreign players in the team
		for(int i=0;i< teamRcbJson.getInt("player.size()");i++)
		{			
			if(!teamRcbJson.get("player["+i+"].country").toString().equalsIgnoreCase("India"))
				totalForeignPlayers = totalForeignPlayers + 1;		
		}
		
		//Assertion to validate if the number of foreign players in the team are 4
		Assert.assertEquals(totalForeignPlayers , 4 , "Foreign players should not be more than 4");
	}
	
	@Test
	public void validateTeamHasAtleastOneWicketKeeper()
	{
		int totalWicketKeeper = 0;
		
		//Loop to get total wicket keepers in the team
		for(int i=0;i< teamRcbJson.getInt("player.size()");i++)
		{			
			if(teamRcbJson.get("player["+i+"].role").toString().equalsIgnoreCase("Wicket-keeper"))
				totalWicketKeeper = totalWicketKeeper + 1;		
		}
		
		//Assertion to validate if the number of wicket keepers in the team are atleast 1
		Assert.assertTrue(totalWicketKeeper>1 , "Total number of wicket keepers in the team are atleast 1"); 
	}

}
