$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/EndToEndTest.feature");
formatter.feature({
  "line": 1,
  "name": "Phptravelers Application",
  "description": "",
  "id": "phptravelers-application",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Edit Room Price as Admin, Validate the Room as User and book the room",
  "description": "",
  "id": "phptravelers-application;edit-room-price-as-admin,-validate-the-room-as-user-and-book-the-room",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Firefox Browser is running and maximized",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User Navigate to \"https://www.phptravels.net/admin\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User populate Back-End email field as \"admin@phptravels.com\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User populate Back-End password field as \"demoadmin\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User click on Back-End login button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User click on Hotels button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User click on Rooms button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User click on Edit Button on the first row of the table",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User edit the price of the room as \"500\"",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "User click on Submit Button",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "correct message is displayed \"CHANGES SAVED!\"",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "User click logout button",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "User navigate to front-page \"https://www.phptravels.net/\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "User click on My Account Button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "User click on Login Button from the presented drop down",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User populate Front Page email field as \"user@phptravels.com\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "User populate Front Page password field as \"demouser\"",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "User click on Login Button",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "User click on Hotels",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "User click on the edited hotel",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "The price of the edited room type should have the expected value \"500\"",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "User click on the edited room type check box",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "User click on Book Now Button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User click on Confirm This Booking Button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User click on Pay on Arrival Button and Confirms",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Message is displayed \"YOUR BOOKING STATUS IS RESERVED\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EndToEndTestStepDefinition.openFireFox()"
});
formatter.result({
  "duration": 10704018731,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.phptravels.net/admin",
      "offset": 18
    }
  ],
  "location": "EndToEndTestStepDefinition.navigateToBackEndLoginPage(String)"
});
formatter.result({
  "duration": 2369054290,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin@phptravels.com",
      "offset": 39
    }
  ],
  "location": "EndToEndTestStepDefinition.populateBackEndEmail(String)"
});
formatter.result({
  "duration": 1304077686,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "demoadmin",
      "offset": 42
    }
  ],
  "location": "EndToEndTestStepDefinition.populateBackEndPassword(String)"
});
formatter.result({
  "duration": 66434461,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickBackEndPageLoginButton()"
});
formatter.result({
  "duration": 12150873092,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickHotelsLink()"
});
formatter.result({
  "duration": 1163120148,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickRoomsButton()"
});
formatter.result({
  "duration": 3949200437,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickEditButton()"
});
formatter.result({
  "duration": 14854420514,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 36
    }
  ],
  "location": "EndToEndTestStepDefinition.editPrice(String)"
});
formatter.result({
  "duration": 91442990,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickSubmitButton()"
});
formatter.result({
  "duration": 407006576,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CHANGES SAVED!",
      "offset": 30
    }
  ],
  "location": "EndToEndTestStepDefinition.validateMessage(String)"
});
formatter.result({
  "duration": 5471253226,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickLogoutButton()"
});
formatter.result({
  "duration": 2519929025,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.phptravels.net/",
      "offset": 29
    }
  ],
  "location": "EndToEndTestStepDefinition.navigateToFrontPage(String)"
});
formatter.result({
  "duration": 7566157957,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickOnMyAccount()"
});
formatter.result({
  "duration": 557786063,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickFrontPageLoginButton()"
});
formatter.result({
  "duration": 1670973725,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "user@phptravels.com",
      "offset": 41
    }
  ],
  "location": "EndToEndTestStepDefinition.populateFrontPageEmail(String)"
});
formatter.result({
  "duration": 1328538543,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "demouser",
      "offset": 44
    }
  ],
  "location": "EndToEndTestStepDefinition.populateFrontPagePassword(String)"
});
formatter.result({
  "duration": 411688465,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickFrontPageLogin()"
});
formatter.result({
  "duration": 7507718507,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickHotelsButton()"
});
formatter.result({
  "duration": 3187994428,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickEditedHotel()"
});
formatter.result({
  "duration": 8214239938,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 66
    }
  ],
  "location": "EndToEndTestStepDefinition.validateRoomTypePrice(String)"
});
formatter.result({
  "duration": 2355779222,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.checkTheEditRoomTypeCheckbox()"
});
formatter.result({
  "duration": 855086012,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickBookNowButton()"
});
formatter.result({
  "duration": 2097814694,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickConfirmThisBookingButton()"
});
formatter.result({
  "duration": 434232885,
  "status": "passed"
});
formatter.match({
  "location": "EndToEndTestStepDefinition.clickPayOnArrivalAndConfirm()"
});
formatter.result({
  "duration": 5816239143,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "YOUR BOOKING STATUS IS RESERVED",
      "offset": 22
    }
  ],
  "location": "EndToEndTestStepDefinition.validateBookingStatusMessage(String)"
});
formatter.result({
  "duration": 1686239952,
  "status": "passed"
});
formatter.after({
  "duration": 2358098408,
  "status": "passed"
});
});