package steps;

import pages.CalendarPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.WorkoutDetailsPage;

public class BaseSteps{
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    //protected NewQuickAddSteps newQuickAddSteps;
    protected CalendarPage calendarPage;
    protected WorkoutDetailsPage workoutDetailsPage;

    public BaseSteps() {
        this.loginPage = new LoginPage();
        this.dashboardPage = new DashboardPage();
       // this.newQuickAddSteps = new NewQuickAddSteps();
        this.calendarPage = new CalendarPage();
        this.workoutDetailsPage = new WorkoutDetailsPage();
    }

}
