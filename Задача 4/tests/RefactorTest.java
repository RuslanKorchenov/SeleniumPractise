package tests;

import data.AccountData;
import data.DiaryData;
import org.junit.After;
import org.junit.Test;

public class RefactorTest extends TestBase {
    @Test
    public void refactorTest() {
        setupTest();
        AccountData accountData = new AccountData("ruselkomp", "qwerty123");
        DiaryData diaryData = new DiaryData("Привет", "Привет хотел сказать");
        applicationManager.getWindowHelper().getSite("https://diary.anek.ws/");
        applicationManager.getWindowHelper().setWinSize(1936, 1056);
        applicationManager.getLoginHelper().login(accountData);
        applicationManager.getRefactorHelper().doRefactor(diaryData);
        applicationManager.getLoginHelper().logout();
        applicationManager.stop();
    }
}
