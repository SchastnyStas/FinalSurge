package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.DataGenerator.generateRandomSentence;

public class CustomerSupportTest extends BaseTest {

    @Test
    public void sendCustomerSupport() {
        SoftAssert softAssert = new SoftAssert();

        String select = "Apple Mobile App";
        String text = generateRandomSentence();
        customerSupportSteps.sendSupport(select, text);
        softAssert.assertTrue(customerSupportSteps.checkText());
        softAssert.assertAll();
    }
}