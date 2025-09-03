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

public class wishlist {
    WebDriver driver;
    WebDriverWait wait;
	@Given("Myshop website open in the browser")
	public void myshop_website_open_in_the_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Opened Myshop homepage");
	}

	@And("Click on the product and add to wishlist")
	public void click_on_the_product_and_add_to_wishlist() {
		
		WebElement scr = driver.findElement(By.cssSelector("input.search-input.tt-input"));
	    scr.click();
	    scr.sendKeys("mobile charger");
	    driver.findElement(By.cssSelector("button.search-button")).click();
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 400)"); 
	}

	@Then("Check the items in the wishlist")
	public void check_the_items_in_the_wishlist() throws Exception{
	   driver.findElement(By.linkText("MCHARGE 214M - WHITE CHARGER")).click(); 
	   
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0, 600)"); 
	   driver.findElement(By.xpath("//*[@id=\"product\"]/div[6]/div/div[2]/a[1]")).click();
	   driver.findElement(By.xpath("//*[@id=\"main-menu-2\"]/ul/li[2]/a/span[2]")).click();
	   
	   driver.findElement(By.id("input-email")).sendKeys("kuruvanarasimha569@gmail.com");
	   driver.findElement(By.id("input-password")).sendKeys("Nara@123");
	   driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[3]/div/button")).click();
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")).click();
	}

}
