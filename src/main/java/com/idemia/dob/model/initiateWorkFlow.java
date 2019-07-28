package com.idemia.dob.model;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;

import com.idemia.dob.utils.AllApiURL;
import com.idemia.dob.utils.ConfigManager;
import com.idemia.dob.utils.GeneralMethods;
import com.jayway.restassured.response.Response;

public class initiateWorkFlow {
	public Response response;
	public String resbody;
	public String URL;
	public Boolean flag=false;
	
	public void initWorkflow() {
		HashMap<String, String> headers=new HashMap<String, String>();
		try {
			URL = ConfigManager.getProperty("baseURL") + AllApiURL.finalizeAsyncWorkflowApiURL;
			String InitworkJSON = GeneralMethods.concateString("{\"applicantId\":\"",
					applicantIDDetailsBean.getapplicantID(), "\",", "\"dobTransactionId\":\"",
					DOBTransactionIDDetailsBean.getDOBTransID(),"\",", "\"workflowName\":\"",
					DOBTransactionIDDetailsBean.getWorkFlowName(), "\"}\n");
			
			response=given().headers("txnid","txn23123123").headers("Content-Type","application/json").body(InitworkJSON).when().post(URL);
					//body(InitworkJSON).when().post(URL);
			String resp= response.getBody().asString();
			System.out.println(resp);
			if(response.getStatusCode()==200){
				//if(response.jsonPath().get("responseHeader.statusCode").toString().equalsIgnoreCase("00")){
				System.out.println("Recieved correct response for finalize workflow method with statusCode="+response.jsonPath().get("responseHeader.statusCode")+ " and statusMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
				//}
				
			}else{
				System.out.println("Recieved wrong response for finalize workflow method with errorCode="+response.jsonPath().get("responseHeader.statusCode")+ " and errorMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
