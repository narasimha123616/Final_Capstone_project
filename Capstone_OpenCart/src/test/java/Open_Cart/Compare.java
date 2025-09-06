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
import io.cucumber.java.en.When;

public class Compare {
WebDriver driver;
WebDriverWait wait;
	@Given("OpenCart will be the open")
	public void open_cart_will_be_the_open() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage");
	}

	@When("click on the selected item")
	public void click_on_the_selected_item() {
	  WebElement sr = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
	  sr.click();
	  sr.sendKeys("phone");
	  driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
	}

	@And("click on Compare")
	public void click_on_compare() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); 
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[3]")).click();
	}

	@Then("updated successfully in the Compare")
	public void updated_successfully_in_the_compare() {
		List<WebElement> CompareMsgs = driver.findElements(By.cssSelector("div.alert.alert-success.alert-dismissible"));

		if (!CompareMsgs.isEmpty() && CompareMsgs.get(0).isDisplayed()) {
		    String msg = CompareMsgs.get(0).getText();
		    System.out.println(" shown item added in the compare (even though item is available): "+ msg);
		} else {
		    System.out.println(" Not added item in the compare.");
		}
	}



}
