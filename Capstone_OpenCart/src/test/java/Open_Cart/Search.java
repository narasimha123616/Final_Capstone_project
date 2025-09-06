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

public class Search {
    WebDriver driver;
    WebDriverWait wait;
	@Given("OpenCart website will be the open")
	public void open_cart_website_will_be_the_open() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage"); 
	}

	@When("click on the search button")
	public void click_on_the_search_button() {
		 driver.findElement(By.name("search")).sendKeys("Monitors");
	     driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
	}

	@And("check search funtionality")
	public void check_search_funtionality() throws Exception {
		 WebElement searchMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]"));
	        String msg = searchMessage.getText();
	        System.out.println("Search Message: " + msg);

	        
	        driver.findElement(By.linkText("Components")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.linkText("Monitors (2)")).click();

	        
	        int productCount = driver.findElements(By.cssSelector(".product-thumb")).size();
	        System.out.println("Number of monitors displayed: " + productCount);
            
	        if (msg.contains("no product") && productCount > 0) {
	            System.out.println(" Inconsistent behavior: Search says no product, but category has monitors.");
	        } else {
	            System.out.println(" Search and category behavior are consistent.");
	        }
	}

	@Then("print the message")
	public void print_the_message() {
		System.out.println("Search functionality");
		driver.quit();
	}



}
