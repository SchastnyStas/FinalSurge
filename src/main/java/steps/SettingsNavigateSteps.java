package steps;

import io.qameta.allure.Step;

public class SettingsNavigateSteps extends BaseSteps {

    @Step("Go to settings pages and check if page is loaded")
    public boolean goToSettingsPageAndCheck() {
        dashboardPage.goToSettingPage();
        return settingsPage.checkSettingsPageIsLoaded();
    }
}
