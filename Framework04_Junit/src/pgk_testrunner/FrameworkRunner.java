package pgk_testrunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
   features   = {"src/features"},
   glue       = {"pkg_stepdefinition"},
   strict     = true,
   monochrome = false,
   tags       = {"@search"},
   plugin     = {"html:target/fw1"}
)

public class FrameworkRunner
{

}


//  7. Parameter passing in feature file
//      Single multiple, String/ number
//      For specific step - Data table (converted to HashMap)
//      For entire scenario/ Scenario-outline
//      Difference between Scenario Outline & Scenario
//      Difference between Scenario Outline & Data Table
//  9. Background keyword - limitations (after scenario not possible)
//  10. Cucumber hooks before after


