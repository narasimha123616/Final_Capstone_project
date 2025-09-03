package Myshop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;

public class AllCatogories {
      WebDriver driver;
      WebDriverWait wait;
	@Given("myshop website open in the browser")
	public void myshop_website_open_in_the_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Pre-requisite: Opened myshop homepage");
	}

	@And("search the products by categories")
	public void search_the_products_by_categories() throws Exception{

	    WebElement allCategories = driver.findElement(By.xpath("//span[normalize-space()='All Categories']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(allCategories).perform();  

       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement electronics = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='module-body']//span[normalize-space()='Electronics']")));        
        electronics.click();
	     
	}

	@Then("listed the items related product of category")
	public void listed_the_items_related_product_of_category() {
	   System.out.println("Category wise products displayed");
	}
	
}
