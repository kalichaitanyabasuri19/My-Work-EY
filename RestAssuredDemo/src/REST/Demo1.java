package REST;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import JTE.REUSEMETHODS;
import JTE.Reuse;
public class Demo1 {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI= "http://rahulshettyacademy.com";
		String response =postmethod();
		String Address=getmethod(response);
		putmethod(response,Address);
	}
	
	public static String getmethod(String response) {
		JsonPath js=new JsonPath(response); 
		String placeId=js.getString("place_id");
		String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id",placeId)
				.when().get("maps/api/place/get/json")
				.then().assertThat().log().all().statusCode(200).extract().response().asString();
			JsonPath js1=REUSEMETHODS.rawToJson(getPlaceResponse);
			String actualAddress =js1.getString("address");
			System.out.println(actualAddress);
			Assert.assertEquals(actualAddress, "Summer Walk, Africa");
			return actualAddress;	
	}
	public static String postmethod() {
		String response =given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Reuse.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.extract().response().asString();
	return response;	
	}
	public static void putmethod(String response,String Address ) {
		JsonPath js=new JsonPath(response); 
		
		String placeId=js.getString("place_id");
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+Address+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	}

	
}
