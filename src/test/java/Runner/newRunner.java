package Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"},
        features ="src\\test\\resources",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue="StepDefinitions",//even if it is blank it will find the path and run
        monochrome = false,
        dryRun=false,
         tags = "@myApp"
)
public class newRunner {
}
