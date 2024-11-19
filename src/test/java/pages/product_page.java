package pages;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_elements.base_page;
public class product_page extends base_page {
	
	@FindBy(xpath="//button[@data-sku-id='6214343']")
	private List<WebElement> ADD_Mouse_through_Search;
	
	@FindBy(xpath="//button[contains(text(),'Continue shopping')]")
	private WebElement ContinueShopping;
	
	@FindBy(xpath="//span[contains(text(),'Cart')]")
	private WebElement CartButton;
	
	@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
	private List<WebElement> ADD_SonyTV_through_Department;
	
	@FindBy(xpath="//p[contains(text(),'ThinkPad laptops')]")
	private WebElement thinkpad_laptop;
	
	@FindBy(xpath="//button[@data-sku-id='6549730']")
	private WebElement ADD_lenovo_laptop;
	
	@FindBy(xpath="//h3[contains(text(),'Shop all Lenovo products')]")
	private WebElement Brand_title;
	
	public product_page() {
		PageFactory.initElements(driver, this);
	}
	
	public String add_searched_mouse() {
		
		String Mouse_At_Product_Page = extractText(ADD_Mouse_through_Search.get(0));
		jsScrollUntillElement(ADD_Mouse_through_Search.get(0));
		jsClickOn(ADD_Mouse_through_Search.get(0));
		clickOn(CartButton);
		return Mouse_At_Product_Page;
	}
	
	public String add_Department_TV() {
		String TV_At_Product_Page = extractText(ADD_SonyTV_through_Department.get(0));
		jsScrollUntillElement(ADD_SonyTV_through_Department.get(0));
		jsClickOn(ADD_SonyTV_through_Department.get(0));
		clickOn(CartButton);
		return TV_At_Product_Page;
	}
	
	public String add_Brand_TV() {
		
		jsScrollUntillElement(Brand_title);
		clickOn(thinkpad_laptop);
		String Lenovo_Brand_At_Product_Page= extractText(ADD_lenovo_laptop);
		jsScrollUntillElement(ADD_lenovo_laptop);
		jsClickOn(ADD_lenovo_laptop);
		clickOn(CartButton);
		return Lenovo_Brand_At_Product_Page;
	}
	

}
