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
    JavascriptExecutor js;

    private LoginHelper loginHelper;
    private DiscussionHelper discussionHelper;
    private SendMessageHelper sendMessageHelper;
    private WindowHelper windowHelper;

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
        discussionHelper = new DiscussionHelper();
        sendMessageHelper = new SendMessageHelper();
        windowHelper = new WindowHelper();

        setDrivers();
    }


    public WebDriver getDriver() {
        return driver;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public DiscussionHelper getDiscussionHelper() {
        return discussionHelper;
    }

    public SendMessageHelper getSendMessageHelper() {
        return sendMessageHelper;
    }

    public void tearDown() {
        driver.quit();
    }

    private void setDrivers() {
        loginHelper.setDriver(driver);
        windowHelper.setDriver(driver);
        sendMessageHelper.setDriver(driver);
        discussionHelper.setDriver(driver);
    }

}
