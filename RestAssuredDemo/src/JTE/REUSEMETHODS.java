package JTE;

import io.restassured.path.json.JsonPath;

public class REUSEMETHODS {
	public static JsonPath rawToJson(String response) 
	{
		JsonPath js1 = new JsonPath(response);
		return js1;
	}
	

}
