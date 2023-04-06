package REST;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://reqres.in/";
		given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("api/users").then().assertThat().statusCode(201);
		

	}

}
