package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base_elements.base_page;
import pages.country_page;
import pages.homepage;
import pages.sign_in_page;
public class tc04_signin extends base_page {
	
	@BeforeTest
	public void setup() {
		testName = "tc04_SignInFunctionality";
		testDescription = "Sign-In Functionality";
		testCategory = "Regression";
		testAuthor = "Suryavamsi";
	}
	@DataProvider(name = "signinData")
	public Object[][] accountDataProvider() {
	    return new Object[][]{
	        {"psuryavamsi88@gmail.com","Vamsi@2000","//div[contains(text(),'Oops! The email or password did not match our records. Please try again.')]"}
	    };
	}
	
	@Test(dataProvider="signinData")
	public void tc04_SignInFunctionality(String email,String password,String xpath) throws Exception {
		country_page lp=new country_page();
		lp.usa_delivery();
		homepage hp=new homepage();
		hp.goToSignIn();
		sign_in_page sp=new sign_in_page();
		String actMsg = sp.signInFunctionality(email,password,xpath);
		String expMsg = "Sorry, something went wrong. Please try again.";
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating Sign-In Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating Sign-In Functionality - Fail", "Fail", testName);
		}
	}

}
