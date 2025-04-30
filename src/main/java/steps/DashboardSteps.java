package steps;

import io.qameta.allure.Step;

public class DashboardSteps extends BaseSteps {

    @Step("Check event: {workoutName} is displayed in upcoming workouts")
    public boolean isEventVisibleInUpcomingWorkout(String workoutName) {
        calendarPage.goToDashboardPage();
        return dashboardPage.checkUpcomingWorkoutsVisible(workoutName);
    }

    @Step("Check event: {workoutName} is displayed in recent past workouts")
    public boolean isEventVisibleInRecentPastWorkout(String workoutName) {
        calendarPage.goToDashboardPage();
        return dashboardPage.openRecentPastWorkoutsList(workoutName);
    }
}
