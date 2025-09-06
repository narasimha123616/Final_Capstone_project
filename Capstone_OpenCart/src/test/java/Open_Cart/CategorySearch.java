package Open_Cart;

import io.cucumber.java.en.Given;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CategorySearch {
WebDriver driver;
WebDriverWait wait;
	@Given("OpenCart open in the browser")
	public void open_cart_open_in_the_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage");   
	}

	@And("click on the product")
	public void click_on_the_product() throws Exception{
		driver.findElement(By.linkText("Desktops")).click();
	    Thread.sleep(2000);
	    
	}

	@Then("Successfully search")
	public void successfully_search() throws Exception{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
		System.out.println("Successfullt Searched");
	}



}
