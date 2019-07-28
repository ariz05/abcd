package com.idemia.dob.utilclasses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkflowResponse {

	private String applicantId;

	private String dobTransactionId;

	private String docType;

	private ResponseHeader responseHeader;

	private String workflowName;
	
	private List<WorkflowActionResponse> response;

	/**
	 * @return the applicantId
	 */
	public String getApplicantId() {
		return applicantId;
	}


	public String getDobTransactionId() {
		return dobTransactionId;
	}

	public String getDocType() {
		return docType;
	}


	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	/**
	 * @param applicantId the applicantId to set
	 */
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public void setDobTransactionId(String dobTransactionId) {
		this.dobTransactionId = dobTransactionId;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}


	public List<WorkflowActionResponse> getResponse() {
		return response;
	}


	public void setResponse(List<WorkflowActionResponse> response) {
		this.response = response;
	}




//	@Override public String toString() {
//		return "WorkflowResponse{" + "applicantId='" + applicantId + '\'' + ", covDetailsList="
//				+ covDetailsList + ", response=" + response + ", dobTransactionId='"
//				+ dobTransactionId + '\'' + ", docType='" + docType + '\'' + ", licenseDetailsList="
//				+ licenseDetailsList + ", responseHeader=" + responseHeader + ", workflowName='"
//				+ workflowName + '\'' + '}';
//	}
}
