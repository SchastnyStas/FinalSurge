package tests;

import enums.DistType;
import enums.HowFeel;
import enums.PerceivedEffort;
import object.Full;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FullWorkoutTest extends BaseTest {

    @Test(testName = "Check full workout event can be created and displayed for day")
    public void fullAddCreate() {
        Full full = Full.builder()
                .workoutDate("4/10/2025")
                .workoutTime("06:30 AM")
                .workoutName("")
                .distance("")
                .distType(DistType.MI)
                .elevationGain("")
                .elevationLoss("")
                .howFeel(HowFeel.GOOD)
                .perEffort(PerceivedEffort.FIVEMODERATE)
                .build();
        LocalDate date = LocalDate.parse(full.getWorkoutDate(), DateTimeFormatter.ofPattern("M/d/yyyy"));
        String workoutDay = String.valueOf(date.getDayOfMonth());
        newFullAddSteps.addNewFull(full);
        workoutDetailsSteps.isElementVisibleSteps();
        Assert.assertTrue(calendarSteps.isElementVisibleSteps(workoutDay, full.getWorkoutName()));
        calendarSteps.deleteEventForDay(workoutDay, full.getWorkoutName());
    }

    @Test(testName = "Delete full workout event for the day and check it's not displayed")
    public void fullAddDelete() {
        Full full = Full.builder()
                .workoutDate("4/5/2025")
                .workoutTime("06:30 AM")
                .workoutName("")
                .distance("")
                .distType(DistType.MI)
                .elevationGain("")
                .elevationLoss("")
                .howFeel(HowFeel.GREAT)
                .perEffort(PerceivedEffort.THREELIGHT)
                .build();
        LocalDate date = LocalDate.parse(full.getWorkoutDate(), DateTimeFormatter.ofPattern("M/d/yyyy"));
        String workoutDay = String.valueOf(date.getDayOfMonth());
        newFullAddSteps.addNewFull(full);
        workoutDetailsSteps.isElementVisibleSteps();
        calendarSteps.deleteEventForDay(workoutDay, full.getWorkoutName());
        Assert.assertFalse(calendarSteps.isElementVisibleSteps(workoutDay, full.getWorkoutName()));
    }
}
