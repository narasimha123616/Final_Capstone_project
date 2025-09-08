package Open_Cart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class changeLanguage {
WebDriver driver;
WebDriverWait wait;
	@Given("OpenCart website will be open the browser")
	public void open_cart_website_will_be_open_the_browser() {
		OpenCartLocators.openOpenCartSite();
        driver = OpenCartLocators.driver;
	}
	@And("click on the currency")
	public void click_on_the_currency() {
	   driver.findElement(OpenCartLocators.currencyDropdown).click();
	}
	@And("update the currency")
	public void update_the_currency() {
	    driver.findElement(OpenCartLocators.currencyOptions).click();
	}
	@Then("updated successfully")
	public void updated_successfully() {
	    System.out.println(" Language Updated Successfully");
	}
}
