
Feature: Validation of About screen PersonalInfo in Glamz web application

Background:
Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User clicks on About->PersonalInfo

@PersonalInfo
Scenario: Check wether mobile number in PersonalInfo is same as the mobile number in SalonInfo
Given User extracts the mobile number from SalonInfo
And User extracts the mobile number from PersonalInfo and compares it with mobile number in SalonInfo