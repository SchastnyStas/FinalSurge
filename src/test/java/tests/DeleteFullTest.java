package tests;

import object.Full;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeleteFullTest extends BaseTest {

    @Test
    public void fullAddDelete() {
        SoftAssert softAssert = new SoftAssert();
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
                .addNewFull(full);
        workoutDetailsSteps.isElementVisibleSteps();
        calendarSteps.deleteEventForDay(workoutDay, full.getWorkoutName());
        softAssert.assertFalse(calendarSteps.isElementVisibleSteps(workoutDay, full.getWorkoutName()));
        softAssert.assertAll();
    }
}
