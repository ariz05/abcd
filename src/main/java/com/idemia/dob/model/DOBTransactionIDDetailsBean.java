package com.idemia.dob.model;

public class DOBTransactionIDDetailsBean {
	
	private static String dobTransID;
	private static String workFlowName;
	
	
	public static String getDOBTransID() {
		return dobTransID;
	}

	
	public static String getWorkFlowName() {
		return workFlowName;
	}
	
	public static void setWorkFlowName(String workFlowName ) {
		DOBTransactionIDDetailsBean.workFlowName =workFlowName ;
	}

	public static void setDOBtransID(String dobTransID ) {
		DOBTransactionIDDetailsBean.dobTransID =dobTransID ;
	}

}
