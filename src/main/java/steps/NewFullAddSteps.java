package steps;

import object.Full;
import object.Quick;
import pages.NewFullAddWindow;
import pages.NewQuickAddWindow;

public class NewFullAddSteps extends BaseSteps {
    public NewFullAddWindow createFullAdd(Full full) {
        dashboardPage
                .goToCalendarPage()
                .goToFullAddPage()
                .goToNewFullAddWindow()
                .addNewFull(full);
        return new NewFullAddWindow();
    }
}