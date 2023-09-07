Feature: Validation of about Personal Info Page name functionality

@PersonalInfoName
Scenario: Validation of About Personal Info Name functionality
Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User clicks on About->PersonalInfo
And User verifies if name label and edit button is present
And User verifies that name field is noneditable
And User clicks on Edit button in name field
Then The name field should be editable and the user renames to "Shweta"
Then User clicks on save button for name field
And User verifies that name field is noneditable
And User clicks on Edit button in name field
Then The name field should be editable and the user renames to "Keerthi"
Then User clicks on save button for name field
Then User clicks on edit button for name field and clicks on cancel button
And The User checks if previously entered name "Keerthi" is there

