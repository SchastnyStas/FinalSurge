package tests;

import object.Quick;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecentPastWorkoutsTest extends BaseTest {

    @Test
    public void quickAddCreate() {
        SoftAssert softAssert = new SoftAssert();
        Quick quick = Quick.builder()
                .workoutDate("4/10/2025")
                .workoutTime("12:00 PM")
                .activityType("Run")
                .workoutName("")
                .distance("")
                .distType("km")
                .howFeel("Good")
                .perEffort("7 (Hard)")
                .build();

        LocalDate date = LocalDate.parse(quick.getWorkoutDate(), DateTimeFormatter.ofPattern("M/d" +
                "/yyyy"));
        String workoutDay = String.valueOf(date.getDayOfMonth());

        newQuickAddSteps
                .createNewQuick(quick);
        softAssert.assertTrue(dashboardSteps.isEventVisibleInRecentPastWorkout(quick.getWorkoutName()));
        workoutDetailsSteps.isElementVisibleSteps();
        calendarSteps.deleteEventForDay(workoutDay, quick.getWorkoutName()).goToDashboardPage();
        softAssert.assertFalse(dashboardSteps.isEventVisibleInRecentPastWorkout(quick.getWorkoutName()));
        softAssert.assertAll();
    }
}