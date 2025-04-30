package tests;

import enums.DistType;
import enums.HowFeel;
import enums.PerceivedEffort;
import object.Quick;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuickWorkoutTest extends BaseTest {
    Quick quick;
    LocalDate date;
    String workoutDay;

    @Test(description = "Check quick workout event can be created and displayed for day")
    public void quickAddCreate() {
        quick = Quick.builder()
                .workoutDate("4/17/2025")
                .workoutTime("12:00 PM")
                .activityType("Run")
                .workoutName("")
                .distance("")
                .distType(DistType.KM)
                .howFeel(HowFeel.GOOD)
                .perEffort(PerceivedEffort.FOURMODERATE)
                .build();
        date = LocalDate.parse(quick.getWorkoutDate(), DateTimeFormatter.ofPattern("M/d" +
                "/yyyy"));
        workoutDay = String.valueOf(date.getDayOfMonth());

        newQuickAddSteps.createNewQuick(quick);
        Assert.assertTrue(calendarSteps.isElementVisibleSteps(workoutDay, quick.getWorkoutName()));
    }

    @AfterMethod(groups = "quickAddCreate")
    public void deleteEventForToday() {
        calendarSteps.deleteEventForDay(workoutDay, quick.getWorkoutName());
    }

    @Test(description = "Delete quick workout event for the day and check it's not displayed")
    public void quickAddDelete() {
        Quick quick = Quick.builder()
                .workoutDate("4/11/2025")
                .workoutTime("12:00 PM")
                .activityType("Run")
                .workoutName("")
                .distance("")
                .distType(DistType.KM)
                .howFeel(HowFeel.NORMAL)
                .perEffort(PerceivedEffort.FIVEMODERATE)
                .build();
        LocalDate date = LocalDate.parse(quick.getWorkoutDate(), DateTimeFormatter.ofPattern("M/d" +
                "/yyyy"));
        String workoutDay = String.valueOf(date.getDayOfMonth());

        newQuickAddSteps.createNewQuick(quick);
        topNavigationSteps.goToCalendarSteps();
        calendarSteps.deleteEventForDay(workoutDay, quick.getWorkoutName());
        Assert.assertFalse(calendarSteps.isElementVisibleSteps(workoutDay, quick.getWorkoutName()));
    }
}
