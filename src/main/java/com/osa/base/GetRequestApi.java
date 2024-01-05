package com.osa.base;

import org.apache.log4j.Logger;

import com.osa.utils.ProApi;
import com.osa.utils.Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestApi {
	
	public static int eSc;
	public static int aSc;
	public static ProApi pro= new ProApi("/application.properties");
	public static Logger log=Utility.getLog(GetRequestApi.class);
	
	
	
	public static Response getRequest(RequestSpecification setup,String endpoint) {
		
		log.info("Get Request is sent");
		RestAssured.baseURI=pro.propApi("baseURI");
		RequestSpecification rs=RestAssured.given().auth().preemptive().basic(pro.propApi("username"),
				pro.propApi("password"));
		Response res=rs.get(pro.propApi("endpoint"));
		log.info("Get request is complete");
		res.prettyPrint();
		int eSc=200;
		int aSc=res.getStatusCode();
		Utility.verifySc(eSc, aSc);
		Utility.vStatusCode(aSc);
		return res;
		
	}

}
