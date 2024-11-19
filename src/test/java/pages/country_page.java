package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_elements.base_page;
public class country_page extends base_page {
	
	public country_page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="us-link")
	private WebElement usa_country;
	
	@FindBy(className="canada-link")
	private WebElement canada_country;
	
	public void usa_delivery() {
		
		clickOn(usa_country);
	}
	
	public void deliveryAtCanada() {
		clickOn(canada_country);
	}
	
	public String bestBuyPageTitle() throws Exception {
		return getPageTitle();
	}
	
	public int urlResponseCode() throws Exception {
		return getResponseCode(readProperty("url"));
	}
	
}
