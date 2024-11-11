package miniproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import miniproject.abstractcomponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	WebElement userEmail = driver.findElement(By.id("userEmail")); or we can use as below
	//pageFactory 
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut")
	WebElement errorMessage;
	
	
	//Action method
	public ProductCatalogue LoginApplication(String email, String password) {
		userEmail.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
		
	}
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
}
