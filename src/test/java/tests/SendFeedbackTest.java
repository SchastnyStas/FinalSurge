package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.DataGenerator.generateRandomSentence;

public class SendFeedbackTest extends BaseTest {

    @Test
    public void sendFeedback() {
        SoftAssert softAssert = new SoftAssert();
        String select = "Feature Improvement";
        String text = generateRandomSentence();

        sendFeedbackSteps.sendFeedback(select, text);
        softAssert.assertTrue(sendFeedbackSteps.checkText());
        softAssert.assertAll();
    }
}
