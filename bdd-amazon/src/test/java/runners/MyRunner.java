package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:reports/cucumber.json",
                "pretty"},
        features = {"src/test/resources"},
        glue = {"steps"}
)

public class MyRunner extends AbstractTestNGCucumberTests {

}