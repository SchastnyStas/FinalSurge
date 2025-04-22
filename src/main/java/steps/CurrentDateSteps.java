package steps;

import io.qameta.allure.Step;

public class CurrentDateSteps extends BaseSteps {

    @Step("Get the current date from top bar")
    public String getDisplayedDate() {
        return dashboardPage.getCurrentDate();
    }
}
