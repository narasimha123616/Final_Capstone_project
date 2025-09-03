package Myshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Checkout {
    WebDriver driver;
    WebDriverWait wait;
	@Given("The Myshop website is open in browser")
	public void the_myshop_website_is_open_in_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Opened Myshop homepage");
	}

	@And("selects the product then add to cart and checkout")
	public void selects_the_product_then_add_to_cart_and_checkout() {
		WebElement scr = driver.findElement(By.cssSelector("input.search-input.tt-input"));
	    scr.click();
	    scr.sendKeys("lava");
	    driver.findElement(By.cssSelector("button.search-button")).click();

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 400)"); 
	    
	    driver.findElement(By.linkText("Buy Now")).click();
	}

	@Then("the product displayed in cart")
	public void the_product_displayed_in_cart() {
	    driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
	    
	    WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]"));

	    if (errorMsg.isDisplayed()) {
	        String msg = errorMsg.getText();
	        System.out.println(" ERROR shown in cart Even If Available the Item: " + msg);
	    } else {
	        System.out.println(" No error message in cart, product added successfully.");
	    }
	}



}
