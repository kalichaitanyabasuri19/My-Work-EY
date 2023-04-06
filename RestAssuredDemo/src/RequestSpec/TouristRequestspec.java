package RequestSpec;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import pojo.Tourist;
import pojo.Touristput;

public class TouristRequestspec {
	
	

	public RequestSpecification PostTouristdatarequestbuild() {
		
		RequestSpecification req=new RestAssured().given();
		req.header("Content-Type","application/json");
		Tourist t=new Tourist("chaitanya446", "chaitanya441@gmail.com","testa");
		req.log().all()
//				.header("Content-Type","application/json")
		.body(t);
		return req;
	}
	
	public RequestSpecification getTouristdatarequestbuild() {
		
		RequestSpecification req=new RestAssured().given();
		req.queryParam("page",2);
		return req;
	}
}
