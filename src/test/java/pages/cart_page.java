package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_elements.base_page;
public class cart_page extends base_page {

	@FindBy(xpath="//a[contains(text(),'Sony - 65\" Class BRAVIA 3 LED 4K UHD Smart Google TV (2024)')]")
	private WebElement Sony_TV_in_cart;
	
	@FindBy(xpath="//a[contains(text(),'Logitech - G305 LIGHTSPEED Wireless Optical 6 Programmable Button Gaming Mouse with 12,000 DPI HERO Sensor - Black')]")
	private WebElement Mouse_in_cart;
	
	@FindBy(xpath="//a[contains(text(),'Lenovo - ThinkPad E14 Gen 5 14\" Touch-Screen Laptop - Intel Core i7 with 16GB Memory - 512GB SSD - Black')]")
	private WebElement Lenovo_laptop_in_cart;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	private WebElement checkout;
	
	public cart_page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_TV() {
		return extractText(Sony_TV_in_cart);
	}
	public String Validate_Mouse() {
		return extractText(Mouse_in_cart);
	}
	public String Validate_Laptop() {
		return extractText(Lenovo_laptop_in_cart);
	}
	
	public void GoToCheckoutPage() {
		clickOn(checkout);
	}
	
	
}
