package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.SettingsPage;
import steps.*;
import utils.DataGenerator;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    public static String LOGIN_URL;
    public static String EMAIL;
    public static String PASSWORD;

    protected LoginSteps loginSteps;
    protected DashboardSteps dashboardSteps;
    protected NewQuickAddSteps newQuickAddSteps;
    protected CalendarSteps calendarSteps;
    protected NewFullAddSteps newFullAddSteps;
    protected TopNavigationSteps workoutDetailsSteps;
    protected SettingsNavigateSteps settingsNavigateSteps;
    protected MainLogoNavigateSteps mainLogoNavigateSteps;
    protected CurrentDateSteps currentDateSteps;
    protected ChangeProfileSettingsSteps changeProfileSettingsSteps;
    protected DataGenerator dataGenerator;
    protected SettingsPage settingsPage;
    protected LogoutSteps logoutSteps;
    protected SendFeedbackSteps sendFeedbackSteps;
    protected CustomerSupportSteps customerSupportSteps;

    @BeforeSuite
    public void updateConfigFile() {
        String email = System.getProperty("email");
        String password = System.getProperty("password");
        String path = "src/test/resources/config.properties";
        PropertyReader.writePropertiesToFile(email, password, path);
        LOGIN_URL = PropertyReader.getProperty("loginUrl");
        EMAIL = email;
        PASSWORD = password;
    }

    public void initPage() {

        loginSteps = new LoginSteps();
        dashboardSteps = new DashboardSteps();
        newQuickAddSteps = new NewQuickAddSteps();
        calendarSteps = new CalendarSteps();
        newFullAddSteps = new NewFullAddSteps();
        workoutDetailsSteps = new TopNavigationSteps();
        settingsNavigateSteps = new SettingsNavigateSteps();
        mainLogoNavigateSteps = new MainLogoNavigateSteps();
        currentDateSteps = new CurrentDateSteps();
        changeProfileSettingsSteps = new ChangeProfileSettingsSteps();
        dataGenerator = new DataGenerator();
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
        Configuration.headless = false;
        initPage();
        loginSteps.login(LOGIN_URL, EMAIL, PASSWORD);
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}
