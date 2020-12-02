package tests;

import helpers.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import settings.Settings;
import settings.SettingsData;

public class TestBase {
    protected ApplicationManager applicationManager;
    protected SettingsData settingsData;
    protected void setupTest()
    {
        applicationManager = ApplicationManager.getInstance();
        settingsData = new Settings().readDataXML();
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}