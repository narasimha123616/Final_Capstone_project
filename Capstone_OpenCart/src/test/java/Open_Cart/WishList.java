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

public class WishList {
WebDriver driver;
WebDriverWait wait;
@Given("OpenCart will be open")
public void open_cart_will_be_open() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage");   
	}

@When("click on the selected")
public void click_on_the_selected() throws Exception{
	    driver.findElement(By.linkText("Desktops")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
	}

@And("click on wishlist")
public void click_on_wishlist() {
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[2]")).click();
	    driver.findElement(By.cssSelector("i.fa.fa-heart")).click();
	}

@Then("updated successfully in the WishList")
public void updated_successfully_in_the_wish_list() {
	   WebElement reg = driver.findElement(By.id("input-email"));
	   reg.click();
	   reg.sendKeys("kuruvanarasimha569@gmail.com");
	   
	   WebElement reg1 = driver.findElement(By.id("input-password"));
	   reg1.click();
	   reg1.sendKeys("Nara@123");
	   driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input[1]")).click();
	   
	   System.out.println("Successfully See the item in the cart");
	}



}
