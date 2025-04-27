package steps;

import pages.*;

public class BaseSteps {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected CalendarPage calendarPage;
    protected TopNavigationMenu topNavigationMenu;
    protected SettingsPage settingsPage;
    protected EditProfilePage editProfilePage;
    protected LogoutPage logoutPage;
    protected FeedbackPage feedbackPage;
    protected CustomerSupportPage customerSupportPage;

    public BaseSteps() {
        this.loginPage = new LoginPage();
        this.dashboardPage = new DashboardPage();
        this.calendarPage = new CalendarPage();
        this.topNavigationMenu = new TopNavigationMenu();
        this.settingsPage = new SettingsPage();
        this.editProfilePage = new EditProfilePage();
        this.logoutPage = new LogoutPage();
        this.feedbackPage = new FeedbackPage();
        this.customerSupportPage = new CustomerSupportPage();
    }
}
