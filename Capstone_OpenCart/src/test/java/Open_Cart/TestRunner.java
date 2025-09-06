package Open_Cart;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",   
    glue = {"Open_Cart"},                          
    plugin = {
        "pretty",                               
        "html:target/HTML/htmlreport1.html",   
        "json:target/JSON/jsonreport1.json",   
        "junit:target/JUNIT/junitreport1.xml"   
    }
         
)
public class TestRunner extends AbstractTestNGCucumberTests {

}




