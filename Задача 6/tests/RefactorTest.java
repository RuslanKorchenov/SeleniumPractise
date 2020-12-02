package tests;

import data.AccountData;
import data.DiaryData;
import org.junit.After;
import org.junit.Test;

public class RefactorTest extends AuthBase {
    @Test
    public void refactorTest() {
        setupTest();
        DiaryData diaryData = new DiaryData("Привет", "Привет хотел сказать");
        applicationManager.getRefactorHelper().doRefactor(diaryData);
        applicationManager.getLoginHelper().logout();
        applicationManager.stop();
    }
}
