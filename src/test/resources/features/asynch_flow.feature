@API @FullFlow 
Feature: Test the Asynch flow of the DOB 

	
@initUser
Scenario Outline: Create a user 
	Given Generate accessToken using initsdk api
	When create an applicant by entering his demographic values and name as <applicantId>,<name>,<dob>,<email>,<fathername>,<gender>,<mobile>,<status> 
	Then verify the applicant is saved successfully 
	
Examples: 
|applicantId    |name        |dob       |email                  |fathername   |gender|mobile    |status  |
|randomUserName1|Anshul Gupta|null      |anshul.gupta@idemia.com|Praveen Gupta|M     |9971568488|ACCEPTED|
	
