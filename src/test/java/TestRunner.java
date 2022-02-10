import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // features, glue and plugin is a default method from CucumberOptions
        features = "src/test/java/features",
        glue = "stepDef",
        monochrome = true,
        tags = "@login",
        dryRun = false,
        plugin = {
                "json:target/cucumber.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
