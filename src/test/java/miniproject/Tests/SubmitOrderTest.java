package miniproject.Tests;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import miniproject.TestComponents.BaseTest;
import miniproject.pageobjects.CartPage;
import miniproject.pageobjects.CheckOutPage;
import miniproject.pageobjects.ConfirmationPage;
import miniproject.pageobjects.LandingPage;
import miniproject.pageobjects.OrderPage;
import miniproject.pageobjects.ProductCatalogue;


public class SubmitOrderTest extends BaseTest  {
	 String productName = "ZARA COAT 3";

	 @Test(dataProvider="getData", groups= {"Purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
	     ProductCatalogue productcatalogue = landingpage.LoginApplication(input.get("email"), input.get("password"));
	     List<WebElement> products = productcatalogue.getProductlist();
	     productcatalogue.addToCart(input.get("product"));
	     CartPage cartpage = productcatalogue.goToCartPage();
	    
	     Boolean match = cartpage.verifyProductDisplay(input.get("product"));
	     Assert.assertTrue(match);
	     CheckOutPage checkoutpage = cartpage.goToCheckOut();
	     checkoutpage.fillDetails("india");
	     ConfirmationPage confirmationpage = checkoutpage.orderSubmit();
	     confirmationpage.getConfirmationMessage();
	    
	     String confirmMessage = confirmationpage.getConfirmationMessage();
         Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	    
	}
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryTest() {
		// To verify the product added is shown in orders page
		
		 ProductCatalogue productcatalogue = landingpage.LoginApplication("anshika@gmail.com", "Iamking@000");
	     OrderPage orderpage = productcatalogue.goToOrdersPage();
	     Assert
	     .assertTrue(orderpage.verifyOrderDisplay(productName)); 
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//miniproject//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1) }};
	}
}


//HashMap<String,String> map = new HashMap<String,String>();
//map.put("email", "anshika@gmail.com");
//map.put("password", "Iamking@000");
//map.put("product", "ZARA COAT 3");
//
//HashMap<String,String> map1 = new HashMap<String,String>();
//map1.put("email", "shetty@gmail.com");
//map1.put("password", "Iamking@000");
//map1.put("product", "ADIDAS ORIGINAL");


//The below code is refactored as above code
	    //		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
		//driver.get("https://rahulshettyacademy.com/client");
//	     LandingPage landingPage = new LandingPage(driver);
//	     landingPage.goTo();
	     
	   // ProductCatalogue productcatalogue = new ProductCatalogue(driver);
	 // CartPage cartpage = new CartPage(driver);
	    
	     
	     //  driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
	  //	driver.findElement(By.id("login")).click();
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		
//	     WebElement prod =	products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	//	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
//		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
//	Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
//	
//	driver.findElement(By.cssSelector(".totalRow button")).click();
//	
//	Actions a = new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//	driver.findElement(By.cssSelector(".action__submit")).click();
//	
//	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();
	//	
//		
	
