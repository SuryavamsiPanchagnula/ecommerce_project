package testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_elements.base_page;
import pages.country_page;
public class tc02_URL_validation extends base_page {
	
	@BeforeTest
	public void setup() {
		testName = "tc02_URL_Validation";
		testDescription = "Given URL Link is broken or not";
		testCategory = "Regression";
		testAuthor = "Suryavamsi";
	}
	

	@Test(priority=2)
	public void tc02_validateUrlIsNotBroken() throws Exception {
		country_page cp = new country_page();
		if (cp.urlResponseCode()==200) {
			reportStep("Validating Best Buy page URL is broken or not - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy page URL is broken or not - Fail", "Fail", testName);
		}
		AssertJUnit.assertTrue(cp.urlResponseCode()==200);
	}

}
