package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tests.TestBase;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    private WebDriver driver;
    private Map<String, Object> vars;
    private TestBase defaultClass;
    private JavascriptExecutor js;

    private LoginHelper loginHelper;
    private DiaryHelper diaryHelper;
    private WindowHelper windowHelper;
    private RefactorHelper refactorHelper;
    private static ApplicationManager app = new ApplicationManager();
    public static ApplicationManager getInstance()
    {
        if (app == null)
        {
            app = new ApplicationManager();;
        }
        return app;
    }
    public WindowHelper getWindowHelper() {
        return windowHelper;
    }

    public ApplicationManager() {
        System.setProperty("webdriver.firefox.bin",
                "D:\\Mozilla\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rusel\\IdeaProjects\\Tests\\geckodriver.exe");

        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        loginHelper = new LoginHelper();
        diaryHelper = new DiaryHelper();
        windowHelper = new WindowHelper();
        refactorHelper = new RefactorHelper();
        setDrivers();
    }


    public WebDriver getDriver() {
        return driver;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public DiaryHelper getDiaryHelper() {
        return diaryHelper;
    }

    public RefactorHelper getRefactorHelper() { return refactorHelper; }


    public void tearDown() {
        driver.quit();
    }

    private void setDrivers() {
        loginHelper.setDriver(driver);
        windowHelper.setDriver(driver);
        diaryHelper.setDriver(driver);
        refactorHelper.setDriver(driver);
    }

    public JavascriptExecutor getJs() {
        return js;
    }
    public void stop() {
        try {
            driver.quit();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
