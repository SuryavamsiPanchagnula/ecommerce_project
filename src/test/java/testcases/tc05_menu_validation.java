package testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_elements.base_page;
import pages.country_page;
import pages.homepage;
public class tc05_menu_validation extends base_page {
	
	@BeforeTest
	public void setup() {
		testName = "tc05_CheckTitleOfAllMenu";
		testDescription = "Check the different menu titles";
		testCategory = "Regression";
		testAuthor = "Suryavamsi";
	}
	
	@Test
	    public void tc05_validateMenuLinkNavigation() throws Exception {
		
		country_page cp = new country_page();
		cp.usa_delivery();
		homepage hp = new homepage();
		hp.validateMenuLinkNavigationUsingH1();
	}
}
