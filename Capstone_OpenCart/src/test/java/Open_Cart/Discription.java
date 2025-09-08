package Open_Cart;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Discription {
WebDriver driver;
	@Given("OpenCart website open in the browser")
	public void open_cart_website_open_in_the_browser() {
		OpenCartLocators.openOpenCartSite();
        driver = OpenCartLocators.driver; 
	}
	@When("select the product")
	public void select_the_product() {
		 driver.findElement(OpenCartLocators.searchBox).sendKeys("MacBook");
	     driver.findElement(OpenCartLocators.searchBtn).click();	     
	     JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)"); 
	}
	@And("check the Discription about product")
	public void check_the_discription_about_product() {
	    driver.findElement(OpenCartLocators.productLink).click();  
	}
	@Then("succesfully checked")
	public void succesfully_checked() {
	    String Dis=driver.findElement(OpenCartLocators.productDescription).getText();	
	    System.out.println(Dis);
	    }
}
