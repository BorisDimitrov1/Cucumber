Feature: Phptravelers Application

Scenario: Edit Room Price as Admin, Validate the Room as User and book the room
Given Firefox Browser is running and maximized
When User Navigate to "https://www.phptravels.net/admin"
When User populate Back-End email field as "admin@phptravels.com"
And User populate Back-End password field as "demoadmin"
And User click on Back-End login button
When User click on Hotels button
And User click on Rooms button
And User click on Edit Button on the first row of the table
When User edit the price of the room as "500"
And User click on Submit Button
Then correct message is displayed "CHANGES SAVED!"
When User click logout button
When User navigate to front-page "https://www.phptravels.net/"
And User click on My Account Button
And User click on Login Button from the presented drop down
When User populate Front Page email field as "user@phptravels.com"
And User populate Front Page password field as "demouser"
And User click on Login Button
When User click on Hotels
And User click on the edited hotel
Then The price of the edited room type should have the expected value "500"
When User click on the edited room type check box
And User click on Book Now Button
And User click on Confirm This Booking Button
And User click on Pay on Arrival Button and Confirms
Then Message is displayed "YOUR BOOKING STATUS IS RESERVED"








	
	
	
	
	
	
	


