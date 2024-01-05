package com.osa.base;

import org.apache.log4j.Logger;

import com.osa.utils.ProApi;
import com.osa.utils.Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseApi {
	public static Logger log = Utility.getLog(BaseApi.class);
	public static ProApi pro = new ProApi("/application.properties");
	public static RequestSpecification setup = initialSetup();
	public static String pp = Utility.payLoadforPatch1("firstName", "hello");

	
	public static void main(String[] args) {
		
	

	// get
//	 Response get = sendGetRequest(req, "/students");

	// post
	 String pay = Utility.payLoad1("cad", "def", "12-12-2000", "test@gmail.com", "212-323-3333", true,
			"just for testing");

	 Response pr = PostRequestApi.postRequest(setup, "/students", pay);

	 String Sid = pr.getBody().jsonPath().getString("studentId");

	// get
	 Response sgar = sendGetRequest(setup, "/students/"+ Sid);

	// patch
	 Response par = PatchRequest(setup,"/students/"+ Sid, pp);

	// get
	Response sgr = sendGetRequest(setup, "/students/"+ Sid);

	// delete
	Response del = delRequest(setup,"/students/"+ Sid);

	// get
	Response sgr1 = sendGetRequest(setup, "/students/"+ Sid);
	
	
	
	}

	public static RequestSpecification initialSetup() {
		RestAssured.baseURI = "https://students-apps.herokuapp.com";
		RequestSpecification req = RestAssured.given().auth().preemptive().basic("test", "test");
		return req;
	}

	public static Response sendGetRequest(RequestSpecification setup, String endpoint) {
		log.info("Get request is passed");
		Response res = setup.get(endpoint);
		res.prettyPrint();
		return res;
	}

	public static Response PostRequest(RequestSpecification setup,String endpoint, String payload) {

		Response res = setup.header("Content-type", "application/json").body(payload).post(endpoint);
//		String sId=res.getBody().jsonPath().getString("studentId");
		return res;
	}

	public static Response PatchRequest(RequestSpecification setup,String endpoint, String payload) {
		Response res = initialSetup().header("Content-type", "application/json").body(payload).patch(endpoint);
		return res;
	}

	public static Response delRequest(RequestSpecification setup,String endpoint) {
		Response res = setup.delete(endpoint);
		return res;
	}
}
