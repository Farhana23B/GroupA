package com.osa.base;

import org.apache.log4j.Logger;

import com.osa.utils.ProApi;
import com.osa.utils.Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequestApi {
	
	public static void main(String[] args) {
		String par=Utility.payLoadforPatch("firstName: NameFarhana:lastName:NameBegum ");
		
		patchRequest(par);
		
	}
	
	public static ProApi pro= new ProApi("/application.properties");
	public static Logger log=Utility.getLog(PatchRequestApi.class);
	
	
	public static Response patchRequest(String payload2) {
		log.info("Patch Request is sent");
		RestAssured.baseURI=pro.propApi("baseURI");
		RequestSpecification rs=RestAssured.given().auth().preemptive().basic(pro.propApi("username"),
				pro.propApi("password"));
		Response res=rs.header("Content-type", "application/json").
				body(payload2).
				patch(pro.propApi("updateStudentID"));
		log.info("Patch request is complete");
		res.prettyPrint();
		log.info("=======the status code is "+ res.getStatusCode()+"==========");
		
		return res;
		
	}

}
