package com.idemia.dob.model;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;

import com.idemia.dob.utils.AllApiURL;
import com.idemia.dob.utils.ConfigManager;
import com.idemia.dob.utils.GeneralMethods;
import com.idemia.dob.validation.ValidateGetAsyncWorkflowStatus;
import com.jayway.restassured.response.Response;

public class GetAsyncWorkflowStatus {
	
	public Response response;
	public String resbody;
	public String URL;
	public Boolean flag=false;
	
	public void initWorkflow() {
		HashMap<String, String> headers=new HashMap<String, String>();
		try {
			URL = ConfigManager.getProperty("baseURL") + AllApiURL.GetAsyncWorkflowApiURL;			
			response=given().headers("txnid","1234").headers("dobTransactionId",DOBTransactionIDDetailsBean.getDOBTransID()).headers("accessToken",TokenDetailsBean.getAccessToken()).get();
					//body(InitworkJSON).when().post(URL);
			String resp= response.getBody().asString();
			System.out.println(resp);
			if(response.getStatusCode()==200){
				//if(response.jsonPath().get("responseHeader.statusCode").toString().equalsIgnoreCase("00")){
				System.out.println("Recieved correct response for getStatus workflow method with statusCode="+response.jsonPath().get("responseHeader.statusCode")+ " and statusMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
				//}
				String respnse= response.getBody().asString();
				ValidateGetAsyncWorkflowStatus.ValidateWorkflowResponse(respnse);
			}else{
				System.out.println("Recieved wrong response for getStatus workflow method with errorCode="+response.jsonPath().get("responseHeader.statusCode")+ " and errorMessage as \""+response.jsonPath().get("responseHeader.statusMessage")+"\"");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}


}
