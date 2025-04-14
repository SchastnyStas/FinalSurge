package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import steps.*;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static String EMAIL = PropertyReader.getProperty("email");
    public static String PASSWORD = PropertyReader.getProperty("password");


    protected LoginSteps loginSteps;
    protected DashboardSteps dashboardSteps;
    protected NewQuickAddSteps newQuickAddSteps;
    protected CalendarSteps calendarSteps;
    protected NewFullAddSteps newFullAddSteps;
    protected WorkoutDetailsSteps workoutDetailsSteps;

    public void initPage() {

        loginSteps = new LoginSteps();
        dashboardSteps = new DashboardSteps();
        newQuickAddSteps = new NewQuickAddSteps();
        calendarSteps = new CalendarSteps();
        newFullAddSteps = new NewFullAddSteps();
        workoutDetailsSteps = new WorkoutDetailsSteps();
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
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPage();
        loginSteps.login(LOGIN_URL, EMAIL, PASSWORD);
    }

//    @AfterMethod
//    public void endTest() {
//        getWebDriver().quit();
//    }
}
