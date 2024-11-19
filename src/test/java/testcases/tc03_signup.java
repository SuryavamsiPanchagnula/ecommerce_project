package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base_elements.base_page;
import pages.country_page;
import pages.homepage;
import pages.signup_page;
public class tc03_signup extends base_page {
	
	@BeforeTest
	public void setup() {
		testName = "tc03_signup";
		testDescription = "CreatAccount Functionality";
		testCategory = "Regression";
		testAuthor = "Suryavamsi";
	}
	
	@DataProvider(name = "signupData")
	public Object[][] accountDataProvider() {
	    return new Object[][]{
	        {"test", "user", "abcdef@gmail.com", "Vamsi@2000", "Vamsi@2000", "9347812054", "//strong[text()='Sorry, there was a problem creating your account.']", "Expected Message"}
	    };
	}
	@Test(dataProvider ="signupData")
	public void tc03_validateCreatAccountFunctionality(String fname, String lname, String emailId,
			String pass, String repass, String mob, String xpathText, String expMsg) throws Exception {
		country_page lp=new country_page();
		lp.usa_delivery();
		homepage hp=new homepage();
		hp.goToCreatAccount();
		signup_page ca=new signup_page();
		String actMsg = ca.createAccountFunctionality(fname,lname,emailId,pass,repass,mob,xpathText);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating CreatAccount Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating CreatAccount Functionality - Fail", "Fail", testName);
		}
	}

}
