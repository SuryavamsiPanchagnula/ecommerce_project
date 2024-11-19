package testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_elements.base_page;
import pages.cart_page;
import pages.country_page;
import pages.homepage;
import pages.product_page;


public class tc07_Search_Product extends base_page{
	@BeforeTest
	public void setup() {

		testName = "tc07_SearchAddItemInCart";
		testDescription = "Search a Item in search box and add it in cart";
		testCategory = "Regression";
		testAuthor = "Suryavamsi";
	}

	@Test
	public void tc07_SearchAddItemInCart() throws Exception {
		country_page lp = new country_page();
		lp.usa_delivery();
		homepage hp = new homepage();
		waitImplicit();
		hp.SearchProduct("Mouse");
		product_page pp = new product_page();
		String product_item = pp.add_searched_mouse();
		cart_page cp = new cart_page();
		String cart_item = cp.Validate_Mouse();
		softAssert(product_item, cart_item);
		if (product_item.equals(cart_item)) {
			reportStep("Validating Product Search", "Pass", testName);
		} else {
			reportStep("Validating Product Search", "Fail", testName);
		}
	}
}
