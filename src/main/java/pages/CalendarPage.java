package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import windows.NewQuickAddWindow;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.findElementByClass;
import static elements.ElementExtensions.findElementById;

@Slf4j
public class CalendarPage extends TopNavigationMenu {
    private static final SelenideElement QUICK_ADD_BUTTON = findElementById("QuickAddToggle");
    private static final String EVENT_PRESENT_DETAILS = "//*[@data-day='%s']//*[@data" +
            "-title='%s']";
    private static final SelenideElement FULL_ADD_BUTTON = findElementById("FullAddBtn");
    private static final SelenideElement QUICK_DELETE_BUTTON = findElementByClass("quick-delete");
    private static final SelenideElement QUICK_DELETE_CONFIRM_BUTTON = findElementByClass("btn btn-primary");
    private static final SelenideElement GO_TO_DASHBOARD_BUTTON = $x("//*[@class='icsw16-home']");

    /**
     * Opens the quick add window.
     *
     * @return new {@link NewQuickAddWindow}, representing the quick add window.
     */
    public NewQuickAddWindow goToNewQuickAddWindow() {
        QUICK_ADD_BUTTON.click();
        log.info("Create a new quick window is open.");
        return new NewQuickAddWindow();
    }

    /**
     * Opens the full add window.
     *
     * @return new {@link FullAddPage}, representing the full add window.
     */
    public FullAddPage goToFullAddPage() {
        FULL_ADD_BUTTON.click();
        log.info("User is redirected to full add page.");
        return new FullAddPage();
    }

    /**
     * Checks if an event is present on a specific day in the calendar.
     *
     * @param day   the day to check for the event
     * @param event the name of the event
     * @return {@code true} if the event is displayed for the given day; {@code false} otherwise
     */
    public boolean checkEventIsPresentForDay(String day, String event) {
        log.info("Event '{}' is visible for day: {}", event, day);
        return $x(String.format(EVENT_PRESENT_DETAILS, day, event))
                .isDisplayed();
    }

    /**
     * Deletes an event for a specific day from the calendar.
     *
     * @param day   the day on which the event is scheduled
     * @param event the name of the event to delete
     * @return a new {@link CalendarPage} instance after the event has been deleted
     */
    public CalendarPage deleteEventForDay(String day, String event) {
        SelenideElement eventElement = $x(String.format(EVENT_PRESENT_DETAILS, day, event));
        eventElement.shouldBe(Condition.visible).click();
        QUICK_DELETE_BUTTON.click();
        QUICK_DELETE_CONFIRM_BUTTON.click();
        eventElement.shouldNotBe(Condition.visible);
        log.info("Event '{}' is deleted for day: {}", event, day);
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
        log.info("Dashboard page is open.");
        return new DashboardPage();
    }
}

