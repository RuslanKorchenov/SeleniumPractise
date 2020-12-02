package tests;

import data.AccountData;
import org.junit.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginWithValidData() {
        setupTest();
        AccountData accountData = new AccountData(settingsData.getUsername(), settingsData.getPassword());
        applicationManager.getWindowHelper().getSite(settingsData.getSite());
        applicationManager.getWindowHelper().setWinSize(Integer.parseInt(settingsData.getWidth()), Integer.parseInt(settingsData.getHeight()));
        applicationManager.getLoginHelper().login(accountData);
        boolean result = applicationManager.getLoginHelper().isLoggedIn();
        applicationManager.getLoginHelper().logout();
        assert result;
    }

    @Test
    public void loginWithInvalidData() {
        setupTest();
        AccountData accountData = new AccountData("invalid", "data");
        applicationManager.getWindowHelper().getSite(settingsData.getSite());
        applicationManager.getWindowHelper().setWinSize(Integer.parseInt(settingsData.getWidth()), Integer.parseInt(settingsData.getHeight()));
        applicationManager.getLoginHelper().login(accountData);
        assert !applicationManager.getLoginHelper().isLoggedIn();
    }
}
