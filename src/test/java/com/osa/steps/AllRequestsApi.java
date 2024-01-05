package com.osa.steps;

import org.apache.log4j.Logger;

import com.osa.base.BaseApi;
import com.osa.base.GetRequestApi;
import com.osa.base.PostRequestApi;
import com.osa.utils.ProApi;
import com.osa.utils.Utility;
import com.sun.tools.sjavac.Log;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllRequestsApi {

	public static ProApi pro = new ProApi("/application.properties");
	public static Logger log = Utility.getLog(AllRequestsApi.class);
	
	RequestSpecification auth;
	Response res;
	String stuid;
	
	
	@Given("I have sent baseURI and authentication")
	public void i_have_sent_baseURI_and_authentication() {
	   auth = BaseApi.initialSetup();
	}

	@When("I send get request using {string}")
	public int i_send_get_request_using(String string) {
	  Response get=BaseApi.sendGetRequest(auth, string);
	  int Getsc= get.getStatusCode();
	  return Getsc;
	  
	}

//	@Then("I validated with status code")
//	public void i_validated_with_status_code() {
//		int eSc = 200;
//	    get.prettyPrint();
//		Utility.verifySc(eSc, Getsc);
//		Utility.vStatusCode(Getsc);
//		log.info("*****Printed*****");
//	}

	

	@When("I send post request")
	public void i_send_post_request() {
		String pay=Utility.payLoad1("hello", "world", "02-08-2020", "shah@gmail.com", "341-325-3020", true, "thank you");
	  res= BaseApi.PostRequest(auth,"/students", pay);
	
	}

	@When("I verified the student ID with get request")
	public void i_verified_the_student_ID_with_get_request() {
		String stuid=res.getBody().jsonPath().getString("studentId");
		BaseApi.sendGetRequest(auth, "/students/"+stuid);
	 
	}

	@When("I send a patch request updating student info")
	public void i_send_a_patch_request_updating_student_info() {
		String patch=Utility.payLoadforPatch1("firstName", "hello World");
	    BaseApi.PatchRequest(auth, "/students/6587285d6b1cfc6df597c871",patch);
	}
	@Then("i delete a {string} id")
	public void i_delete_a_id(String string) {
	    BaseApi.delRequest(auth, string);
	}
	
	
	
	
	
	
	
}









































//	//Response gr = GetRequestApi.getRequest("/students");
//	//String S = i_send_post_request();
//
//	@Given("I have sent baseURI and authentication")
//	public static void i_have_sent_baseURI_and_authentication() {
//		sp = BaseApi.initialSetup();
//
//	}
//
////	@When("I send GET request using endpoint")
////	public void i_send_GET_request_using_endpoint() {
////		gr.prettyPrint();
////
////	}
//	@When("I send get request using {string}")
//	public void i_send_get_request_using(String string) {
//		GetRequestApi.getRequest(sp,string);
//	}
//
//
//	@When("I send post request")
//	public static void i_send_post_request() {
//		String pay = Utility.payLoad1("cad", "def", "12-12-2000", "test@gmail.com", "212-323-3333", true,
//				"just for testing");
//		
//		Response por = BaseApi.PostRequest(sp, "/students", pay);
//		String Sid = por.getBody().jsonPath().getString("studentId");
//		log.info(Sid);
//		log.info("*********post done*******");
//		//return Sid;
//	}
//
//	@When("I verified the student ID with GET request")
//	public void i_verified_the_student_ID_with_GET_request() {
//
//		Response rs1 = GetRequestApi.getRequest("/students/");
//		rs1.prettyPrint();
//
//	}
//
//	@Then("I validated with status code")
//	public void i_validated_with_status_code() {
//		int eSc = 200;
//		int aSc =gr.getStatusCode();
//		Utility.verifySc(eSc, aSc);
//		Utility.vStatusCode(aSc);
//		log.info("*****Printed*****");
//
//	}


