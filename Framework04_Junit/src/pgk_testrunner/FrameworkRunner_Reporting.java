package pgk_testrunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
   features   = {"src/features"},
   // Need to include package where hooks are implemented
   glue       = {"pkg_stepdefinition","pkg_hooks"},
   strict     = true,
   monochrome = false,
   tags       = {"@registration_fail"},
   plugin = {
           // for normal Junit HTML reporting
           "html:target/junit-reports",
           // for Extent reporting
           "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-reports/extent-report.html"
   }

)

public class FrameworkRunner_Reporting{

    @BeforeClass
    public static void setupBeforeClass() {
    // empty
    }

    @AfterClass
    public static void teardownAfterClass() {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")  +
                               "\\src\\resources\\extent-config.xml"));
        Reporter.setSystemInfo("Environment","SIT");
        Reporter.setSystemInfo("Author","Tony Stark");
    }
}

//  12. Special (Extent) and normal Junit HTML Reporting
//  13. Screenshot inside special (Extent) reporting
//      Need to add failure screenshots after every scenario (so need better implementation of @After hook)
//
//
//      Note: Don't open html file from Intellij/ Eclipse in Chrome
//            Open it from folder itself so image are loaded correctly
//
//
//
//
//  AShot library advantages:
//      Free, can take screenshot on Andriod/ iOS devices
//      Can take screenshot of individual element
//      Can Blur/ decorate screenshot, can compare screenshots

