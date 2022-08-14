package alami.elevenia.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {
	WebDriver xdriver;
	
	public SearchResult(WebDriver sdriver){
		
		xdriver = sdriver;
		PageFactory.initElements(sdriver, this);
	}
	
	@FindBy(linkText = "Produk terlaris")
	public WebElement sortTerlaris;
	
	@FindBy(id = "prod_28911164")
	public WebElement firstProduct;
	
	public void sort() {
		sortTerlaris.click();
	}
	
	public void product() {
		firstProduct.click();
	}
}
