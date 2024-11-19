package testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_elements.base_page;
import pages.cart_page;
import pages.country_page;
import pages.homepage;
import pages.product_page;
public class tc09_Brand_Item_Add extends base_page {
	
	@BeforeTest
	public void setup() {

		testName = "tc09_selAddItemShopByDeptMenu";
		testDescription = "Search a Item by Department in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "Suryavamsi";
	}

	@Test
	public void tc09_selAddItemShopByDeptMenu() throws Exception {
		country_page lp = new country_page();
		lp.usa_delivery();
		homepage hp = new homepage();
		hp.SelectByBrand();
		product_page pp = new product_page();
		String product_item = pp.add_Brand_TV();
		cart_page cp = new cart_page();
		String cart_item = cp.Validate_Laptop();
		softAssert(cart_item, product_item);
		if (cart_item.equals(product_item)) {
			reportStep("Validating Brand Buy", "Pass", testName);
		} else {
			reportStep("Validating Brand Buy", "Fail", testName);
		}
	}

}
