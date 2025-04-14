package steps;

import io.qameta.allure.Step;
import object.Quick;
import pages.NewQuickAddWindow;

public class NewQuickAddSteps extends BaseSteps {


    @Step("Create new quick")
    public NewQuickAddWindow createNewQuick(Quick quick) {
        dashboardPage
                .goToCalendarPage()
                .goToNewQuickAddWindow()
                .addNewQuick(quick);
        return new NewQuickAddWindow();
    }
}

