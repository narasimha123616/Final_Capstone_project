package Open_Cart;
import io.cucumber.java.en.Given;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CategorySearch {
WebDriver driver;
WebDriverWait wait;
	@Given("OpenCart open in the browser")
	public void open_cart_open_in_the_browser() {
		OpenCartLocators.openOpenCartSite();
        driver = OpenCartLocators.driver;  
	}
	@And("click on the product")
	public void click_on_the_product() throws Exception{
		driver.findElement(OpenCartLocators.Desk).click();
	    Thread.sleep(2000);	    
	}
	@Then("Successfully search")
	public void successfully_search() throws Exception{
		driver.findElement(OpenCartLocators.clickon).click();
		System.out.println("Successfullt Searched");
	}
}
