package miniproject.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import miniproject.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// 	List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	//pageFactory 
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement CheckOutButton;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartproducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	     return match;
	}
	 public CheckOutPage goToCheckOut() {
		 CheckOutButton.click();
		 CheckOutPage checkoutpage = new CheckOutPage(driver);
		 return checkoutpage;
	 }
	
	
}
