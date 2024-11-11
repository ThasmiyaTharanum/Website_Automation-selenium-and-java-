package miniproject.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import miniproject.abstractcomponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// 	List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	//pageFactory 
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement CheckOutButton;
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(Product-> Product.getText().equalsIgnoreCase(productName));
	     return match;
	}
	
}
