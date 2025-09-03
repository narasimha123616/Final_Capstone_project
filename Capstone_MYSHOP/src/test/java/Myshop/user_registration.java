package Myshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class user_registration {
	WebDriver driver;
    WebDriverWait wait;
	
	@Given("myshop website will be open")
	public void myshop_website_will_be_open() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Pre-requisite: Opened myshop homepage");
	}

	@And("login the account with valid credentials")
	public void login_the_account_with_valid_credentials() throws InterruptedException{		
		driver.findElement(By.linkText("Account")).click();
        driver.findElement(By.linkText("Sign in")).click();
	   
	    driver.switchTo().frame(0);   
	    driver.findElement(By.id("input-email")).sendKeys("kuruvanarasimha569@gmail.com");
	    driver.findElement(By.id("input-password")).sendKeys("Nara@123");
	   
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement loginButton = wait.until(
	        ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary"))
	    );
	    loginButton.click();
	    driver.switchTo().defaultContent();			
	    }

	@Then("login successfully with valid credentials")
	public void login_successfully_with_valid_credentials() {
	   System.out.println("login successfully");
	}

}
