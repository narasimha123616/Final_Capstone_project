package Open_Cart;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Compare {
WebDriver driver;
	@Given("OpenCart will be the open")
	public void open_cart_will_be_the_open() {
		OpenCartLocators.openOpenCartSite();
        driver = OpenCartLocators.driver;  
	}
	@When("click on the selected item")
	public void click_on_the_selected_item() {
	  WebElement sr = driver.findElement(OpenCartLocators.searchBox);
	  sr.click();
	  sr.sendKeys("phone");
	  driver.findElement(OpenCartLocators.searchBtn).click();
	}
	@And("click on Compare")
	public void click_on_compare() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); 	
		driver.findElement(OpenCartLocators.compareBtn).click();
	}
	@Then("updated successfully in the Compare")
	public void updated_successfully_in_the_compare() {
		List<WebElement> CompareMsgs = driver.findElements(OpenCartLocators.productComparisonLink);
		if (!CompareMsgs.isEmpty() && CompareMsgs.get(0).isDisplayed()) {
		    String msg = CompareMsgs.get(0).getText();
		    System.out.println(" shown item added in the compare (even though item is available): "+ msg);
		} else {
		    System.out.println(" Not added item in the compare.");
		}
	}
}
