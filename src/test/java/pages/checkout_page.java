package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_elements.base_page;
public class checkout_page extends base_page {
	
	@FindBy(id="fld-e")
	private WebElement Email;
	
	@FindBy(id="fld-p1")
	private WebElement password;
	
	@FindBy(xpath="//button[@data-track='Sign In']")
	private WebElement sign_in;
	
	@FindBy(xpath="//button[text()='Continue as Guest']")
	WebElement continueAsGuest;
	
	@FindBy(id="user.emailAddress")
	private WebElement Email_At_Checkout;
	
	@FindBy(id="user.phone")
	private WebElement PhoneNumber_At_Checkout;
	
	@FindBy(id="text-updates")
	private WebElement Update_Checkbox;
	
	@FindBy(xpath="//span[contains(text(),'Continue to Payment Information')]")
	private WebElement Continue_Payment;
	
	@FindBy(id="cc-number")
	private WebElement Card_Number;
	
	@FindBy(id="expMonth")
	WebElement expMonth;
	
	@FindBy(id="expYear")
	WebElement expYear;
	
	@FindBy(id="cvv")
	WebElement Cvv;
	
	@FindBy(id="save-to-profile")
	WebElement saveToProfile;
	
	@FindBy(id="first-name")
	WebElement FirstName;
	
	@FindBy(id="last-name")
	WebElement LastName;
	
	@FindBy(xpath="//button[text()='Hide Suggestions']")
	WebElement hideSuggestion;
	
	@FindBy(id="address-input")
	WebElement Address;
	
	@FindBy(id="//button[text()='Edit this address']")
	WebElement editThisAddress;
	
	@FindBy(id="//button[text()='Add a new address']")
	WebElement addNewAddress;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="postalCode")
	WebElement PostalCode;
	
	@FindBy(xpath="//span[text()='Place Your Order']")
	WebElement placeYourOrder;
	
	@FindBy(xpath="//p[text()='Please enter a valid card number.']")
	WebElement inValidCardMsg;
	
	@FindBy(xpath="//p[text()='Please enter a valid card number.']")
	WebElement sryMsgAfterSignInB4CheckOut;
	
	@FindBy(xpath="//span[text()='Sorry, there was a problem. Please try that again.']")
	WebElement sryMsgWitOutSignInB4CheckOut;

	public checkout_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void contactInfoAtCheckOut(String emailAtCheckOut,String mobileNumAtCheckOut) throws Exception {
		clickOn(continueAsGuest);
		type(Email_At_Checkout, emailAtCheckOut);
		type(PhoneNumber_At_Checkout, mobileNumAtCheckOut);
		clickOn(Update_Checkbox);
		clickOn(Continue_Payment);
	}
	
	public void enterDetailsOnCheckOut(String debitCardNumber,String expMonthVisibleText,String expYearVisibleText,String cvv,String firstName,String lastName, 
			String address, String city, String stateVisibleText, String postalCode) throws Exception {
		type(Card_Number, debitCardNumber);
		selectFromDropDown(expMonth, expMonthVisibleText);
		selectFromDropDown(expYear, expYearVisibleText);
		type(Cvv, cvv);
		type(FirstName, firstName);
		type(LastName, lastName);
		type(Address, address);
		type(City, city);
		selectFromDropDown(state, stateVisibleText);
		type(PostalCode, postalCode);
		clickOn(placeYourOrder);
	}

}
