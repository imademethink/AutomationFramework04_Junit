package pgk_testrunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
   features   = {"src/features"},

   // need to add package path where hooks are implemented
   glue       = {"pkg_stepdefinition","pkg_hooks"},

   strict     = true,
   monochrome = false,
   tags       = {"@search_special_1"},
   plugin     = {"html:target/fw_hooks"}
)

public class FrameworkRunner_Hooks
{
    // This runner class should be empty
}


//  10. Cucumber hooks before after  -- Need to add additional package in glue where hooks are implemented
//          hooks for every scenario
//          hooks for specific scenario

