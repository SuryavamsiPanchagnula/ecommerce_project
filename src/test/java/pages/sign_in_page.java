package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_elements.base_page;

public class sign_in_page extends base_page{
	
	@FindBy(id="fld-e")
	WebElement Email;
	
	@FindBy(id="fld-p1")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInButton;
	
	public sign_in_page(){
		PageFactory.initElements(driver, this);
	}
	
	public String signInFunctionality(String email, String password,String textXpath) throws Exception {
		type(Email, email);
		type(Password, password);
		clickOn(signInButton);
		String actMsg=driver.findElement(By.xpath(""+textXpath+"")).getText();
		return actMsg;
	}
}