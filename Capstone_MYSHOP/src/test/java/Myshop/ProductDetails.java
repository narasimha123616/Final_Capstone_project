package Myshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProductDetails {
    WebDriver driver;
    WebDriverWait wait;

    @Given("the Myshop website is open in the browser")
    public void the_myshop_website_is_open_in_the_browser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Opened Myshop homepage");
    }

    @And("selects the product and get details")
    public void selects_the_product_and_get_details() throws Exception{
    	WebElement scr = driver.findElement(By.cssSelector("input.search-input.tt-input"));
	    scr.click();
	    scr.sendKeys("mobile charger");
	    driver.findElement(By.cssSelector("button.search-button")).click();
	    Thread.sleep(2000);
	  
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 400)");  
        driver.findElement(By.linkText("MCHARGE 214M - WHITE CHARGER")).click();

    }

    @Then("the product details should be displayed including")
    public void the_product_details_should_be_displayed_including() {
        System.out.println("===== Product Details =====");
        
        WebElement descriptionBlock = driver.findElement(By.xpath("//*[@id=\"product\"]/div[5]/div/div[1]/div[1]"));
        String descriptionText = descriptionBlock.getText();
        System.out.println("Product after discount price:\n" + descriptionText);
        
        WebElement descriptionBlock3 = driver.findElement(By.xpath("//*[@id=\"product\"]/div[5]/div/div[1]/div[2]"));
        String descriptionText3 = descriptionBlock3.getText();
        System.out.println("Product original price:\n" + descriptionText3);

        WebElement descriptionBlock1 = driver.findElement(By.xpath("//*[@id=\"product\"]/div[3]/ul/li[2]/span"));
        String descriptionText1 = descriptionBlock1.getText();
        System.out.println("Product Model:\n" + descriptionText1);
        
        WebElement descriptionBlock2 = driver.findElement(By.xpath("//*[@id=\"product\"]/div[3]/ul/li[1]/span"));
        String descriptionText2 = descriptionBlock2.getText();
        System.out.println("Product availability:\n" + descriptionText2);

        driver.quit();
    }
}

