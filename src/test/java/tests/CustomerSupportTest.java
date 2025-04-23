package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.DataGenerator.generateRandomSentence;

public class CustomerSupportTest extends BaseTest {

    @Test(description = "Send to Customer Support")
    public void sendCustomerSupport() {
        String select = "Apple Mobile App";
        String text = generateRandomSentence();

        customerSupportSteps.sendMessageToSupport(select, text);
        Assert.assertTrue(customerSupportSteps.checkSuccessMessage());
    }

    @Test(description = "Send feedback")
    public void sendFeedback() {
        String select = "Feature Improvement";
        String text = generateRandomSentence();

        sendFeedbackSteps.sendFeedback(select, text);
        Assert.assertTrue(sendFeedbackSteps.checkSuccessMessageIsDisplayed());
    }
}