package alami.elevenia.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	WebDriver xdriver;
	
	public Cart(WebDriver sdriver){
		
		xdriver = sdriver;
		PageFactory.initElements(sdriver, this);
	}
	
	@FindBy(name = "deliveryChangePopup")
	public WebElement ubahKurirBtn;
	
	@FindBy(xpath = "/html/body/section")
	public WebElement popUp;
	
	@FindBy(xpath = "//*[@id=\"frm\"]/article/p[3]/a[2]")
	public WebElement popupKurirBatalBtn;
	
	@FindBy(xpath = "//*[@id=\"frmTmall\"]/table/tbody/tr/td[7]/a[2]")
	public WebElement hapusBtn;
	
	@FindBy(id = "chkDelPopY")
	public WebElement hapusYes;
	
	@FindBy(css = "#frmTmall > table > tbody > tr > td > strong")
	public WebElement noItemCart;
	
	public void kurirChange() {
		ubahKurirBtn.click();
	}
	
	public void popupKurir() {
		if(popUp.isDisplayed()) {
			popupKurirBatalBtn.click();
		}
	}
	
	public void kurirChangeCancel() {
		popupKurirBatalBtn.click();
	}
	
	public void deleteItem() {
		hapusBtn.click();
	}
	
	public void deleteConfirm() {
		hapusYes.click();
	}
	
	public void verifyItemClear() {
		String text = noItemCart.getText();
		
		if(text.contains("Tidak ada produk di Shopping Cart")) {
			Assert.assertTrue(true);
			System.out.println("finish");
		} else {
			Assert.assertTrue(false);
		}
	}

}
