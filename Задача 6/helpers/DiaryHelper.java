package helpers;

import data.DiaryData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import tests.TestBase;

public class DiaryHelper extends HelperBase{

    public void createDiscussion(DiaryData diaryData) {
        driver.findElement(By.linkText("Все записи")).click();
        driver.findElement(By.id("DiText")).click();
        driver.findElement(By.id("DiText")).sendKeys(diaryData.getText());
        driver.findElement(By.name("Word[]")).click();
        driver.findElement(By.name("Word[]")).sendKeys(diaryData.getTag());
        driver.findElement(By.id("btn_save")).click();
        TestBase.wait(3);
    }
}
