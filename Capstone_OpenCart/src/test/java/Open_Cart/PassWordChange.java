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
	@Given("website open in the browser")
	public void website_open_in_the_browser() {
		OpenCartLocators.openOpenCartSite();
        driver = OpenCartLocators.driver;  
	}
	@When("click on the my account")
	public void click_on_the_my_account() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		driver.findElement(OpenCartLocators.changePasswordLink).click();
	}
	@And("check in the valid credentials")
	public void check_in_the_valid_credentials() throws Exception{
	    driver.findElement(OpenCartLocators.newPassword).click();
	    Thread.sleep(2000);
	    WebElement Email=driver.findElement(OpenCartLocators.confirmNewPassword);
	    Email.click();
	    Email.sendKeys("kuruvanarasimha569@gmail.com");
	    driver.findElement(OpenCartLocators.passwordContinueBtn).click();
	}
	@Then("succesfully changed password")
	public void succesfully_changed_password() {	
		List<WebElement> CompareMsgs = driver.findElements(OpenCartLocators.accountLink);
		if (!CompareMsgs.isEmpty() && CompareMsgs.get(0).isDisplayed()) {
		    String msg = CompareMsgs.get(0).getText();
		    System.out.println(" Ready to Update password: "+ msg);
		} else {
		    System.out.println(" Enter Email is invalid.");
		}
	}
}
