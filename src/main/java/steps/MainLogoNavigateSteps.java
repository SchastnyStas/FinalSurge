package steps;

import io.qameta.allure.Step;

public class MainLogoNavigateSteps extends BaseSteps {

    @Step("Go to dashboard page via main logo and check if page is loaded")
    public boolean goToDashboardPage() {
        dashboardPage.goToCalendarPage();
        calendarPage.clickOnMainLogo();
        return dashboardPage.isVisibleCalendarButton();
    }
}
