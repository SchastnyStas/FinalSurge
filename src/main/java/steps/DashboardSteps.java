package steps;

import io.qameta.allure.Step;

public class DashboardSteps extends BaseSteps {

    @Step("Check event is displayed in upcoming workouts")
    public boolean isEventVisibleInUpcomingWorkout(String workoutName) {
        calendarPage.goToDashboardPage();
        return dashboardPage.checkUpcomingWorkoutsVisible(workoutName);
    }

    @Step("Check event is displayed in recent past workouts")
    public boolean isEventVisibleInRecentPastWorkout(String workoutName) {
        calendarPage.goToDashboardPage();
        return dashboardPage.openRecentPastWorkoutsList(workoutName);
    }
}
