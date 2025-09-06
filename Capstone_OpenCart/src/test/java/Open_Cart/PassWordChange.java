package Open_Cart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PassWordChange {
WebDriver driver;
WebDriverWait wait;
	@Given("website open in the browser")
	public void website_open_in_the_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage");
	}

	@When("click on the my account")
	public void click_on_the_my_account() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[1]/a")).click();
	}

	@And("check in the valid credentials")
	public void check_in_the_valid_credentials() throws Exception{
	    driver.findElement(By.linkText("Forgotten Password")).click();
	    Thread.sleep(2000);
	    WebElement Email=driver.findElement(By.id("input-email"));
	    Email.click();
	    Email.sendKeys("kuruvanarasimha569@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
	}

	@Then("succesfully changed password")
	public void succesfully_changed_password() {
		
		List<WebElement> CompareMsgs = driver.findElements(By.xpath("//*[@id=\"account-login\"]/div[1]"));

		if (!CompareMsgs.isEmpty() && CompareMsgs.get(0).isDisplayed()) {
		    String msg = CompareMsgs.get(0).getText();
		    System.out.println(" Ready to Update password: "+ msg);
		} else {
		    System.out.println(" Enter Email is invalid.");
		}
	}



}
