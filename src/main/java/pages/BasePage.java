package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.getElementByHref;

public class BasePage {
    private static final SelenideElement FINAL_SURGE_LOGO = $x("//*[@class='main-logo']//img");
    private static final SelenideElement LOGOUT_BUTTON = getElementByHref("logout.cshtml");
    private static final SelenideElement GO_TO_SETTINGS_BUTTON = getElementByHref("UserProfile.cshtml");

    public DashboardPage clickOnMainLogo() {
        FINAL_SURGE_LOGO.click();
        return new DashboardPage();
    }

    public void clickLogoutButton() {
        LOGOUT_BUTTON.click();
    }

    public SettingsPage goToSettingPage() {
        GO_TO_SETTINGS_BUTTON.shouldBe(Condition.visible).click();
        return new SettingsPage();
    }
}
