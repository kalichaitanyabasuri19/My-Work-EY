package SubmitRequests;

import RequestSpec.TouristRequestspec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TouristSubmitRequest {

	public Response Touristpostmethod() {
		TouristRequestspec req=new TouristRequestspec();
		RequestSpecification req1=req.PostTouristdatarequestbuild();
		Response re=req1.when().post("api/Tourist");
		
		return re;
	}
	public Response Touristgetmethod() {
		TouristRequestspec req=new TouristRequestspec();
		RequestSpecification req1=req.getTouristdatarequestbuild();
		Response re=req1.when().get("/api/Tourist");
		return re;
	}
	
}
