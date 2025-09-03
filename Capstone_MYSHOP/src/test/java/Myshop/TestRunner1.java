package Myshop;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",   
    glue = {"Myshop"},                          
    plugin = {
        "pretty",                               
        "html:target/HTML2/htmlreport1.html",   
        "json:target/JSON2/jsonreport1.json",   
        "junit:target/JUNIT2/junitreport1.xml"   
    }
         
)
public class TestRunner1 extends AbstractTestNGCucumberTests {
}
