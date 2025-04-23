package steps;

import io.qameta.allure.Step;

public class SendFeedbackSteps extends BaseSteps {

    @Step("Send feedback")
    public void sendFeedback(String reason, String text) {
        dashboardPage.goToFeedback();
        feedbackPage.sendFeedback(reason, text);
    }

    @Step("Check success message is displayed")
    public boolean checkSuccessMessageIsDisplayed() {
        return feedbackPage.isDisplayedTextAfterSend();
    }
}