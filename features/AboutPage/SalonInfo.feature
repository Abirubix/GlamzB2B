
Feature: Validation of About screen SalonInfo in Glamz web application

@AboutSaloninfo
Scenario: validation of about SalonInfo screen details
Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User verify about screen is displayed
Then User verify all the labels and Edit button are displayed in about screen
And User verifies whether message box is dispalyed