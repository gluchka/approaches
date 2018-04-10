package first;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TradedSteps {


    @Given("a stock of symbol $symbol and a threshold of $threshold")
    public void aStock(String symbol, double threshold) {
        System.out.println("first step" + symbol + " threshold - " + threshold);
    }

    @When("the stock is traded at $price")
    public void theStockIsTradedAt(double price) {
        System.out.println("second step " + price);
    }

    @Then("the alert status should be $status")
    public void theAlertStatusShouldBe(String status) {
        System.out.println("third step " + status);
    }
}
