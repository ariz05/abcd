package com.idemia.dob.model;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;

import org.apache.http.conn.ConnectTimeoutException;

import com.cucumber.listener.Reporter;
import com.idemia.dob.utils.AllApiURL;
import com.idemia.dob.utils.ConfigManager;
import com.idemia.dob.utils.GeneralMethods;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static org.junit.Assert.*;				


public class InitUser {

	public Response response;
	public String resbody;
	public String URL;
	public Boolean flag=false;
	

	public void initSdk() {

		try {
			URL = ConfigManager.getProperty("baseURL") + AllApiURL.initWorkflowApiURL;
			Reporter.addStepLog("URL is set "+AllApiURL.initWorkflowApiURL);
			//Making post call for initsdk api.djkdjkdjk
			/*
			String InitworkJSON = GeneralMethods.concateString("{\"clientID\":\"",
					ConfigManager.getProperty("initWorkFlow.clientID"), "\",", "\"clientSecret\":\"",
					ConfigManager.getProperty("initWorkFlow.clientSecret"), "\"}\n");
			
			response=given().headers("txnid","txn23123123").headers("Content-Type","application/json").body(InitworkJSON).when().post(URL);
					
			*/
			try {
			response=given().config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC))).contentType("x-www-form-urlencoded")
					.formParam("username", "dob_admin").formParam("password", "password").formParam("grant_type", "password").headers("txnid","txn23123123").headers("Content-Type","application/x-www-form-urlencoded").headers("Authorization","Basic ZG9iX2NvcmU6cGFzc3dvcmQ=").request()
				      .when().post(URL);
			
			
				}
			catch(NullPointerException npex){
					System.out.println(npex);
				}
						
			//Validating whether initsdk api has failed or not.
	
			if(response.getStatusCode()==200)
			{
				//if(response.jsonPath().get("responseHeader.statusCode").toString().equalsIgnoreCase("00")){
					
					System.out.println("Recieved correct response for initSdk workflow method with statusCode="+response.jsonPath().get("responseHeader.statusCode")+ " and statusMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
					TokenDetailsBean.setAccessToken(response.jsonPath().get("accessToken").toString());
					TokenDetailsBean.setRefreshToken(response.jsonPath().get("refreshToken").toString());
					System.out.println("Access Token: "+TokenDetailsBean.getAccessToken());
					Reporter.addStepLog("Access Token is generated: "+TokenDetailsBean.getAccessToken());
					System.out.println("Refresh Token: "+TokenDetailsBean.getRefreshToken());
				//}
				
			}else
			{
				assertEquals("initsdk api has failed and status message : " +response.jsonPath().get("responseHeader.statusMessage") +"and Status Code : "+response.getStatusCode(),200,response.getStatusCode());
				System.out.println("Recieved wrong response for initSdk workflow method with errorCode="+response.jsonPath().get("responseHeader.statusCode")+ " and errorMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
			}

		} catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	
	
	
	public void initUserAPI(String applicantId,String name ,String dob,String email,String father_name ,String gender ,String mobile,String status){
		
		System.out.println(name);
		String dobe = GeneralMethods.setValue(dob);
		System.out.println("value of dob  is " +dobe);
		Reporter.addStepLog("applicantId: "+applicantId + "name: " +name + " dob: " +dob +" email: " +email +" father_name: " +father_name +" gender: " +gender +" mobile: " +mobile + " status: " +status);	
		
		try{
			URL = ConfigManager.getProperty("baseURL") + AllApiURL.initUserAPiURL;
			//String accessToken=TokenDetalsBean.getAccessToken();
			
			String initUserJSON = GeneralMethods.concateString("{\"applicantId\":\"",
					applicantId, "\",", "\"userDetails\":[{\"userDetailsField\":"," \"dob\",\"userDetailsFieldValue\":  ",GeneralMethods.setValue(dob),
					" },{\"userDetailsField\":\"email\",\"userDetailsFieldValue\":\" ",email,
					" \"},{\"userDetailsField\":\"father_name\",\"userDetailsFieldValue\":\" ",father_name,
					" \"},{\"userDetailsField\":\"gender\",\"userDetailsFieldValue\":\" ",gender,
					" \"},{\"userDetailsField\":\"mobile\",\"userDetailsFieldValue\":\" ",mobile,
					" \"},{\"userDetailsField\":\"name\",\"userDetailsFieldValue\":\" ",name,
					" \"},{\"userDetailsField\":\"status\",\"userDetailsFieldValue\":\"",status,"\"}], \"addresses\":[ {\"addressType\":\"",commonData.addressTypeP,
					"\", \"addressDetails\": [ { \"addressField\": \"address1\", \"addressFieldValue\":\" ",commonData.address1," \"}, { \"addressField\": \"address2\", \"addressFieldValue\":\" ",
					commonData.address2," \"}, { \"addressField\": \"country\", \"addressFieldValue\":\" ",commonData.country," \"}, { \"addressField\": \"state\", \"addressFieldValue\":\" ",commonData.state,
					" \"}, { \"addressField\": \"city\", \"addressFieldValue\":\" ",commonData.city,
					" \"}, { \"addressField\": \"district\", \"addressFieldValue\":\" ",commonData.district," \"}, { \"addressField\": \"sub_dist\", \"addressFieldValue\":\" ",commonData.sub_dist,
					" \"}, { \"addressField\": \"street\", \"addressFieldValue\":\" ",commonData.street," \"} ] } ],  \"filters\":[ { \"filterName\": \"filter1\", \"filterValue\": \" ",commonData.filter1,
					" \"} , {\"filterName\":\"filter2\", \"filterValue\": \" ",commonData.filter2," \"} , {\"filterName\":\"filter3\", \"filterValue\": \" ",commonData.filter3," \"}]}\n");
					
			response=given().headers("txnid","txn23123123").headers("Content-Type","application/json").headers("accessToken","dnldkjdd9038kldnmlkdnnd98373").body(initUserJSON).when().post(URL);
			
			Reporter.addScenarioLog("applicantId: "+applicantId + "name: " +name + " dob: " +dob +" email: " +email + "\n "+ "father_name: " +father_name +" gender: " +gender +" mobile: " +mobile + " status: " +status);
			if(response.getStatusCode()==200)
			{
				
			flag=true;
			System.out.println("Recieved correct response for inituser workflow method with statusCode="+response.jsonPath().get("responseHeader.statusCode")+ " and statusMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
			applicantIDDetailsBean.setapplicantID(response.jsonPath().get("applicantId").toString());
			}
			else
			{
				
				assertEquals("inituser api has failed and status message : " +response.jsonPath().get("responseHeader.statusMessage") +"and Status Code : "+response.getStatusCode(),200,response.getStatusCode());
				System.out.println("Recieved wrong response for inituser workflow method with errorCode="+response.jsonPath().get("responseHeader.statusCode")+ " and errorMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		
	}
