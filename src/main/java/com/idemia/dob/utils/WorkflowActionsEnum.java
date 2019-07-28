/**
 * 
 */
package com.idemia.dob.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author G514488
 *
 */
public enum WorkflowActionsEnum {

	DIGILOCKER_FETCH(""), DIGILOCKER_FETCH_DETAIL(""), AADHAR("AADHAR"), COMPAREFACE(""), SELFIE_PORTRAIT_MATCH(""),
	PAN("PAN"), DL("DL"), PROOFING_DOCUMENT_CHECK("PASSPORT"), ENROLLMENT_DEMOGRAPHIC(""),
	PROOFING_PAN_NUMBER_CHECK("PAN"), ENROLLMENT_BIOMETRICS_FINGER_DATA(""), ENROLLMENT_BIOMETRICS_FACE_DATA(""),
	ENROLLMENT_DEMOGRAPHIC_FACE_DATA(""), AUTHENTICATE_BIOMETRICS_FACE_DATA(""), VERIFY_REST_CONNECTOR(""),
	ENROLLMENT_VOTER_ID_CHECK("VOTER_ID"), AUTH_BRIDGE(""), VALIDATION_STEP(""), IDWALL_REST_CONNECTOR(""),
	FACE_MATCHER(""), DIGI_LOCKER(""), DOC_PARSER("documentParser"), AUTH_BRIDGE_PAN("PAN"), AUTH_BRIDGE_DL("DL"),
	DIGI_LOCKER_VOTER("VOTER_ID_DIGI"), DIGI_LOCKER_DL("DL_DIGI"), DIGI_LOCKER_AADHAAR("AADHAR_DIGI"),
	DIGI_LOCKER_PAN("PAN_DIGI"), DIGI_LOCKER_Others("Others"), DIGI_LOCKER_UTILITY_BILLS("UTILITY_BILLS_DIGI"),
	DOC_PARSER_VOTER("VOTER_ID_DIGI"), DOC_PARSER_DL("DL_DIGI"), DOC_PARSER_AADHAAR("AADHAR_DIGI"),
	DOC_PARSER_PAN("PAN_DIGI"), DOC_PARSER_Others("Others"), DOC_PARSER_UTILITY_BILLS("UTILITY_BILLS"),
	DOC_PARSER_E_AADHAAR("E_Aadhaar"), VOTER_ID("VOTER_ID"), Aadhar_QR("Aadhar_QR"), E_Aadhaar("E_Aadhaar"),
	Physical_Aadhar("Physical_Aadhar"), M_Aadhar("M_Aadhar"), Offline_Aadhar("Offline_Aadhar"), DIGILOCKER_RE_FETCH(""),
	GOOGLE_VISION("GOOGLE_VISION"), AADHAAR("AADHAR"), AADHAAR_E_AADHAAR("E_Aadhaar"), AADHAAR_QR("Aadhar_QR"),
	AADHAAR_XML("Offline_Aadhar"), AADHAAR_PHYSICAL("Physical_Aadhar"), REGULA_OCR("REGULA_OCR"),
	AUTH_BRIDGE_VOTER("VOTER_ID");

	private String value;

	WorkflowActionsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static List<WorkflowActionsEnum> getIpvWorkflowActions() {
		List<WorkflowActionsEnum> workflowActionEnums = new ArrayList<WorkflowActionsEnum>();
		workflowActionEnums.add(PROOFING_DOCUMENT_CHECK);
		return workflowActionEnums;
	}

	public static List<WorkflowActionsEnum> getEauthWorkflowActions() {
		List<WorkflowActionsEnum> workflowActionEnums = new ArrayList<WorkflowActionsEnum>();
		workflowActionEnums.add(ENROLLMENT_DEMOGRAPHIC);
		workflowActionEnums.add(PROOFING_PAN_NUMBER_CHECK);
		workflowActionEnums.add(ENROLLMENT_BIOMETRICS_FINGER_DATA);
		workflowActionEnums.add(ENROLLMENT_BIOMETRICS_FACE_DATA);
		workflowActionEnums.add(ENROLLMENT_DEMOGRAPHIC_FACE_DATA);
		workflowActionEnums.add(AUTHENTICATE_BIOMETRICS_FACE_DATA);
		workflowActionEnums.add(ENROLLMENT_VOTER_ID_CHECK);
		return workflowActionEnums;
	}

	public static List<WorkflowActionsEnum> getWorkflowActionsWithDocument() {
		List<WorkflowActionsEnum> workflowActionEnums = new ArrayList<WorkflowActionsEnum>();
		workflowActionEnums.add(PROOFING_DOCUMENT_CHECK);
		workflowActionEnums.add(ENROLLMENT_DEMOGRAPHIC);
		workflowActionEnums.add(ENROLLMENT_BIOMETRICS_FINGER_DATA);
		workflowActionEnums.add(ENROLLMENT_BIOMETRICS_FACE_DATA);
		workflowActionEnums.add(ENROLLMENT_DEMOGRAPHIC_FACE_DATA);
		workflowActionEnums.add(AUTHENTICATE_BIOMETRICS_FACE_DATA);
		workflowActionEnums.add(FACE_MATCHER);
		return workflowActionEnums;
	}

	public static String getValueByWFAName(WorkflowActionsEnum workflowActionName) {
		for (WorkflowActionsEnum workflowAction : WorkflowActionsEnum.values()) {
			if (StringUtils.equalsIgnoreCase(workflowAction.name(), workflowActionName.name())) {
				return workflowActionName.getValue();
			}
		}
		return "";
	}

	public static WorkflowActionsEnum getByValue(String value) {
		for (WorkflowActionsEnum actionsEnum : WorkflowActionsEnum.values()) {
			if (actionsEnum.getValue().equalsIgnoreCase(value)) {
				return actionsEnum;
			}
		}
		return null;
	}

	public static WorkflowActionsEnum getByName(String value) {
		for (WorkflowActionsEnum actionsEnum : WorkflowActionsEnum.values()) {
			if (actionsEnum.name().equalsIgnoreCase(value)) {
				return actionsEnum;
			}
		}
		return null;
	}
}
