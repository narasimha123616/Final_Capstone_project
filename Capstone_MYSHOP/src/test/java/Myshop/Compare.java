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

public class Compare {
    WebDriver driver;
    WebDriverWait wait;
	@Given("Myshop website open on browser")
	public void myshop_website_open_on_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Opened Myshop homepage");  
	}

	@And("Click on the product and add to compare")
	public void click_on_the_product_and_add_to_compare() {
		WebElement scr = driver.findElement(By.cssSelector("input.search-input.tt-input"));
	    scr.click();
	    scr.sendKeys("mobile charger");
	    driver.findElement(By.cssSelector("button.search-button")).click();
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 400)"); 
	}

	@Then("Check the items in the compare")
	public void check_the_items_in_the_compare() {
		   driver.findElement(By.linkText("MCHARGE 214M - WHITE CHARGER")).click(); 
		   
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0, 600)"); 
	       driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/div[2]/div/div[6]/div/div[2]/a[2]")).click();
	       driver.findElement(By.xpath("//*[@id=\"main-menu-2\"]/ul/li[3]/a/span[2]")).click();
	}

}
