Scenario:  trader is not alerted below threshold
 
Given a stock of symbol STK1 and a threshold of 10.0
When the stock is traded at 5.0
Then the alert status should be OFF
