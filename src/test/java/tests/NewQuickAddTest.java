package tests;

import object.Quick;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewQuickAddTest extends BaseTest {
    @Test
    public void quickAddCreate() {
        Quick quick = Quick.builder()
                .workoutDate("4/17/2025")
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
        Assert.assertTrue(calendarSteps.isElementVisibleSteps(workoutDay, quick.getWorkoutName()));
    }
}
