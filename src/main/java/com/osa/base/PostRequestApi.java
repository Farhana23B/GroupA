package com.osa.base;

import org.apache.log4j.Logger;

import com.osa.utils.ProApi;
import com.osa.utils.Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestApi {

	public static ProApi pro = new ProApi("/application.properties");
	public static Logger log = Utility.getLog(PostRequestApi.class);
	static String pl = Utility.payLoad1("Abc", "def", "12-12-2000", "test@gmail.com", "212-323-3333", true,
			"just for testing");
	static RequestSpecification set = BaseApi.initialSetup();

	public static void main(String[] args) {

		postRequest(set, "/students", pl);

	}

	public static Response postRequest(RequestSpecification setup, String endpoint, String payload1) {
		log.info("Post Request is sent");
		Response res = setup.header("Content-type", "application/json").body(payload1).post("/students");
		log.info("Post request is complete");
//		res.prettyPrint();
		String stID = res.getBody().jsonPath().getString("studentId");
		System.out.println(stID);
		log.info("=======the status code is " + res.getStatusCode() + "==========");

		return res;

	}
}
