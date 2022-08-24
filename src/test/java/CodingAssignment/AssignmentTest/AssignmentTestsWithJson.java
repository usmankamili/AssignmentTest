package CodingAssignment.AssignmentTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;
import Utilities.HelperClass;
import io.restassured.path.json.JsonPath;


public class AssignmentTestsWithJson {
	JsonPath teamRcbJson; 
	
	@BeforeSuite
	public void BeforeExecution()
	{
		teamRcbJson = HelperClass.teamRcbJson();
	}
	
	@Test
	public void validateTeamHasFourForeignPlayers()
	{
		int totalForeignPlayers = 0;
		for(int i=0;i< teamRcbJson.getInt("player.size()");i++)
		{			
			if(!teamRcbJson.get("player["+i+"].country").toString().equalsIgnoreCase("India"))
				totalForeignPlayers = totalForeignPlayers + 1;		
		}
		Assert.assertEquals(totalForeignPlayers , 4 , "Foreign players should not be more than 4");
	}
	
	@Test
	public void validateTeamHasAtleastOneWicketKeeper()
	{
		int totalWicketKeeper = 0;
		for(int i=0;i< teamRcbJson.getInt("player.size()");i++)
		{			
			if(teamRcbJson.get("player["+i+"].role").toString().equalsIgnoreCase("Wicket-keeper"))
				totalWicketKeeper = totalWicketKeeper + 1;		
		}
		Assert.assertTrue(totalWicketKeeper>0 , "Total number of wicket keepers in the team are more than 1"); 
	}

}
