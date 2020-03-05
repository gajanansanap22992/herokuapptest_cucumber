#Features are nothing but are the test cases
#Feature:In another word it is test scenario name
#Scenario Outline:It is a Test case name
#Below three are called Gherkin keywords
#Given-Given data
#When- checking condition
#Then - what should be the result
#Examples - are used to provide test data as a key and value pair
@FunctionalTest
Feature: TechVerito herokuapp Testing Scenarios



@TestFeature1
Scenario: Testing Error and Negative Scenarios
Given user is on the page



@TestFeture2
Scenario Outline: Testing Error and Negative Scenarios
Given user is on the website
When User enters invalid "<email>" and "<password>"
Then should be navigated to home page

Examples:
|email|password|
|aaa|aaa|

@ErrorNegativeScenarios
Scenario Outline: Testing Error and Negative Scenarios
Given user is on the website
When User enters invalid "<email>" and "<password>"
Then Error message "<error>" should get displayed
When user enter blank user Id and password
Then Error message "<error>" should get displayed
When User enters "<email>" and "<password>"
When Click on Products
When Click on New Product button
And Enter Title,Sku and Description value as Blank
Then Error message should be visible for all three fields
When User Enters duplicate Title or sku
Then Error message for duplicate "<error_duplicate>" should be displayed
Then click on Logout

Examples:




	| email              | password   | error					 |error_duplicate|
	| email  			 | password   |Invalid Email or password.|has already been taken|
	
	
	
	

@EndtoEndScenario
Scenario Outline: Testing Product creation,Updation,Listing and Deletion
Given user is on the website
When User enters "<email>" and "<password>"
Then should be navigated to home page
When Click on Products
When Click on New Product button
And Enter Unique values of Title,Sku and Description 
And click on Create Product
Then New Prodcut gets created and verify it "<created_message>"
And Update the product by updating values of Title,Sku and Description
Then check if value got updated "<updated_message>"
Then check Products are listed and get all values
And click on Delete 
Then check if product got deleted "<deleted_message>"
Then click on Logout

Examples:
	| email | password | created_message|updated_message|deleted_message|
	| email  | password|Product was successfully created.|Product was successfully updated.|Product was successfully destroyed.|
	