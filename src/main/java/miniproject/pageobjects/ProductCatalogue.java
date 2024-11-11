package miniproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import miniproject.abstractcomponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// 	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//pageFactory 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//driver.findElement(By.cssSelector(".ng-animating"))
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	public List<WebElement> getProductlist() {
		
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		
	         WebElement prod =	products.stream().filter(product->
			product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return prod;
	}
	
	public void addToCart(String ProductName) throws InterruptedException {
		
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
}
