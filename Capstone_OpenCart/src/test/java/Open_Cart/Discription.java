package Open_Cart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Discription {
WebDriver driver;
WebDriverWait wait;
	@Given("OpenCart website open in the browser")
	public void open_cart_website_open_in_the_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage");
	}

	@When("select the product")
	public void select_the_product() {
		 driver.findElement(By.name("search")).sendKeys("MacBook");
	     driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
	     
	     JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)"); 
	}

	@And("check the Discription about product")
	public void check_the_discription_about_product() {
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[1]/a/img")).click();  
	}

	@Then("succesfully checked")
	public void succesfully_checked() {
	    String Dis=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[1]/div")).getText();	
	    System.out.println(Dis);
	    }



}
