package helpers;

import data.DiaryData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import tests.TestBase;

public class RefactorHelper  extends HelperBase{
    public void doRefactor(DiaryData diaryData) {
        TestBase.wait(2);
        driver.findElement(By.linkText("Все записи")).click();
        driver.findElement(By.linkText("Править")).click();
        if (diaryData.getText() != null)
        {
            driver.findElement(By.id("DiText")).click();
            driver.findElement(By.id("DiText")).sendKeys(diaryData.getText());
        }
        if (diaryData.getTag() != null)
        {
            driver.findElement(By.name("Word[]")).click();
            driver.findElement(By.name("Word[]")).sendKeys(diaryData.getTag());
        }
        driver.findElement(By.id("btn_save")).click();
        TestBase.wait(2);
    }
}
