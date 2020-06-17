package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources",
        glue = "StepDefinitions",
        monochrome = false,
        dryRun = false,
        tags="@smoke and @negative and @regression"//both conditions
)
public class SmokeTestRunner {

}
