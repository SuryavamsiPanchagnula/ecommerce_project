package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_elements.base_page;

public class signup_page extends base_page {
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="fld-p1")
	WebElement Password;
	
	@FindBy(id="reenterPassword")
	WebElement ConfirmPassword;
	
	@FindBy(id="phone")
	WebElement MobileNumber;
	
	@FindBy(id="is-recovery-phone")
	WebElement recoveryCheckBox;
	
	@FindBy(xpath="//button[text()='Create an Account']")
	WebElement createAnAccount;
	
	@FindBy(id="//*[text()='Sign Up with Google']")
	WebElement googleSignUp;
	
	public signup_page() {
		PageFactory.initElements(driver, this);
	}
	
	public String createAccountFunctionality(String fName, String lName, String email,
            String password, String confirmPassword,
            String mobileNumber, String textXpath) {
type(firstName, fName);
type(lastName, lName);
type(Email, email);
type(Password, password);
type(ConfirmPassword, confirmPassword);
type(MobileNumber, mobileNumber);

clickOn(createAnAccount);

// Get and return the actual message from the page
return driver.findElement(By.xpath(textXpath)).getText();
}
}