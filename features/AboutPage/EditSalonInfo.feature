Feature: Validation of edit functionality in About page

@EditAboutSalonInfo
Scenario Outline:: validation of Edit functionality of input fields in About Salon-Info page 
Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User verify about screen is displayed
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
And User deletes the Additional Mobile Number field
And User clicks on ADD ONE MORE PHONE button twice
Then ADD ONE MORE PHONE button should not be visible
And User enters "9876543211" in the first additional phone number and user is notified with error message
And User enters "05677777" in the second additional phone number and user is notified with error message
Then User clears the first additional phone number and enters "0567784433" and the error message is gone
Then User clears the second additional phone number and enters "0567777722" and the error message is gone
And User deletes the first additional phone number 
Then ADD ONE MORE PHONE button is visible now
Then User clicks on save button
And Updated succesfully message is obtained
And User clicks on edit button
Then User clicks on cancel button and checks wether the previously given data is present

