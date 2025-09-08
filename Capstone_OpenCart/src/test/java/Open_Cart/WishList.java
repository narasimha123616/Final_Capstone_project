package Open_Cart;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishList {
WebDriver driver;
WebDriverWait wait;
@Given("OpenCart will be open")
public void open_cart_will_be_open() {
	OpenCartLocators.openOpenCartSite();
    driver = OpenCartLocators.driver;
	}
@When("click on the selected")
public void click_on_the_selected() throws Exception{
	    driver.findElement(OpenCartLocators.Desk).click();
	    Thread.sleep(2000);
	    driver.findElement(OpenCartLocators.clickon).click();
	}
@And("click on wishlist")
public void click_on_wishlist() {
	    driver.findElement(OpenCartLocators.addToWish).click();
	    driver.findElement(OpenCartLocators.heart).click();
	}
@Then("updated successfully in the WishList")
public void updated_successfully_in_the_wish_list() {
	   WebElement reg = driver.findElement(OpenCartLocators.regEmail);
	   reg.click();
	   reg.sendKeys("kuruvanarasimha569@gmail.com");   
	   WebElement reg1 = driver.findElement(OpenCartLocators.regPass);
	   reg1.click();
	   reg1.sendKeys("Nara@123");
	   driver.findElement(OpenCartLocators.submitOk).click();
	   System.out.println("Successfully See the item in the cart");
	}
}
