package tests;

import object.Quick;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeleteQuickTest extends BaseTest{

    @Test
    public void quickAddDelete() {
        Quick quick = Quick.builder()
                .workoutDate("4/11/2025")
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
        workoutDetailsSteps.isElementVisibleSteps();
        calendarSteps.deleteEventForDay(workoutDay, quick.getWorkoutName());
        Assert.assertFalse(calendarSteps.isElementVisibleSteps(workoutDay, quick.getWorkoutName()));
    }
}
