package miniproject.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import miniproject.TestComponents.BaseTest;
import miniproject.TestComponents.Retry;
import miniproject.pageobjects.CartPage;
import miniproject.pageobjects.OrderPage;
import miniproject.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{
	String productName = "ZARA COAT 3";
	@Test(groups={"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
 
	
	    ProductCatalogue productcatalogue = landingpage.LoginApplication("anshika@gmail.com", "Iamk@000");
		Assert.assertEquals("Incorrect email  password.", landingpage.getErrorMessage());  
		
	}
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
 
		
		     ProductCatalogue productcatalogue = landingpage.LoginApplication("anshika@gmail.com", "Iamking@000");
		     List<WebElement> products = productcatalogue.getProductlist();
		     productcatalogue.addToCart(productName);
		     CartPage cartpage = productcatalogue.goToCartPage();
		    
		     Boolean match = cartpage.verifyProductDisplay("ZARA COAT 33");
		     Assert.assertFalse(match);  
		
	}
	
}
