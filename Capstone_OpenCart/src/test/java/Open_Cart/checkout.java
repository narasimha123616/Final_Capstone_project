package Open_Cart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class checkout {
    WebDriver driver;
    WebDriverWait wait;
	@Given("OpenCart website will be  open")
	public void open_cart_website_will_be_open() {
		OpenCartLocators.openOpenCartSite();
        driver = OpenCartLocators.driver;
	}

	@And("click on the item")
	public void click_on_the_item() {
	    
	    driver.findElement(OpenCartLocators.searchBox).sendKeys("phone");
        driver.findElement(OpenCartLocators.searchBtn).click();

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 300)");   
	    
	    driver.findElement(OpenCartLocators.clickonpro).click();
	    driver.findElement(OpenCartLocators.Checkon).click();
	    driver.findElement(OpenCartLocators.ViewSee);
	}

	@And("add item into cart")
	public void add_item_into_cart() throws Exception{
	    driver.findElement(OpenCartLocators.checkoutBtn).click();
	    Thread.sleep(2000);
	}

	@Then("checkout working")
	public void checkout_working() {
		List<WebElement> errorMsgs = driver.findElements(OpenCartLocators.chekoutCart);

		if (!errorMsgs.isEmpty() && errorMsgs.get(0).isDisplayed()) {
		    String msg = errorMsgs.get(0).getText();
		    System.out.println(" ERROR shown in cart (even though item is available): "+ msg);
		} else {
		    System.out.println(" No error message in cart, product added successfully.");
		}
	}



}
