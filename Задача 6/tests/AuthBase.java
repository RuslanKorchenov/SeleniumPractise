package tests;

import data.AccountData;

public class AuthBase extends TestBase {
    @Override
    protected void setupTest() {
        super.setupTest();
        AccountData accountData = new AccountData(settingsData.getUsername(), settingsData.getPassword());
        applicationManager.getWindowHelper().getSite(settingsData.getSite());
        applicationManager.getWindowHelper().setWinSize(Integer.parseInt(settingsData.getWidth()), Integer.parseInt(settingsData.getHeight()));
        applicationManager.getLoginHelper().login(accountData);
    }
}
