package steps;

import io.qameta.allure.Step;
import object.Full;

public class NewFullAddSteps extends BaseSteps {

    @Step("Create new full event")
    public void addNewFull(Full full) {
        dashboardPage
                .goToCalendarPage()
                .goToFullAddPage()
                .goToNewFullAddWindow()
                .addNewFull(full);
    }
}