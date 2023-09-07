
Feature: Validation of About screen PersonalInfo in Glamz web application

@aboutpersonalinfopage
Scenario: Check validations of titles and messages
Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User clicks on About->PersonalInfo
Given User extracts the mobile number from SalonInfo
And User extracts the mobile number from PersonalInfo and compares it with mobile number in SalonInfo
And User verifies all the titles in the page
Then User verifies Recieve sms notification button
And User verifies all the texts in personal info page