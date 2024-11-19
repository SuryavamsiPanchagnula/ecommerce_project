package testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_elements.base_page;
import pages.country_page;
public class tc01_open_website extends base_page {
	
	@BeforeTest
	public void setup() {
		testName = "tc01_open_website";
		testDescription = "Navigating to the Best Buy e-commerce website";
		testCategory = "Regression";
		testAuthor = "Suryavamsi";
	}
	
	@Test
	public void tc01_navigate_to_website() throws Exception {
		country_page cp = new country_page();
		String expected_title=cp.bestBuyPageTitle();
		String actual_title = "Best Buy International: Select your Country - Best Buy";
		softAssert(expected_title,actual_title);
		if (expected_title.equals(actual_title)) {
			reportStep("Validating Best Buy Page Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy Page Title - Fail", "Fail", testName);
		}
		
		}
	

}
