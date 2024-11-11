package miniproject.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import miniproject.pageobjects.CartPage;
import miniproject.pageobjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderButton;
	
	
	
	public CartPage goToCartPage() {
		cartButton.click();
	   CartPage cartpage = new CartPage(driver);
	   return cartpage;
	}
	
	public OrderPage goToOrdersPage() {
		orderButton.click();
	   OrderPage orderpage = new OrderPage(driver);
	   return orderpage;
	}


	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
public void waitForWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement animation) throws InterruptedException {
          Thread.sleep(1000);
		//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(animation));
	}
}
