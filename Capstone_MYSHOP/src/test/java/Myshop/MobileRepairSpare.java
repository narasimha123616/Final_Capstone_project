package Myshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class MobileRepairSpare {
    WebDriver driver;
    WebDriverWait wait;
	@Given("Myshop website open in browser")
	public void myshop_website_open_in_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Opened Myshop homepage");
	}

	@And("Click on the mobile repair spare category")
	public void click_on_the_mobile_repair_spare_category() throws Exception{
	    WebElement btn = driver.findElement(By.linkText("Mobile Repairing Spare"));
	    Thread.sleep(2000);
	    btn.click(); 
	}

	@Then("Check the items in the spair")
	public void check_the_items_in_the_spair() {
	   driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div[3]/div[2]/ul/li[7]/div/ul/li[2]/a/span[1]")).click();

	   WebElement countElement = driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div[3]/div[2]/ul/li[7]/div/ul/li[2]/a/span[2]"));
       String countText = countElement.getAttribute("innerText").trim();

	   int cameraCount = Integer.parseInt(countText);

	   System.out.println("Camera count (as String): " + countText);
	   System.out.println("Camera count (as int): " + cameraCount);
	  
	}



}
