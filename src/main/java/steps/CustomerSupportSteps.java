package steps;

import io.qameta.allure.Step;

public class CustomerSupportSteps extends BaseSteps {

    @Step("Send to Customer Support")
    public void sendSupport(String select, String text) {
        dashboardPage.goToSupportPage();
        customerSupportPage.sendMessenger(select, text);
    }

    public boolean checkText() {
        return customerSupportPage.isDisplayedTextAfterSend();
    }
}
