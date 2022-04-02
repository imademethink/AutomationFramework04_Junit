package pkg_stepdefinition;
import cucumber.api.java.en.When;

public class StepDef_zDummy {

    @When("^Statement (\\d+)$")
    public void Statement(int n) {
        System.out.println("Log: "+n);
    }


}