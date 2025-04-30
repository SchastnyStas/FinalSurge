package steps;

import io.qameta.allure.Step;
import object.Quick;

public class NewQuickAddSteps extends BaseSteps {

    @Step("Create new quick")
    public void createNewQuick(Quick quick) {
        dashboardPage
                .goToCalendarPage()
                .goToNewQuickAddWindow()
                .addNewQuick(quick);
    }
}

