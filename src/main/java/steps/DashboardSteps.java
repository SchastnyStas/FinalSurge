package steps;

import io.qameta.allure.Step;

public class DashboardSteps extends BaseSteps {
    @Step("Check out the event in the upcoming workout")
    public boolean isEventVisibleInUpcomingWorkout(String workoutName) {
        calendarPage.goToDashboardPage();
        return dashboardPage.openUpcomingWorkoutsList(workoutName);
    }

    @Step("Check out the event in the recent past workout")
    public boolean isEventVisibleInRecentPastWorkout(String workoutName) {
        calendarPage.goToDashboardPage();
        return dashboardPage.openRecentPastWorkoutsList(workoutName);
    }
}
