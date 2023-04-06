package REST;

import static io.restassured.RestAssured.given;
import ValidateRequests.ValidateResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class Demo3 {
	
	public static void main(String[] args) {

		
		RestAssured.baseURI= "http://restapi.adequateshop.com";
		new ValidateResponse().validateDataForTouristdata();
		new ValidateResponse().validateDataForgetTouristdata();
	

	}

}
	

