package Utilities;
import io.restassured.path.json.JsonPath;

public class HelperClass {
	
	public static JsonPath convertToJson(String response)
	{
		return new JsonPath(response);		
	}

}
