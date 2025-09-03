package Myshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToCart {
    WebDriver driver;
    WebDriverWait wait;
	@Given("The Myshop website is open in the browser")
	public void the_myshop_website_is_open_in_the_browser() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://myshop.org.in/index.php?route=common/home");
        driver.manage().window().maximize();
        System.out.println("Opened Myshop homepage");
	}

	@And("selects the product and add to cart")
	public void selects_the_product_and_add_to_cart() throws Exception {
		WebElement scr = driver.findElement(By.cssSelector("input.search-input.tt-input"));
	    scr.click();
	    scr.sendKeys("lava");
	    driver.findElement(By.cssSelector("button.search-button")).click();

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 400)"); 
	    
	    driver.findElement(By.linkText("Buy Now")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[1]/a")).click();
	    Thread.sleep(2000);
	    
	    WebElement scr1 = driver.findElement(By.cssSelector("input.search-input.tt-input"));
	    scr1.click();
	    scr1.sendKeys("battery");
	    driver.findElement(By.cssSelector("button.search-button")).click();

	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0, 400)"); 
	    
	    driver.findElement(By.linkText("Buy Now")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/div/table/tbody/tr[2]/td[4]/div/div/span/i[1]")).click();
	}

	@Then("the product displayed in the cart")
	public void the_product_displayed_in_the_cart() {
		 
		String unitPriceText = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/form/div/table/tbody/tr/td[5]")).getText();
		String totalPriceText = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/form/div/table/tbody/tr/td[6]")).getText();

		double unitPrice = Double.parseDouble(unitPriceText.replace("Rs.", "").replace(",", "").trim());
		double totalPrice = Double.parseDouble(totalPriceText.replace("Rs.", "").replace(",", "").trim());
		int quantity = 2;
		
		System.out.println(unitPriceText);
		System.out.println(totalPriceText);
		System.out.println(quantity);

		if (totalPrice != unitPrice * quantity) {
		    System.out.println("ERROR: Cart total mismatch! Expected: Rs." + (unitPrice * quantity) + " but got: Rs." + totalPrice);
		} else {
		    System.out.println("Cart total verified correctly. Total Amount: Rs." + totalPrice);
		}
	}

	
}
