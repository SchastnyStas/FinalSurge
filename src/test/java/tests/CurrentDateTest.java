package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CurrentDateTest extends BaseTest {

    @Test
    public void isDateDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        String dateText = currentDateSteps.isDateDisplayedSteps();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
        LocalDate parsedDate = LocalDate.parse(dateText, formatter);
        LocalDate today = LocalDate.now();
        softAssert.assertEquals(today, parsedDate, "The date on the page does not match the " +
                "current one");
        softAssert.assertAll();
    }
}
