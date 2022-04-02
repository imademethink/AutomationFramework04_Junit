package pkg_stepdefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class StepDef_Search {

    WebDriver Driver     = null;
    String    sUrlSearch = "http://automationpractice.com/index.php";

    @Given("^User navigates to search screen$")
    public void User_navigates_to_search_screen(){
        String sChromeBinary=System.getProperty("user.dir") + "\\src\\browserDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", sChromeBinary);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.setExperimentalOption("useAutomationExtension", false);

        Driver = new ChromeDriver(options);

        System.out.println("Log: Navigating to " + sUrlSearch);
        Driver.get(sUrlSearch);
        Driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @When("^User attempts to search for \"(.*?)\" item$")
    public void User_attempts_to_search_for_item(String sSearchType){
        System.out.println("Log: Searching for " + sSearchType + " items");
//        String sSearchItem = "dress";
//        if(sSearchType.toLowerCase().contains("invalid")){
//            sSearchItem = "candle";
//        }
//        Driver.findElement(By.id("search_query_top")).sendKeys(sSearchItem);
//        Driver.findElement(By.name("submit_search")).click();
//        Driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Then("^Successful search results \"(.*?)\" shown")
    public void Successful_search_results_shown(String sExpectedSearchResult){
//        String sResultCount = Driver.findElement(By.cssSelector("span[class='heading-counter']")).getText();
//
//        if(sExpectedSearchResult.contains("should NOT be") &&
//           sResultCount.contains("0 results have been found"))
//        {
//            System.out.println("Log: Item search criteria met");
//            return;
//        }
//
//
//        if(sExpectedSearchResult.contains("should be") &&
//           sResultCount.contains("7 results have been found"))
//        {
//            System.out.println("Log: Item search criteria met");
//            return;
//        }
//
//        Assert.fail("Log: Item search criteria NOT met");
    }


}