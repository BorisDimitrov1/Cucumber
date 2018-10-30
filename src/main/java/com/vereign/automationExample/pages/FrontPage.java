package com.vereign.automationExample.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FrontPage(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	
	public class Header{
		
		private By myAccount = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[text()=' My Account ']");
		private By loginButton = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@href='https://www.phptravels.net/login']");
		private By hotelsButton = By.linkText("Hotels");
		
		/**
		 * Click on My Account
		 */
		public void clickMyAccount(){
			driver.findElement(myAccount).click();
		}
		
		/**
		 * Click on Login Button
		 */
		public void clickLoginButton(){
			driver.findElement(loginButton).click();
		}
		
		/**
		 * Click on Hotels Button presented in the Header of the Front Page
		 */
		public void clickHotelsButton(){
			driver.findElement(hotelsButton).click();
		}
	}
	
	public class Login{
		
		private By emailField = By.name("username");
		private By passwordField = By.name("password");
		private By loginButton = By.xpath("//button[@type='submit' and text()='Login']");
		
		/**
		 * Populate Email Field in Front Page
		 * @param email
		 */
		public void populateEmailField(String email){
			WebElement emailTextBox = wait.until(ExpectedConditions.elementToBeClickable(emailField));
			
			emailTextBox.sendKeys(email);
		}
		
		/**
		 * Populate password field in Front Page
		 * @param password
		 */
		public void populatePasswordField(String password){
			driver.findElement(passwordField).sendKeys(password);
		}
		
		/**
		 * Click on Login Button in Front Page
		 */
		public void clickLoginButton(){
			driver.findElement(loginButton).click();
		}
	}
	
	public class Hotels{
		
		private By nextPageButton = By.xpath("//div[@class='pull-right']//a[text()='>']");
		
		/**
		 * Click on Hotel with given name<br>
		 * If it is not presented on the current page click on the next page button until there is no next page button
		 * @param hotelName
		 */
		public void clickHotel(String hotelName){
			
			do{
				try{
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					WebElement hotelLink = driver.findElement(By.linkText(hotelName));
					
					hotelLink.click();
					break;
				}catch(NoSuchElementException ex){
					
					//It could be added one more try catch in order to throw the correct exception when the element with text @hotelName is not presented on any of the pages
					//instead of throwing NoSuchElementException for the nextPageButton
					WebElement nextPageButton = driver.findElement(this.nextPageButton);
					
					if(!nextPageButton.isDisplayed()){
						throw ex;
					}else{
						nextPageButton.click();
					}
				}finally{
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
			}while(true);
		}
	}
	
	public class HotelDetails{
		
		private String roomTypePriceTemplate = "//*[text()='%s']//..//..//..//..//..//h2//strong";
		private String roomTypeCheckboxTemplate = "//*[text()='%s']//..//..//..//..//..//div[@class='control__indicator']";
		private By bookNowButton = By.xpath("//button[@type='submit' and contains(text(),'Book Now')]");
		
		/**
		 * Check the check box representing the room type
		 * @param roomType
		 */
		public void checkRoomTypeCheckbox(String roomType){
			By roomTypeCheckbox = By.xpath(String.format(roomTypeCheckboxTemplate, roomType));
			
			driver.findElement(roomTypeCheckbox).click();
		}
		
		/**
		 * Click on Book Now Button
		 */
		public void clickBookNowButton(){
			driver.findElement(bookNowButton).click();
		}
		
		/**
		 * @param roomType
		 * @return the price of the room with given room type
		 */
		public String getEditedRoomPrice(String roomType){
			
			By editedRoomPriceLocator = By.xpath(String.format(roomTypePriceTemplate, roomType));
			WebElement editedRoomPrice = driver.findElement(editedRoomPriceLocator);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", editedRoomPrice);
			
			wait.until(ExpectedConditions.elementToBeClickable(editedRoomPriceLocator));
			
			String editedRoomPriceAsString = editedRoomPrice.getText();
			String actualPrice = editedRoomPriceAsString.substring(1, editedRoomPriceAsString.length());
			
			return actualPrice;
		}
	}
	
	public class Booking{
		
		private By confirmThisBookingButton = By.name("logged");
		private By payOnArrivalButton = By.xpath("//button[text()='Pay on Arrival']");
		private By message = By.xpath("//td[@bgcolor='#FF9900']//div[@style='font-size:16px;color:white;']");
		
		/**
		 * Click on Confirm This Booking Button
		 */
		public void clickConfirmThisBookingButton(){
			driver.findElement(confirmThisBookingButton).click();
		}
		
		/**
		 * Click on Pay on Arrival Button and Click OK when the pop up is presented
		 */
		public void clickPayOnArrivalAndConfirm(){
			WebElement payOnArrivalButton = wait.until(ExpectedConditions.visibilityOfElementLocated(this.payOnArrivalButton));
			
			payOnArrivalButton.click();
			payOnArrivalButton.click();
			
			driver.switchTo().alert().accept();
			
		}
		
		/**
		 * @return the message that is presented after clicking on Pay on Arrival and Confirming
		 */
		public String getMessage(){
			WebElement message = driver.findElement(this.message);
			
			wait.until(ExpectedConditions.visibilityOf(message));
			String messageAsString = message.getAttribute("innerText");
			
			return messageAsString;
		}
	}
}
