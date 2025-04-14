package tests;

import object.Full;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewFullAddTest extends BaseTest {

    @Test
    public void fullAddCreate() {
        Full full = Full.builder()
                .workoutDate("4/10/2025")
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
        Assert.assertTrue(calendarSteps.isElementVisibleSteps(workoutDay, full.getWorkoutName()));
    }
}
