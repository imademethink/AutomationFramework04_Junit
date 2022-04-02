package pkg_stepdefinition;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pkg_hooks.GlobalObjects;
import cucumber.api.java.en.Given;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StepDef_RegisterFail extends GlobalObjects {

    @Given("^User navigates to registration screen only$")
    public void User_navigates_to_registration_screen_only(){
        String sUrlRegister = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        System.out.println("Log: Navigating to " + sUrlRegister);
        GlobalDriver.get(sUrlRegister);
        GlobalDriver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @When("^User attempts to register with invalid data$")
    public void User_attempts_to_register_with_invalid_data(){

        System.out.println("Log: Registration begins");
        GlobalDriver.findElement(By.id("email_create")).sendKeys(
                "randomname" + new Random().nextInt(99999) + "@mailinator.com");
        GlobalDriver.findElement(By.cssSelector("i[class*='icon-user']")).click();
        GlobalDriver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);

        GlobalDriver.findElement(By.id("customer_firstname")).sendKeys("NameFirst");
        GlobalDriver.findElement(By.id("customer_lastname")).sendKeys("NameLast");
        GlobalDriver.findElement(By.id("passwd")).sendKeys("Abcd@1234");

        GlobalDriver.findElement(By.id("submitAccount_fake")).click();
    }
}
