package alami.elevenia.testCase;

import alami.elevenia.pageObjects.BaseClass;
import alami.elevenia.pageObjects.Cart;
import alami.elevenia.pageObjects.Homepage;
import alami.elevenia.pageObjects.SearchResult;
import alami.elevenia.pageObjects.product;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Case extends BaseClass {
	
	@Test
	public void theCase() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		
		// calling the object class
		Homepage hp = new Homepage(driver);
		SearchResult sr = new SearchResult(driver);
		product pd = new product(driver);
		Cart ct = new Cart(driver);
		
		// enter elevenia homepage
		driver.get(baseUrl);
		
		// search for "komputer" and press ENTER
		wait.until(ExpectedConditions.elementToBeClickable(hp.searchBar));
		hp.searchItem("komputer");
		
		// sort and click on the product
		wait.until(ExpectedConditions.elementToBeClickable(sr.sortTerlaris));
		sr.sort();
		wait.until(ExpectedConditions.elementToBeClickable(sr.firstProduct));
		sr.product();
		
		// increase quantity by 3 and add to cart
		pd.changeQuantity("3");
		pd.addToCart();
		
		// popup to go to cart menu
		pd.goToCart();
		
		driver.navigate().refresh();
		
		// Change courier and cancel
		wait.until(ExpectedConditions.elementToBeClickable(ct.ubahKurirBtn));
		ct.kurirChange();
		driver.switchTo().frame("ifrLayer");
		ct.kurirChangeCancel();
		
//		wait.until(ExpectedConditions.elementToBeClickable(ct.popupKurirBatalBtn));
//		ct.kurirChangeCancel();
		
		// delete item
		driver.switchTo().defaultContent();
		ct.deleteItem();
		ct.deleteConfirm();
		
		// verify cart is empty
		ct.verifyItemClear();
	}
}
