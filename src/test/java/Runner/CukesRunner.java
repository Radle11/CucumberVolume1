package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features ="src\\test\\resources\\com.Etsy\\ScenarioOutlineEtsy.feature",
    glue="StepDefinitions",//even if it is blank it will find the path and run
    monochrome = false,
        dryRun=false,
        tags = "@EtsyOutline"
)
public class CukesRunner {}
