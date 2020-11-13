package tests;

import helpers.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TestBase {
    protected ApplicationManager applicationManager;

    public void setupTest()
    {
        applicationManager = new ApplicationManager();
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
