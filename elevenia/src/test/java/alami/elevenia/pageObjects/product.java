package alami.elevenia.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product {
	WebDriver xdriver;
	
	public product(WebDriver sdriver){
		
		xdriver = sdriver;
		PageFactory.initElements(sdriver, this);
	}
	
	@FindBy(id = "optionStock0")
	public WebElement quantity;
	
	@FindBy(css = "body > section > section > form:nth-child(2) > div.compWrap.card > div.gridC > div.btnArea > a.btnStyle.btnFlat.btnL.btnOrangeW")
	public WebElement addToCartButton;
	
	@FindBy(id = "mo_lay144")
	public WebElement popUp;
	
	@FindBy(css = "#mo_lay144 > div.btnC > a.btnStyle.btnS.btnRed")
	public WebElement popupYes;
	
	@FindBy(id = "layMineTab1")
	public WebElement cartButton;
	
	public void changeQuantity(String q) {
		quantity.clear();
		quantity.sendKeys(q);
	}
	
	public void addToCart() {
		addToCartButton.click();
	}
	
	public void goToCart() {
		if(popUp.isDisplayed()) {
			popupYes.click();
		} else {
			cartButton.click();
		}
	}
}
