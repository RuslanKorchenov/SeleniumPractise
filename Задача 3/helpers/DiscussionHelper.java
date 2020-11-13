package helpers;

import data.DiscussionData;
import org.openqa.selenium.By;
import tests.TestBase;

public class DiscussionHelper extends HelperBase{

    public void createDiscussion(DiscussionData discussionData) {
        driver.findElement(By.linkText("Обсуждение")).click();
        TestBase.wait(3);
        driver.findElement(By.cssSelector("#ca-addsection > a")).click();
        driver.findElement(By.id("wpSummary")).click();
        driver.findElement(By.id("wpSummary")).sendKeys("Привет друг!");
        driver.findElement(By.id("wpTextbox1")).click();
        driver.findElement(By.id("wpTextbox1")).click();
        driver.findElement(By.id("wpTextbox1")).sendKeys("Моя тема");
        driver.findElement(By.id("wpSave")).click();
        TestBase.wait(3);
    }
}
