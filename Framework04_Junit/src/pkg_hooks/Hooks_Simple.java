package pkg_hooks;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import cucumber.api.Scenario;
import com.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;

public class Hooks_Simple extends GlobalObjects{

    @Before
    public void beforeEachScenario(){
        System.out.println("Log: Before every Scenario");
        String sChromeBinary=System.getProperty("user.dir") + "\\src\\browserDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", sChromeBinary);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        // Disable image loading - to speedup test execution
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.images", 2);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);

        GlobalDriver = new ChromeDriver(options);

        System.out.println("Log: Navigating to " + sUrlSearch + "\n");
        GlobalDriver.get(sUrlSearch);
        GlobalDriver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @After
    public void afterEachScenario(){
        System.out.println("Log: After the every Scenario" + "\n");
        GlobalDriver.quit();
    }

//    @After
//    public void afterEachScenarioWithScreenShot(Scenario scenario){
//        System.out.println("Log: After the every Scenario" + "\n");
//
//        // Add screenshot only if scenario fails
//        if (scenario.isFailed()) {
//            String sDDMMYY = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//            File src       = ((TakesScreenshot) GlobalDriver).getScreenshotAs(OutputType.FILE);
//            String dest    = System.getProperty("user.dir") +
//                             "//target//cucumber-extent-reports//"+"screenshot_"+sDDMMYY+".jpg";
//            File finalDestination = new File(dest);
//
//            try {
//                FileUtils.copyFile(src, finalDestination);
//                Reporter.addScreenCaptureFromPath(finalDestination.getAbsolutePath());
//            }catch (IOException eScreenshot) {
//                eScreenshot.printStackTrace();
//            }
//        }
//        GlobalDriver.quit();
//    }

    @Before("@search_special_2")
    public void beforeTaggedScenario(){
        System.out.println("Log: Only before specific scenario tagged with @search_special_2\n");
    }

    @After("@search_special_2")
    public void afterTaggedScenario(){
        System.out.println("Log: Only after specific scenario tagged with @search_special_2\n");
    }

}
