package pages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base_elements.base_page;
public class homepage extends base_page {
	
	@FindBy(xpath="//a[contains(text(),'Top Deals')]")
	private WebElement Top_Deals;
	
	@FindBy(xpath = "//a[contains(text(),'Deal of the Day')]")
	private WebElement Deal_of_the_Day;
	
	@FindBy(xpath ="//a[contains(text(),'Yes, Best Buy Sells That')]")
	private WebElement Buy_Sells;
	
	@FindBy(xpath="//a[contains(text(),'Credit Cards')]")
	private WebElement Credit_Card;
	
	@FindBy(xpath ="//a[contains(text(),'Gift Cards')]")
	private WebElement Gift_Cards;
	
	@FindBy(xpath ="//a[contains(text(),'Gift Ideas')]")
	private WebElement Gift_Ideas;
	
	@FindBy(xpath ="//span[contains(text(),'Account')]")
	private WebElement Account;
	
	@FindBy(xpath ="//a[contains(text(),'Best Buy Outlet')]")
	private WebElement BestBuyOutlet;
	
	@FindBy(xpath ="//a[contains(text(),'Best Buy Business')]")
	private WebElement BestBuyBusiness;
	
	@FindBy(xpath ="//a[contains(text(),'Shop with an Expert')]")
	private WebElement ShopWithAnExpert;
	
	@FindBy(xpath ="//a[@data-testid='signInButton']")
	private WebElement SignIn;
	
	@FindBy(xpath ="//a[@data-testid='createAccountButton']")
	private WebElement SignUp;
	
	@FindBy(id ="gh-search-input")
	private WebElement search;
	
	@FindBy(xpath ="//button[contains(text(),'Menu')]")
	private WebElement Menu;
	
	@FindBy(xpath="//button[@data-id='node-274']")
	private WebElement TvMenu;
	
	@FindBy(xpath ="//button[@data-id='node-222']")
	private WebElement TvByDepartment;
	
	@FindBy(xpath ="//a[contains(text(),'Sony TVs')]")
	private WebElement TvDepartmentInnerMenu;
	
	@FindBy(className="header-search-button")
	private WebElement Search_Button;
	
	@FindBy(id="shop-cart-icon")
	private WebElement CartButton;
	
	@FindBy(xpath ="//button[contains(text(),'Brands')]")
	private WebElement ByBrand;
	
	@FindBy(xpath ="//a[contains(text(),'Lenovo')]")
	private WebElement BrandInnerMenu;
	
	@FindBy(xpath ="//a[@data-track='ft_legal_terms_conditions']")
	private WebElement terms_and_conditions;
	
	public homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public void goToCreatAccount() {
		clickOn(Account);
		clickOn(SignUp);
	}

	public void goToSignIn() {
		clickOn(Account);
		clickOn(SignIn);
	}
	
	public void openMenu() {
		clickOn(Menu);
	}
	
	public List<String> brokenLinkFinder() throws Exception {
		List<WebElement> elements = driver.findElements(By.xpath("//footer//a"));
		int brokenLinkCount = 0;
		List<String> brokenLinks = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			String links = elements.get(i).getAttribute("href");
			int responseCode = getResponseCode(links);
			if (responseCode >= 400) {
				brokenLinkCount++;
				brokenLinks.add(links);
			}
		}
		System.out.println(brokenLinkCount);
		return brokenLinks;
	}
	
	public void SearchProduct(String Product_name) {
		type(search,Product_name);
		clickOn(Search_Button);
	}
	
	public void SelectByDepartment() {
		clickOn(Menu);
		clickOn(TvMenu);
		clickOn(TvByDepartment);
		clickOn(TvDepartmentInnerMenu);
	}
	
	
	public void SelectByBrand() {
		clickOn(Menu);
		jsScrollUntillElement(ByBrand);
		clickOn(ByBrand);
		clickOn(BrandInnerMenu);
	}
	
	public void validateMenuLinkNavigationUsingH1() throws Exception {
	    
	    List<WebElement> menuLinks = Arrays.asList(
	        Top_Deals, Deal_of_the_Day, Buy_Sells, Credit_Card, 
	        Gift_Cards, Gift_Ideas, BestBuyOutlet, BestBuyBusiness, ShopWithAnExpert
	    );

	   
	    Map<String, String> expectedH1Texts = new HashMap<>();
	    expectedH1Texts.put("Top Deals", "Top Deals");
	    expectedH1Texts.put("Deal of the Day", "Deal of the Day");
	    expectedH1Texts.put("Yes, Best Buy Sells That", "Yes, Best Buy sells that™");
	    expectedH1Texts.put("Credit Cards", "My Best Buy® Credit Cards");
	    expectedH1Texts.put("Gift Cards", "Best Buy Gift Cards");
	    expectedH1Texts.put("Gift Ideas", "Gift Ideas");
	    expectedH1Texts.put("Best Buy Outlet", "BEST BUY Outlet");
	    expectedH1Texts.put("Best Buy Business", "Best Buy Business");
	    expectedH1Texts.put("Shop with an Expert", "Shop with an expert online for free");

	    for (WebElement link : menuLinks) {
	        if (link.isDisplayed() && link.isEnabled()) {
	            String linkText = link.getText();
	            System.out.println("Clicking on: " + linkText);

	            
	            link.click();

	            
	            try {
	                Thread.sleep(3000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	          
	            WebElement h1Element = driver.findElement(By.tagName("h1"));
	            String actualH1Text = h1Element.getText();
	            String expectedH1Text = expectedH1Texts.get(linkText);

	            
	            Assert.assertEquals(actualH1Text, expectedH1Text, "H1 Text mismatch for " + linkText);

                // Report the result
                if (actualH1Text.equals(expectedH1Text)) {
                    reportStep("Validating " + linkText + " - Pass", "Pass", linkText);
                } else {
                    reportStep("Validating " + linkText + " - Fail", "Fail", linkText);
                }

	            
	            driver.navigate().back();

	            
	            try {
	                Thread.sleep(3000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println(link.getText() + " link is NOT displayed or enabled.");
	        }
	    }
	}

	public String validateTermsAndCondtionLink() {
		jsScrollUntillElement(terms_and_conditions);
		clickOn(terms_and_conditions);
		String actTitle = getPageTitle();
		return actTitle;
	}

}
