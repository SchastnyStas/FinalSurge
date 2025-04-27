package tests;

import enums.DistType;
import enums.HowFeel;
import enums.PerceivedEffort;
import object.Quick;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;

import static tests.TestConstants.DATE_TIME_FORMATTER;

public class WorkoutListTest extends BaseTest {

    @Test(description = "Check event is displayed in recent past workouts")
    public void checkRecentWorkouts() {
        SoftAssert softAssert = new SoftAssert();
        Quick quick = Quick.builder()
                .workoutDate("4/10/2025")
                .workoutTime("12:00 PM")
                .activityType("Run")
                .workoutName("")
                .distance("")
                .distType(DistType.YD)
                .howFeel(HowFeel.TERRIBLE)
                .perEffort(PerceivedEffort.TENMAXEFFORT)
                .build();
        LocalDate date = LocalDate.parse(quick.getWorkoutDate(), DATE_TIME_FORMATTER);
        String workoutDay = String.valueOf(date.getDayOfMonth());

        newQuickAddSteps.createNewQuick(quick);
        softAssert.assertTrue(dashboardSteps.isEventVisibleInRecentPastWorkout(quick.getWorkoutName()));
        topNavigationSteps.goToCalendarSteps();
        calendarSteps.deleteEventForDay(workoutDay, quick.getWorkoutName()).goToDashboardPage();
        softAssert.assertFalse(dashboardSteps.isEventVisibleInRecentPastWorkout(quick.getWorkoutName()));
        softAssert.assertAll();
    }

    @Test(description = "Check event is displayed in upcoming workouts")
    public void checkUpcomingWorkouts() {
        SoftAssert softAssert = new SoftAssert();
        Quick quick = Quick.builder()
                .workoutDate("4/30/2025")
                .workoutTime("12:00 PM")
                .activityType("Run")
                .workoutName("")
                .distance("")
                .distType(DistType.M)
                .howFeel(HowFeel.POOR)
                .perEffort(PerceivedEffort.ONEVERYLIGHT)
                .build();
        LocalDate date = LocalDate.parse(quick.getWorkoutDate(), DATE_TIME_FORMATTER);
        String workoutDay = String.valueOf(date.getDayOfMonth());

        newQuickAddSteps.createNewQuick(quick);
        softAssert.assertTrue(dashboardSteps.isEventVisibleInUpcomingWorkout(quick.getWorkoutName()));
        topNavigationSteps.goToCalendarSteps();
        calendarSteps.deleteEventForDay(workoutDay, quick.getWorkoutName()).goToDashboardPage();
        softAssert.assertFalse(dashboardSteps.isEventVisibleInUpcomingWorkout(quick.getWorkoutName()));
        softAssert.assertAll();
    }
}