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

public class AddToCart {
WebDriver driver;
WebDriverWait wait;
	@Given("OpenCart website open")
	public void open_cart_website_open() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage"); 
	}

	@When("click on the cart")
	public void click_on_the_cart() {
		driver.findElement(By.name("search")).sendKeys("phone");
	    driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click(); 

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 300)");   
	}

	@And("check in the cart box")
	public void check_in_the_cart_box() {
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/i")).click();
	    driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")).click();
	    driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();
	}

	@Then("succesfully added")
	public void succesfully_added() {
	
		List<WebElement> errorMsgs = driver.findElements(By.xpath("//*[@id=\"checkout-cart\"]/div[1]"));

		if (!errorMsgs.isEmpty() && errorMsgs.get(0).isDisplayed()) {
		    String msg = errorMsgs.get(0).getText();
		    System.out.println(" ERROR shown in cart (even though item is available): "+ msg);
		} else {
		    System.out.println(" No error message in cart, product added successfully.");
		}

	}



	
}
