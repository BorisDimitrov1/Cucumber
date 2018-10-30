package com.vereign.automationExample.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public AdminPage(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	
	public class BackEndLogin{
		
		private By emailField = By.name("email");
		private By passwordField = By.name("password");
		private By loginButton = By.xpath("//form[@method='POST']//button[@type='submit']");
		
		/**
		 * Populates the email field
		 * @param email
		 */
		public void populateEmailField(String email){
			WebElement emailTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
			
			emailTextBox.clear();
			emailTextBox.sendKeys(email);
		}
		
		/**
		 * Populates the password field
		 * @param password
		 */
		public void populatePasswordField(String password){
			WebElement passwordField = driver.findElement(this.passwordField);
			
			passwordField.clear();
			passwordField.sendKeys(password);
		}
		
		/**
		 * Click on Login Button
		 */
		public void clickLoginButton(){
			driver.findElement(loginButton).click();
		}
	}
	
	public class Dashboard{
		
		private By hotelsButton = By.linkText("Hotels"); 
		private By roomsButton = By.linkText("Rooms");
		private By logoutButton = By.linkText("Log Out");
		
		/**
		 * Click Hotels Button
		 */
		public void clickHotelsButton(){
			wait.until(ExpectedConditions.elementToBeClickable(hotelsButton)).click();
		}
		
		/**
		 * Click Rooms Button
		 */
		public void clickRoomsButton(){
			driver.findElement(roomsButton).click();
		}
		
		/**
		 * Click on Log Out Button
		 */
		public void clickLogoutButton(){
			driver.findElement(logoutButton).click();
		}
	}
	
	public class Rooms{
		
		private By firstRowRoomType = By.xpath("(//table//tr)[2]//td[3]//a");
		private By firstRowHotelName = By.xpath("(//table//tr)[2]//td[4]");
		private By firstRowEditButton = By.xpath("(//table//tr)[2]//a[@title='Edit']");
		private By messageAfterSubmit = By.xpath("//h4");
		
		/**
		 * @return Type of the Room presented on the first row of the Room Management Table
		 */
		public String getRoomType(){
			return driver.findElement(firstRowRoomType).getText();
		}
		
		/**
		 * @return Name of the Hotel presented on the first row of the Room Management Table
		 */
		public String getHotelName(){
			return driver.findElement(firstRowHotelName).getText();
		}
		
		/**
		 * Click on the Edit Button presented on the first row of the Room Management Table
		 */
		public void clickEditButton(){
			driver.findElement(firstRowEditButton).click();
		}
		
		/**
		 * Validate the message after clicking on submit button
		 * @param expectedText
		 */
		public void validateMessageText(String expectedText){
			String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(messageAfterSubmit)).getText();
			
			Assert.assertEquals(expectedText, actualText);
		}
	}
	
	public class UpdateRoom{
		
		private By priceField = By.name("basicprice");
		private By submitButton = By.id("update");
		
		/**
		 * Modify that Price Field in the Update Room View
		 * @param price
		 */
		public void modifyPrice(String price){
			WebElement priceField = driver.findElement(this.priceField);
			priceField.clear();
			priceField.sendKeys(price);
		}
		
		/**
		 * Click Submit Button
		 */
		public void clickSubmitButton(){
			driver.findElement(submitButton).click();
		}
	}
}
