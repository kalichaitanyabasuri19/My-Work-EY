package ValidateRequests;

import RequestSpec.TouristRequestspec;
import SubmitRequests.TouristSubmitRequest;
import TestData.Constants;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponse {

	public void validateDataForTouristdata() {
		try {
		TouristSubmitRequest reqsubmit=new TouristSubmitRequest();
		Response re=reqsubmit.Touristpostmethod();
		re.then().assertThat().log().all().statusCode(Constants.Created)
		.extract().response().asString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateDataForgetTouristdata() {
		try {
			TouristSubmitRequest reqsubmit=new TouristSubmitRequest();
			Response re=reqsubmit.Touristgetmethod();
			re.then().assertThat().log().all().statusCode(Constants.OK)
			.extract().response().asString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
