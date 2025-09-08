package Open_Cart;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {
WebDriver driver;
WebDriverWait wait;
	@Given("OpenCart website open")
	public void open_cart_website_open() {
		OpenCartLocators.openOpenCartSite();
		  driver = OpenCartLocators.driver;
	}
	@When("click on the cart")
	public void click_on_the_cart() {
		driver.findElement(OpenCartLocators.searchBox).sendKeys("phone");
	    driver.findElement(OpenCartLocators.searchBtn).click(); 

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 300)");   
	}
	@And("check in the cart box")
	public void check_in_the_cart_box() {
	    driver.findElement(OpenCartLocators.product).click();
	    driver.findElement(OpenCartLocators.AddToCart).click();
	}
	@Then("succesfully added")
	public void succesfully_added() {	
		List<WebElement> errorMsgs = driver.findElements(OpenCartLocators.Cart);
		if (!errorMsgs.isEmpty() && errorMsgs.get(0).isDisplayed()) {
		    String msg = errorMsgs.get(0).getText();
		    System.out.println(" ERROR shown in cart (even though item is available): "+ msg);
		} else {
		    System.out.println(" No error message in cart, product added successfully.");
		}
	}



	
}
