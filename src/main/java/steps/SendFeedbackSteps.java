package steps;

import io.qameta.allure.Step;

public class SendFeedbackSteps extends BaseSteps {

    @Step("Send feedback")
    public void sendFeedback(String reason, String text) {
        dashboardPage.goToFeedback();
        feedbackPage.sendFeedback(reason, text);
    }

    public boolean checkText() {
        return feedbackPage.isDisplayedTextAfterSend();
    }
}