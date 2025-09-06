package Open_Cart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class changeLanguage {
WebDriver driver;
WebDriverWait wait;
	@Given("OpenCart website will be open the browser")
	public void open_cart_website_will_be_open_the_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage"); 
	}

	@And("click on the currency")
	public void click_on_the_currency() {
	   driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/i")).click();
	}

	@And("update the currency")
	public void update_the_currency() {
	    driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button")).click();
	}

	@Then("updated successfully")
	public void updated_successfully() {
	    System.out.println(" Language Updated Successfully");
	}



}
