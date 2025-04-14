package tests;

import object.Full;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeleteFullTest extends BaseTest {
    @Test
    public void fullAddDelete() {
        Full full = Full.builder()
                .workoutDate("4/5/2025")
                .workoutTime("06:30 AM")
                .workoutName("")
                .distance("")
                .distType("mi")
                .elevationGain("")
                .elevationLoss("")
                .howFeel("Great")
                .perEffort("5 (Moderate)")
                .build();
        LocalDate date = LocalDate.parse(full.getWorkoutDate(), DateTimeFormatter.ofPattern("M/d/yyyy"));
        String workoutDay = String.valueOf(date.getDayOfMonth());
        newFullAddSteps
                .createFullAdd(full);
        workoutDetailsSteps.isElementVisibleSteps();
        calendarSteps.deleteEventForDay(workoutDay, full.getWorkoutName());
        Assert.assertFalse(calendarSteps.isElementVisibleSteps(workoutDay, full.getWorkoutName()));
    }
}
