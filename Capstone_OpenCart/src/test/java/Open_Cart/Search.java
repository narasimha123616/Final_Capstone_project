package Open_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
    WebDriver driver;

    @Given("OpenCart website will be the open")
    public void open_cart_website_will_be_the_open() {
        OpenCartLocators.openOpenCartSite();
        driver = OpenCartLocators.driver;
    }

    @When("click on the search button")
    public void click_on_the_search_button() {
        driver.findElement(OpenCartLocators.searchBox).sendKeys("Monitors");
        driver.findElement(OpenCartLocators.searchBtn).click();
    }

    @And("check search funtionality")
    public void check_search_funtionality() throws Exception {
        WebElement searchMessage = driver.findElement(OpenCartLocators.errorMessage);
        String msg = searchMessage.getText();
        System.out.println("Search Message: " + msg);

        driver.findElement(OpenCartLocators.productitem).click();
        Thread.sleep(1000);

        int productCount = driver.findElements(OpenCartLocators.Thumbproduct).size();
        System.out.println("Number of monitors displayed: " + productCount);

        if (msg.contains("no product") && productCount > 0) {
            System.out.println("Inconsistent behavior: Search says no product, but category has monitors.");
        } else {
            System.out.println("Search and category behavior are consistent.");
        }
    }

    @Then("print the message")
    public void print_the_message() {
        System.out.println("Search functionality test completed.");
        driver.quit();
    }
}
