package com.idemia.dob.model;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Assert;

import com.idemia.dob.utils.AllApiURL;
import com.idemia.dob.utils.ConfigManager;
import com.idemia.dob.utils.GeneralMethods;
import com.jayway.restassured.response.Response;

public class AuthBridgeDBCheck {
	
	public Response response;
	public String resbody;
	public String URL;
	public Boolean flag=false;
	
public void callAuthBridge(String workflowname,String actionType, String transID, String docType, String docNumber, String documentId, String documentType,String documentImage){
	String dobTransactionId = DOBTransactionIDDetailsBean.getDOBTransID();
	
	if (dobTransactionId == null)
	{
		dobTransactionId = "";
	}
	
		try{
			URL = ConfigManager.getProperty("baseURL") + AllApiURL.initDocumentApiURL;
			//String accessToken=TokenDetalsBean.getAccessToken();
			String authBridgeJSON = GeneralMethods.concateString("{\"workflowName\": \"",workflowname,"\",",
					  "\"dobTransactionId\": \"",dobTransactionId,"\",","\"identityRequestData\": [{\"workflowAction\": \"",actionType,"\",","\"data\":[","{\"fieldId\": \"transID\",\"values\":[\"",transID,"\"]}," , "{\"fieldId\": \"docType\",\"values\":[\"",docType,"\"]},",
					  "{\"fieldId\": \"docNumber\",\"values\":[\"",docNumber,"\"]},","{\"fieldId\": \"documentId\",\"values\":[\"",documentId,"\"]},","{\"fieldId\": \"documentType\",\"values\":[\"",documentType,"\"]},","{\"fieldId\": \"documentImage\",\"values\":[\"",documentImage,"\"]},",
					  "{\"fieldId\": \"documentCategory\",\"values\":[\"","POI","\"]},","{\"fieldId\": \"documentExtension\",\"values\":[\"","JPG","\"]},","{\"fieldId\": \"docSource\",\"values\":[\"","PHYSICAL","\"]}","]}]}"		);
					                                                                            
					                                                                                
					
					
			response=given().headers("txnid","1234").headers("Content-Type","application/json").headers("accessToken",TokenDetailsBean.getAccessToken()).body(authBridgeJSON).when().post(URL);
			String resp= response.getBody().asString();
			System.out.println(resp);
			
			if(response.getStatusCode()==200)
			{
			flag=true;
			System.out.println("Recieved correct response for AuthBridge workflow method with statusCode="+response.jsonPath().get("responseHeader.statusCode")+ " and statusMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
			DOBTransactionIDDetailsBean.setDOBtransID(response.jsonPath().get("dobTransactionId").toString());
			DOBTransactionIDDetailsBean.setWorkFlowName(response.jsonPath().get("WorkflowName").toString());
			System.out.println(" DobTransactionId: "+DOBTransactionIDDetailsBean.getDOBTransID());
			Assert.assertEquals("Data saved for the workflow ", response.jsonPath().get("responseHeader.statusMessage"));
			}
			else
			{
				System.out.println("Recieved wrong response for AuthBridge workflow method with errorCode="+response.jsonPath().get("responseHeader.statusCode")+ " and errorMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}


}
