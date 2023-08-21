Feature: Validation of edit functionality in About page


Background:
Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User verify about screen is displayed

Scenario Outline:: validation of Edit functionality of input fields in About Salon-Info page 
When User clicks edit button and verify all fields are enabled
And User delete old data and enter new valid data in all editable fields in about screen 
|luxury Salon|
|3rd floor|
|sunrise aprtment|
|28a|
|sunrise aprtments, 1st street, state -567880|
|the best salon|
|07655432|
And User deletes the old data in dropdowns and selects the first value in dropdown
Then User clicks on save button
And User clicks on edit button
Then User clicks on cancel button and checks wether the previously given data is present