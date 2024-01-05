package com.osa.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONObject;
import org.testng.Assert;

public class Utility {
	
	public static Logger log=getLog(Utility.class);
	
	public static void verify(String expected, String acutual) {
		if(expected.equals(acutual)) {
			log.info("Passed");
		}else {
			log.info("Failed");
			log.info("Expected: "+expected);
			log.info("Actual  : "+acutual);
			Assert.assertEquals(expected, acutual);
		}
	}
	
	public static void verifySc(int expected, int actual) {
		
		if(expected==(actual)) {
			log.info("Passed");
		}else {
			log.info("Failed");
			log.info("Expected: "+expected);
			log.info("Actual  : "+actual);
			Assert.assertEquals(expected, actual);
		}
		}
	
		public static Logger getLog(Class clazz) {
		Logger log=Logger.getLogger(clazz);
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		return log;
		}
		

		public static String payLoad1(String fn,String ln,String dob,String email,String phone,boolean agree,String msg) {
			
			JSONObject pl=new JSONObject();
			pl.put("firstName", fn);
			pl.put("lastName", ln);
			pl.put("dob", dob);
			JSONObject contInfo=new JSONObject();
			pl.put("contractInfo", contInfo);
			contInfo.put("email", email);
			contInfo.put("phone", phone);
			JSONObject ag=new JSONObject();
			pl.put("aggrement",ag);
			ag.put("agree", agree);
			ag.put("message",msg);
			
			
			System.out.println("requested payload \n"+pl.toString());
			return pl.toString();//we use pl.toString() to convert the boolean return type to string from parameter
			
		}
		

		public static String payLoadforPatch1(String sendKey, String sendValue) {
			JSONObject ob= new JSONObject();
			ob.put(sendKey, sendValue);
			return ob.toString();
			
		}
		
		
		
		public static String payLoadforPatch( String ...keyAndValue) {
			JSONObject ob= new JSONObject();
			for (String keyWord: keyAndValue){
				ob.put(keyWord.split(":")[0], keyWord.split(":")[1]);
				ob.put(keyWord.split(":")[2], keyWord.split(":")[3]);
			}
			return ob.toString();
			
		}
		
		
		
		public static int vStatusCode(int i) {
			
			if ( i==200) {
				System.out.println(i+" The request is successful ");
			}
			else if(i==201) {
				System.out.println(i+ " the request is created");
			}
			else if(i==202) {
				System.out.println(i+" the request is accepted");
			}
			else if(i==401) {
				System.out.println(i+" the request is unauthorized");
			}
			else if(i==403) {
				System.out.println(i+" the request is forbidden");
			}
			else if(i==404) {
				System.out.println(i+" the request is not found");
			}
			else if(i==500) {
				System.out.println(i+" the request is internal server error");
			}
			else if(i==501) {
				System.out.println(i+" the request is not implemented");
			}
			else if(i==503) {
				System.out.println(i+" the request is service unavailable ");
			}
			else{
				System.out.println("******Oi server valo pai nai*******");
			}
			return i;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
//	public static void verify(String expected, String actual) {
//		if (expected.equals(actual)) {
//			System.out.println("****Result matches****");
//		} else {
//			System.out.println("The test has failed");
//			System.out.println("If the test is failed please look from here");
//			System.out.println("Expected value is:====" + expected);
//			System.out.println("Actual value is:======" + actual);
//
//		}
	}
	
	


