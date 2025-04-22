package steps;

import io.qameta.allure.Step;

public class CustomerSupportSteps extends BaseSteps {

    @Step("Send to Customer Support")
    public void sendMessageToSupport(String select, String text) {
        dashboardPage.goToSupportPage();
        customerSupportPage.sendMessenger(select, text);
    }

    public boolean checkSuccessMessage() {
        return customerSupportPage.isDisplayedTextAfterSend();
    }
}
