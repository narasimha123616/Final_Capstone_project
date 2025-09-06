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

public class Register {
    WebDriver driver;
    WebDriverWait wait;
	@Given("OpenCart website will be open")
	public void open_cart_website_will_be_open() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage");
	}

	@When("click on the the account")
	public void click_on_the_the_account() {
	    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")).click();
	    driver.findElement(By.linkText("Register")).click();
	   
	}

	@And("Enter valid credentials")
	public void enter_valid_credentials() throws Exception{
		 WebElement FirstName = driver.findElement(By.id("input-firstname"));
		    FirstName.click();
		    FirstName.sendKeys("Kuruva");
		    Thread.sleep(1000);
		    
		    WebElement LastName = driver.findElement(By.id("input-lastname"));
		    LastName.click();
		    LastName.sendKeys("Narasimha");
		    Thread.sleep(1000);
		    
		    WebElement Email = driver.findElement(By.id("input-email"));
		    Email.click();
		    Email.sendKeys("nara12345@gmail.com");
		    Thread.sleep(1000);
		    
		    WebElement Telephone = driver.findElement(By.id("input-telephone"));
		    Telephone.click();
		    Telephone.sendKeys("9887668787");
		    Thread.sleep(1000);
		    
		    WebElement pass = driver.findElement(By.id("input-password"));
		    pass.click();
		    pass.sendKeys("abcd@123");
		    Thread.sleep(1000);
		    
		    WebElement confirm = driver.findElement(By.id("input-confirm"));
		    confirm.click();
		    confirm.sendKeys("abcd@123");
		    Thread.sleep(1000);
		     
	}

	@Then("login successfully with valid credentials")
	public void login_successfully_with_valid_credentials() throws Exception{
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
	    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	
	    driver.findElement(By.linkText("Continue")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Logout")).click(); 
	    driver.findElement(By.linkText("Continue")).click();
		  
	}

	
	
}
