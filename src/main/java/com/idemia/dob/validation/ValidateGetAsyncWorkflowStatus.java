package com.idemia.dob.validation;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.junit.Assert;
import com.fasterxml.jackson.databind.JsonNode;
import com.idemia.dob.model.DOBTransactionIDDetailsBean;
import com.idemia.dob.model.applicantIDDetailsBean;
import com.idemia.dob.utilclasses.ResponseHeader;
import com.idemia.dob.utilclasses.WorkflowResponse;
import com.idemia.dob.utilclasses.WorkflowActionResponse;
import com.idemia.dob.utilclasses.WorkflowActionResponseBody;

import com.idemia.dob.utils.JSONHandler;
import com.jayway.restassured.response.Response;

public class ValidateGetAsyncWorkflowStatus {

	public static void ValidateWorkflowResponse(String jsonString)
	{
		WorkflowResponse listOfDetails = JSONHandler.convertJSONStringtoPOJO(jsonString, WorkflowResponse.class);
		
		if(listOfDetails.getApplicantId().equalsIgnoreCase(applicantIDDetailsBean.getapplicantID()))
		{
			System.out.println("Response is for correct applicant " +applicantIDDetailsBean.getapplicantID());
		}
		
		if(listOfDetails.getDobTransactionId().equalsIgnoreCase(DOBTransactionIDDetailsBean.getDOBTransID()))
		{
			System.out.println("Response is for correct dob_transactionID " +DOBTransactionIDDetailsBean.getDOBTransID());
		}
		
		if(listOfDetails.getWorkflowName().equalsIgnoreCase(DOBTransactionIDDetailsBean.getWorkFlowName()))
		{
			System.out.println("Response is for correct dob_transactionID " +DOBTransactionIDDetailsBean.getWorkFlowName());
		}
		
		ResponseHeader rhObj = listOfDetails.getResponseHeader();
		System.out.println(rhObj.toString());
		Assert.assertEquals("Status Code", "200", rhObj.getStatusCode());
		Assert.assertEquals("Status Code", "null", rhObj.getRequestId());
		Assert.assertEquals("Status Code", "null", rhObj.getResponseId());
		Assert.assertEquals("Status Code", "Response Received from IdOrch", rhObj.getStatusMessage());
		
		
		
		List<WorkflowActionResponse> workFlowActionResponseList = listOfDetails.getResponse();
		if (workFlowActionResponseList != null && workFlowActionResponseList.size() > 0) {
			for (WorkflowActionResponse workFlowActionResponse : workFlowActionResponseList) {
				if(StringUtils.equalsIgnoreCase(workFlowActionResponse.getResponseStatus(),"SUCCESS")){
				List<WorkflowActionResponseBody> workflowActionResponseBody = workFlowActionResponse
						.getWorkflowResponse();
				
				}
			}
		}
			else {
				;
			}
			
		
		//jn.elements();
		
		
		
		
	}

}
