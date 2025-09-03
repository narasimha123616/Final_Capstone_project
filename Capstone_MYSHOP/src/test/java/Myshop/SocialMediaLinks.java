package Myshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SocialMediaLinks {
        WebDriver driver;
        WebDriverWait wait;
	@Given("Myshop website is open in browser")
	public void myshop_website_is_open_in_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Opened Myshop homepage");
	
	}

	@And("Click on the social media buttons")
	public void click_on_the_social_media_buttons() throws Exception{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
	}

	@Then("Check the navigation of Buttons")
	public void check_the_navigation_of_buttons() {
		driver.findElement(By.xpath("/html/body/div[4]/footer/div/div[2]/div/div[1]/div/div[1]/div/ul/li[1]")).click();
		System.out.println("Error: Buttons Does not Navigate to other Window or Specific location");
	}

}
