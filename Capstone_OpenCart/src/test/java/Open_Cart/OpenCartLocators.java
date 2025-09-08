package Open_Cart;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCartLocators {
    public static WebDriver driver;
    public static WebDriverWait wait;

    // Method to launch browser and open site
    public static void openOpenCartSite() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        System.out.println("Opened OpenCart homepage");
    }

    // Registration
    public static By account = By.xpath("//*[@id='top-links']/ul/li[2]/a/span[2]");
    public static By register = By.linkText("Register");
    public static By firstName = By.id("input-firstname");
    public static By lastName = By.id("input-lastname");
    public static By email = By.id("input-email");
    public static By telephone = By.id("input-telephone");
    public static By password = By.id("input-password");
    public static By confirmPassword = By.id("input-confirm");
    public static By privacyPolicy = By.name("agree");
    public static By continueBtn = By.cssSelector("input.btn.btn-primary");
    public static By loginEmail = By.id("input-email");
    public static By logout = By.linkText("Logout");
    public static By continueLogout = By.linkText("Continue");
    public static By loginPassword = By.id("input-password");
    public static By loginBtn = By.cssSelector("input.btn.btn-primary");
    
    // Search
    public static By errorMessage = By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]");
    public static By productitem = By.linkText("Components");
    public static By Thumbproduct = By.cssSelector(".product-thumb");
    public static By searchInput = By.name("search");
    public static By searchSubmitBtn = By.cssSelector("button.btn.btn-default");

    // Add to Cart
    public static By searchBox = By.name("search");
    public static By searchBtn = By.cssSelector("button.btn.btn-default.btn-lg");
    public static By productAddToCartBtn = By.xpath("//button[@data-original-title='Add to Cart']");
    public static By cartSuccessMsg = By.cssSelector("div.alert-success");
    public static By product = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/i");
    public static By Cart = By.xpath("//*[@id=\"checkout-cart\"]/div[1]");
    public static By AddToCart = By.linkText("Shopping Cart");

    // Checkout
    public static By checkoutBtn = By.linkText("Checkout");
    public static By billingContinueBtn = By.id("button-payment-address");
    public static By deliveryContinueBtn = By.id("button-shipping-address");
    public static By shippingMethodContinueBtn = By.id("button-shipping-method");
    public static By paymentMethodContinueBtn = By.id("button-payment-method");
    public static By confirmOrderBtn = By.id("button-confirm");
    public static By ViewSee = By.linkText("View Cart");
    public static By chekoutCart = By.xpath("//*[@id=\"checkout-cart\"]/div[1]");
    public static By clickonpro = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/i");
    public static By Checkon = By.xpath("/html/body/header/div/div/div[3]/div/button");
    
    // Compare
    public static By compareBtn = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[3]");
    public static By productComparisonLink = By.cssSelector("div.alert.alert-success.alert-dismissible");

   

    // Change Language
    public static By currencyDropdown = By.xpath("//*[@id=\"form-currency\"]/div/button/i");
    public static By currencyOptions = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");

    // Password Change
    public static By accountLink = By.xpath("//*[@id=\"account-login\"]/div[1]");
    public static By changePasswordLink = By.xpath("/html/body/footer/div/div/div[4]/ul/li[1]/a");
    public static By newPassword = By.linkText("Forgotten Password");
    public static By confirmNewPassword = By.id("input-email");
    public static By passwordContinueBtn = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");

    // Description Page
    public static By productLink = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[1]/a/img");
    public static By productDescription = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[1]/div");
    
    //Category Search
    public static By Desk = By.linkText("Desktops");
    public static By clickon = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a");
   
    //wishList
    public static By addToWish = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[2]");
    public static By heart = By.cssSelector("i.fa.fa-heart");
    public static By regEmail = By.id("input-email");
    public static By regPass = By.id("input-password");
    public static By submitOk = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input[1]");
}
