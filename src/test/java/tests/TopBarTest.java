package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TopBarTest extends BaseTest {

    @Test(testName = "Go to dashboard page via main logo and check if page is loaded")
    public void navigationByMainLogo() {
        Assert.assertTrue(mainLogoNavigateSteps.goToDashboardPageAndCheck());
    }

    @Test(testName = "Go to settings pages and check if page is loaded")
    public void goToSettingPage() {
        //loginSteps.isElementVisibleCalendarButton();
        Assert.assertTrue(settingsNavigateSteps.goToSettingsPageAndCheck());
    }

    @Test(testName = "Check that the current date is displayed in top bar")
    public void isDateDisplayed() {
        String dateText = currentDateSteps.getDisplayedDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
        LocalDate parsedDate = LocalDate.parse(dateText, formatter);
        LocalDate today = LocalDate.now();
        Assert.assertEquals(today, parsedDate, "The date on the page does not match the " +
                "current one");
    }
}
