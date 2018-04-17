package akhadova.steps;

import akhadova.StoryRunnerConfig;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class My extends StoryRunnerConfig {

    @Given("log first step to console")
    public void first() {
        System.out.println("first step");
    }

    @When("log second step to console")
    public void second() {
        System.out.println("second step");
    }

    @Then("log third step to console")
    public void third() {
        System.out.println("second step");
    }
}
