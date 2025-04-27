package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.findElementByHref;

public class BasePage {
    private static final SelenideElement FINAL_SURGE_LOGO = $x("//*[@class='main-logo']//img");
    private static final SelenideElement LOGOUT_BUTTON = findElementByHref("logout.cshtml");
    private static final SelenideElement GO_TO_SETTINGS_BUTTON = findElementByHref("UserProfile.cshtml");

    /**
     * Clicks on the Final Surge logo on the page
     * and goes to the main (Dashboard) page.
     *
     * @return object {@link DashboardPage}, representing a dashboard page.
     */
    public DashboardPage clickOnMainLogo() {
        FINAL_SURGE_LOGO.click();
        return new DashboardPage();
    }

    /**
     * Clicks on the log out button.
     */
    public void clickLogoutButton() {
        LOGOUT_BUTTON.click();
    }

    /**
     * Goes to the settings page by clicking on the button "Settings".
     *
     * @return object {@link SettingsPage}, representing a settings page
     */
    public SettingsPage goToSettingPage() {
        GO_TO_SETTINGS_BUTTON.shouldBe(Condition.visible).click();
        return new SettingsPage();
    }
}
