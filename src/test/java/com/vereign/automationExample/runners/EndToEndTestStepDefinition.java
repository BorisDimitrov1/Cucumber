package com.vereign.automationExample.runners;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vereign.automationExample.pages.AdminPage;
import com.vereign.automationExample.pages.FrontPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EndToEndTestStepDefinition {

	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	private AdminPage adminPage = null;
	private AdminPage.BackEndLogin backEndlogin = null;
	private AdminPage.Dashboard dashboard = null;
	private AdminPage.Rooms rooms = null;
	private AdminPage.UpdateRoom updateRoom = null;
	
	private FrontPage frontPage = null;
	private FrontPage.Header frontPageHeader = null;
	private FrontPage.Login frontPageLogin = null;
	private FrontPage.Hotels frontPageHotels = null;
	private FrontPage.HotelDetails frontPageHotelDetails = null;
	private FrontPage.Booking frontPageBooking = null;
	
	private String savedRoomType;
	private String savedHotelName;
	
	
	{
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		
		adminPage = new AdminPage(driver, wait);
		backEndlogin = adminPage.new BackEndLogin();
		dashboard = adminPage.new Dashboard();
		rooms = adminPage.new Rooms();
		updateRoom = adminPage.new UpdateRoom();
		
		frontPage = new FrontPage(driver, wait);
		frontPageHeader = frontPage.new Header();
		frontPageLogin = frontPage.new Login();
		frontPageHotels = frontPage.new Hotels();
		frontPageHotelDetails = frontPage.new HotelDetails();
		frontPageBooking = frontPage.new Booking();
		
	}

	@Given("^Firefox Browser is running and maximized$")
	public void openFireFox() {
		System.setProperty("webdriver.gecko.driver","\\geckodriver.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("^User Navigate to \"(.*)\"$")
	public void navigateToBackEndLoginPage(String administratorLoginURL) {
		driver.navigate().to(administratorLoginURL);
	}

	@When("^User populate Back-End email field as \"(.*)\"$")
	public void populateBackEndEmail(String email) {
		backEndlogin.populateEmailField(email);
	}

	@And("User populate Back-End password field as \"(.*)\"$")
	public void populateBackEndPassword(String password) {
		backEndlogin.populatePasswordField(password);
	}

	@And("^User click on Back-End login button$")
	public void clickBackEndPageLoginButton() {
		backEndlogin.clickLoginButton();
	}

	@When("^User click on Hotels button$")
	public void clickHotelsLink() {
		dashboard.clickHotelsButton();
	}

	@And("^User click on Rooms button$")
	public void clickRoomsButton() {
		dashboard.clickRoomsButton();
	}
	
	@And("^User click on Edit Button on the first row of the table")
	public void clickEditButton(){
		savedRoomType = rooms.getRoomType();
		savedHotelName = rooms.getHotelName();
		
		rooms.clickEditButton();
	}
	
	@And("User edit the price of the room as \"(.*)\"$")
	public void editPrice(String price){
		updateRoom.modifyPrice(price);
	}
	
	@And("^User click on Submit Button")
	public void clickSubmitButton(){
		updateRoom.clickSubmitButton();
	}
	
	@Then("^correct message is displayed \"(.*)\"$")
	public void validateMessage(String expectedMessage){
		rooms.validateMessageText(expectedMessage);
	}
	
	@When("^User click logout button$")
	public void clickLogoutButton(){
		dashboard.clickLogoutButton();
	}
	
	@When("^User navigate to front-page \"(.*)\"$")
	public void navigateToFrontPage(String URL){
		driver.navigate().to(URL);
	}
	
	@And("^User click on My Account Button$")
	public void clickOnMyAccount(){
		frontPageHeader.clickMyAccount();
	}
	
	@And("^User click on Login Button from the presented drop down$")
	public void clickFrontPageLoginButton(){
		frontPageHeader.clickLoginButton();
	}
	
	@When("^User populate Front Page email field as \"(.*)\"$")
	public void populateFrontPageEmail(String email){
		frontPageLogin.populateEmailField(email);
	}
	
	@And("^User populate Front Page password field as \"(.*)\"$")
	public void populateFrontPagePassword(String password){
		frontPageLogin.populatePasswordField(password);
	}
	
	@And("^User click on Login Button$")
	public void clickFrontPageLogin(){
		frontPageLogin.clickLoginButton();
	}
	
	@When("^User click on Hotels$")
	public void clickHotelsButton(){
		frontPageHeader.clickHotelsButton();
	}
	
	@And("^User click on the edited hotel$")
	public void clickEditedHotel(){
		frontPageHotels.clickHotel(savedHotelName);
	}
	
	@Then("^The price of the edited room type should have the expected value \"(.*)\"$")
	public void validateRoomTypePrice(String expectedPrice){
		String actualPrice = frontPageHotelDetails.getEditedRoomPrice(savedRoomType);
		
		Assert.assertEquals(expectedPrice,actualPrice);
	}
	
	@When("^User click on the edited room type check box$")
	public void checkTheEditRoomTypeCheckbox(){
		frontPageHotelDetails.checkRoomTypeCheckbox(savedRoomType);
	}
	
	@And("^User click on Book Now Button$")
	public void clickBookNowButton(){
		frontPageHotelDetails.clickBookNowButton();
	}
	
	@And("^User click on Confirm This Booking Button$")
	public void clickConfirmThisBookingButton(){
		frontPageBooking.clickConfirmThisBookingButton();
	}
	
	@And("^User click on Pay on Arrival Button and Confirms$")
	public void clickPayOnArrivalAndConfirm(){
		frontPageBooking.clickPayOnArrivalAndConfirm();
	}
	
	@Then("^Message is displayed \"(.*)\"$")
	public void validateBookingStatusMessage(String expectedMessage){
		String actualMessage = frontPageBooking.getMessage();
		
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@After public void tearDown(){
		driver.quit();
	}

}