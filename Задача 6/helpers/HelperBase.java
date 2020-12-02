package helpers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class HelperBase {
    protected WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
