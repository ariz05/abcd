package testStepDefinitions;

import java.util.HashMap;

import com.cucumber.listener.Reporter;
import com.idemia.dob.model.InitUser;
import com.idemia.dob.utils.GeneralMethods;

import cucumber.api.java.en.*;

public class workflowStepDef {
	HashMap<String, String> apidata = new HashMap<String, String>();
	InitUser initobj= new InitUser();
	
	@Given("^Generate accessToken using initsdk api$")
    public void generate_accesstoken_using_initsdk_api() throws Throwable {
		initobj.initSdk();
    }

	
	
	@When("^create an applicant by entering his demographic values and name as (.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+)$")
    public void create_an_applicant_by_entering_his_demographic_values_and_name_as_(String applicantid, String name, String dob, String email, String fathername, String gender, String mobile, String status) throws Throwable
	{
		if (applicantid.equalsIgnoreCase("randomUserName1")) {
			//applicantid = GeneralMethods.rendomAlphabetString(10);
			System.out.println("New Applicant ID for registration: " + applicantid);
		}
		Reporter.addStepLog("Calling initUserAPI method ");
		initobj.initUserAPI(applicantid,name,dob,email,fathername,gender,mobile,status);
	}
	
	@Then("^verify the applicant is saved successfully$")
	public void validateUser(){
		if(initobj.flag){
			System.out.println("InitUser API passed");
		}else{
			System.err.println("InitUser Api Failed.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	@When("^we create an applicant by entering his demographic values and name as (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
	public void createUser(String applicantId,String name,String dob, String email, String father_name, String gender, String mobile, String status){
		if (applicantId.equalsIgnoreCase("randomUserName1")) {
			applicantId = GeneralMethods.rendomAlphabetString(10);
			System.out.println("New Applicant ID for registration: " + applicantId);
		}
		
		initobj.initUserAPI(applicantId,name,dob,email,father_name,gender,mobile,status);
		
	}
	
		
    }
    */
}
