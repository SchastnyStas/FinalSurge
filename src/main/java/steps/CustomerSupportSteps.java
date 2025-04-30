package steps;

import io.qameta.allure.Step;

public class CustomerSupportSteps extends BaseSteps {

    @Step("Send message to Customer Support")
    public void sendMessageToSupport(String reason, String text) {
        dashboardPage.goToSupportPage();
        customerSupportPage.sendMessenger(reason, text);
    }

    @Step("Check success message is displayed")
    public boolean checkSuccessMessage() {
        return customerSupportPage.IsTextDisplayedAfterSend();
    }
}
