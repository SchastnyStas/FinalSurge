package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import windows.NewQuickAddWindow;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.findElementByClass;
import static elements.ElementExtensions.findElementById;

public class CalendarPage extends TopNavigationMenu {
    private static final SelenideElement QUICK_ADD_BUTTON = findElementById("QuickAddToggle");
    private static final String EVENT_PRESENT_DETAILS = "//*[@data-day='%s']//*[@data" +
            "-title='%s']";
    private static final SelenideElement FULL_ADD_BUTTON = findElementById("FullAddBtn");
    private static final SelenideElement QUICK_DELETE_BUTTON = findElementByClass("quick-delete");
    private static final SelenideElement QUICK_DELETE_CONFIRM_BUTTON = findElementByClass("btn btn-primary");
    private static final SelenideElement GO_TO_DASHBOARD_BUTTON = $x("//*[@class='icsw16-home']");

    public NewQuickAddWindow goToNewQuickAddWindow() {
        QUICK_ADD_BUTTON.click();
        return new NewQuickAddWindow();
    }

    public FullAddPage goToFullAddPage() {
        FULL_ADD_BUTTON.click();
        return new FullAddPage();
    }

    public boolean checkEventIsPresentForDay(String day, String event) {
        return $x(String.format(EVENT_PRESENT_DETAILS, day, event))
                .isDisplayed();
    }

    public CalendarPage deleteEventForDay(String day, String event) {
        SelenideElement eventElement = $x(String.format(EVENT_PRESENT_DETAILS, day, event));
        eventElement.shouldBe(Condition.visible).click();
        QUICK_DELETE_BUTTON.click();
        QUICK_DELETE_CONFIRM_BUTTON.click();
        eventElement.shouldNotBe(Condition.visible);
        return new CalendarPage();
    }


    /**
     * Clicks on the dashboard page button
     * and opens the dashboard page.
     *
     * @return new {@link DashboardPage}, representing a dashboard page.
     */
    public DashboardPage goToDashboardPage() {
        GO_TO_DASHBOARD_BUTTON.scrollIntoCenter().click();
        return new DashboardPage();
    }
}

