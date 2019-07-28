package com.idemia.dob.model;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Assert;

import com.idemia.dob.utils.AllApiURL;
import com.idemia.dob.utils.ConfigManager;
import com.idemia.dob.utils.GeneralMethods;
import com.jayway.restassured.response.Response;

public class AadhaarServices {

	
	public Response response;
	public String resbody;
	public String URL;
	public Boolean flag=false;
	
public void callAadhaarService(String workflowname,String actionType, String docPassword, String docFormat, String identityDocument){
	String dobTransactionId = DOBTransactionIDDetailsBean.getDOBTransID();
	
	if (dobTransactionId == null)
	{
		dobTransactionId = "";
	}
	
		try{
			URL = ConfigManager.getProperty("baseURL") + AllApiURL.initDocumentApiURL;
			//String accessToken=TokenDetalsBean.getAccessToken();
			String aadhaarServiceJSON = GeneralMethods.concateString("{\"workflowName\": \"",workflowname,"\",",
					  "\"dobTransactionId\": \"",dobTransactionId,"\",","\"identityRequestData\": [{\"workflowAction\": \"",actionType,"\",","\"data\":[","{\"fieldId\": \"docPassword\",\"values\":[\"",docPassword,"\"]}," , "{\"fieldId\": \"docFormat\",\"values\":[\"",docFormat,"\"]},",
					  "{\"fieldId\": \"identityDocument\",\"values\":[\"",identityDocument,"\"]},","]}]}");
					                                                                            
					                                                                                
					
					
			response=given().headers("txnid","1234").headers("Content-Type","application/json").headers("accessToken",TokenDetailsBean.getAccessToken()).body(aadhaarServiceJSON).when().post(URL);
			String resp= response.getBody().asString();
			System.out.println(resp);
			
			if(response.getStatusCode()==200)
			{
			flag=true;
			System.out.println("Recieved correct response for Aadhaar Service workflow method with statusCode="+response.jsonPath().get("responseHeader.statusCode")+ " and statusMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
			DOBTransactionIDDetailsBean.setDOBtransID(response.jsonPath().get("dobTransactionId").toString());
			DOBTransactionIDDetailsBean.setWorkFlowName(response.jsonPath().get("WorkflowName").toString());
			System.out.println(" DobTransactionId: "+DOBTransactionIDDetailsBean.getDOBTransID());
			Assert.assertEquals("Data saved for the workflow ", response.jsonPath().get("responseHeader.statusMessage"));
			}
			else
			{
				System.out.println("Recieved wrongs response for Aadhaar Service workflow method with errorCode="+response.jsonPath().get("responseHeader.statusCode")+ " and errorMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}


}
