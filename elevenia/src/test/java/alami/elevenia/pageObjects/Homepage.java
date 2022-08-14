package alami.elevenia.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver xdriver;
	
	public Homepage(WebDriver sdriver){
		
		xdriver = sdriver;
		PageFactory.initElements(sdriver, this);
	}
	
	@FindBy(id="AKCKwd")
	public WebElement searchBar;
	
	@FindBy(css = "#AKCFrm > div > button")
	public WebElement searchBtn;
	
	public void searchItem(String item) {
		searchBar.sendKeys(item + Keys.ENTER);
	}
	
	public void searchSubmit() {
		searchBtn.click();
	}
}
