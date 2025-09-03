package Myshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class search {
         WebDriver driver;
         WebDriverWait wait;
	@Given("myshop open in the browser")
	public void myshop_open_in_the_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Pre-requisite: Opened myshop homepage");
	}

	@And("search the products")
	public void search_the_products() {
	    WebElement scr = driver.findElement(By.cssSelector("input.search-input.tt-input"));
	    scr.click();
	    scr.sendKeys("mobile charger");
	    driver.findElement(By.cssSelector("button.search-button")).click();
	}

	@Then("listed the items related product")
	public void listed_the_items_related_product() {
	    System.out.println("items displayed");
	}


	
}
