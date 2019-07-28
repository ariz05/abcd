@Api @Testing 
Feature: Test the selenium script for Opening Google 

Scenario: Open Chrome Browser 
	When Call chrome browser 
	Then verify that browser is opened 
	
@DummyAPI @SNROUT 
Scenario: Test a free rest API 

	When we call the service part 
	Then verify the calling part 
@SNROUT @sanity
Scenario Outline: Test the free dummy API 
	When we call the service part with <name>, <salary>, <age> 
	Then verify the calling part 

	Examples: 
		|name |salary|age|
		|arun | 123  |22 |
		|varun| 321  |23 |