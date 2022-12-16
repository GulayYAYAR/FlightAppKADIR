package e2e.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepDefinitions",
        tags = "",
        dryRun = false,
        monochrome = true,
        plugin = {
                "pretty"
        }
)
public class APIRunner {
}
