package steps;

import io.qameta.allure.Step;

public class CustomerSupportSteps extends BaseSteps {

    @Step("Send message to Customer Support")
    public void sendMessageToSupport(String reason, String text) {
        dashboardPage.goToSupportPage();
        customerSupportPage.sendMessenger(reason, text);
    }

    public boolean checkSuccessMessage() {
        return customerSupportPage.isDisplayedTextAfterSend();
    }
}
