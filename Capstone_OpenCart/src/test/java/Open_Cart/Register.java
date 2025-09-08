package Open_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
    WebDriver driver;
	@Given("OpenCart website will be open")
	public void open_cart_website_will_be_open() {
		OpenCartLocators.openOpenCartSite();
		  driver = OpenCartLocators.driver;
	}

	@When("click on the the account")
	public void click_on_the_the_account() {
		driver.findElement(OpenCartLocators.account).click();
	    driver.findElement(OpenCartLocators.register).click();
	   
	}

	@And("Enter valid credentials")
	public void enter_valid_credentials() throws Exception{
		 WebElement FirstName = driver.findElement(OpenCartLocators.firstName);
		    FirstName.click();
		    FirstName.sendKeys("Kuruva");
		    Thread.sleep(1000);
		    
		    WebElement LastName = driver.findElement(OpenCartLocators.lastName);
		    LastName.click();
		    LastName.sendKeys("Narasimha");
		    Thread.sleep(1000);
		    
		    WebElement Email = driver.findElement(OpenCartLocators.email);
		    Email.click();
		    Email.sendKeys("nara12345678@gmail.com");
		    Thread.sleep(1000);
		    
		    WebElement Telephone = driver.findElement(OpenCartLocators.telephone);
		    Telephone.click();
		    Telephone.sendKeys("9887668787");
		    Thread.sleep(1000);
		    
		    WebElement pass = driver.findElement(OpenCartLocators.password);
		    pass.click();
		    pass.sendKeys("abcd@123");
		    Thread.sleep(1000);
		    
		    WebElement confirm = driver.findElement(OpenCartLocators.confirmPassword);
		    confirm.click();
		    confirm.sendKeys("abcd@123");
		    Thread.sleep(1000);
		     
	}

	@Then("login successfully with valid credentials")
	public void login_successfully_with_valid_credentials() throws Exception{
		driver.findElement(OpenCartLocators.privacyPolicy).click();
	    driver.findElement(OpenCartLocators.continueBtn).click();
	    Thread.sleep(2000);
	    driver.findElement(OpenCartLocators.logout).click(); 
	    driver.findElement(OpenCartLocators.continueLogout).click();
		  
	}

	
	
}
