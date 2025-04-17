package steps;

import io.qameta.allure.Step;

public class SendFeedbackSteps extends BaseSteps {

    @Step("Send feedback")
    public void sendFeedback(String select, String text) {
        dashboardPage.goToFeedback();
        feedbackPage.sendFeedback(select, text);
    }

    public boolean checkText() {
        return feedbackPage.isDisplayedTextAfterSend();
    }
}