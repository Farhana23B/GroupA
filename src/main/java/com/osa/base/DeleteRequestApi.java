package com.osa.base;

import org.apache.log4j.Logger;

import com.osa.utils.ProApi;
import com.osa.utils.Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequestApi {
	public static void main(String[] args) {
		delRequest();
		
	}
	public static ProApi pro= new ProApi("/application.properties");
	public static Logger log=Utility.getLog(DeleteRequestApi.class);
	
	
	public static Response delRequest() {
		log.info("Delete Request is sent");
		RestAssured.baseURI=pro.propApi("baseURI");
		RequestSpecification rs=RestAssured.given().auth().preemptive().basic(pro.propApi("username"),
				pro.propApi("password"));
		Response res=rs.delete(pro.propApi("delEndpoint"));
		log.info("Delete request is complete");
		res.prettyPrint();
		return res;
		
	}


}
