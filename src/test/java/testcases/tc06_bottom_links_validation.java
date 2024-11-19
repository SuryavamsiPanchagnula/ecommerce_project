package testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_elements.base_page;
import pages.country_page;
import pages.homepage;
public class tc06_bottom_links_validation extends base_page {
	
	@BeforeTest
	public void setup() {
		testName = "tc06_validateLinkInBottomOfHomePage";
		testDescription = "Link in HomePage bottom is broken or not";
		testCategory = "Regression";
		testAuthor = "Suryavamsi";
	}
	
	@Test
	public void tc06_validateLinkInBottomOfHomePage() throws Exception {
		country_page lp=new country_page();
		lp.usa_delivery();
		homepage hp=new homepage();
		String actTitle = hp.validateTermsAndCondtionLink();
		String expTitle="BestBuy.com Terms and Conditions";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating the Title of link in bottom of Home Page - Pass", "Pass", testName);
		} else {
			reportStep("Validating the Title of link in bottom of Home Page - Fail", "Fail", testName);
		}
	}

}
