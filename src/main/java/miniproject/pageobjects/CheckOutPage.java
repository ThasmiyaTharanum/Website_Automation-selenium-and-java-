package miniproject.pageobjects;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import miniproject.abstractcomponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));


	//pageFactory 
	@FindBy(css="[placeholder='Select Country']")
	WebElement TypeIndia;
	
// driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectIndia;
	
//	driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement SubmitButton;
	
	By CountrySuggestions =By.cssSelector(".ta-results");
	
	public void fillDetails(String CountryName) {
		Actions a = new Actions(driver);
		a.sendKeys(TypeIndia, CountryName).build().perform();
		waitForElementToAppear(CountrySuggestions);
		SelectIndia.click();
		
	}
	public ConfirmationPage orderSubmit() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(SubmitButton).click().build().perform();
		//SubmitButton.click();
		return new ConfirmationPage(driver);   //object creation of confirmationPage class
		
	}
	
}
