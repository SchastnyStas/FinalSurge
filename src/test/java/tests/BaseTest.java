package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.SettingsPage;
import steps.*;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    public static String EMAIL = System.getProperty("email");
    public static String PASSWORD = System.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");

    protected LoginSteps loginSteps;
    protected DashboardSteps dashboardSteps;
    protected NewQuickAddSteps newQuickAddSteps;
    protected CalendarSteps calendarSteps;
    protected NewFullAddSteps newFullAddSteps;
    protected TopNavigationSteps topNavigationSteps;
    protected SettingsNavigateSteps settingsNavigateSteps;
    protected MainLogoNavigateSteps mainLogoNavigateSteps;
    protected CurrentDateSteps currentDateSteps;
    protected ChangeProfileSettingsSteps changeProfileSettingsSteps;
    protected SettingsPage settingsPage;
    protected LogoutSteps logoutSteps;
    protected SendFeedbackSteps sendFeedbackSteps;
    protected CustomerSupportSteps customerSupportSteps;

    public void initPage() {
        loginSteps = new LoginSteps();
        dashboardSteps = new DashboardSteps();
        newQuickAddSteps = new NewQuickAddSteps();
        calendarSteps = new CalendarSteps();
        newFullAddSteps = new NewFullAddSteps();
        topNavigationSteps = new TopNavigationSteps();
        settingsNavigateSteps = new SettingsNavigateSteps();
        mainLogoNavigateSteps = new MainLogoNavigateSteps();
        currentDateSteps = new CurrentDateSteps();
        changeProfileSettingsSteps = new ChangeProfileSettingsSteps();
        settingsPage = new SettingsPage();
        logoutSteps = new LogoutSteps();
        sendFeedbackSteps = new SendFeedbackSteps();
        customerSupportSteps = new CustomerSupportSteps();
    }

    @BeforeMethod
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        // options.addArguments("-headless");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        initPage();
        loginSteps.login(LOGIN_URL, EMAIL, PASSWORD);
    }

    @AfterMethod
    @Step("Close web driver")
    public void endTest() {
        getWebDriver().quit();
    }

    @AfterMethod(onlyForGroups = {"profileImage"})
    @Step("Clean up profile image after test")
    public void cleanUpProfileImage() {
        changeProfileSettingsSteps.refreshEditPage();
        Selenide.sleep(3000);
        changeProfileSettingsSteps.removePicture();
    }
}
