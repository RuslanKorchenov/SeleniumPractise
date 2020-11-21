package helpers;

import data.MessageData;
import org.openqa.selenium.By;
import tests.TestBase;

public class SendMessageHelper extends HelperBase {
    public void sendMessage(MessageData messageData) {
        driver.findElement(By.linkText("Сообщить об ошибке")).click();
        TestBase.wait(3);
        driver.findElement(By.cssSelector(".oo-ui-widget:nth-child(2) > .oo-ui-buttonElement-button")).click();
        TestBase.wait(3);
        driver.findElement(By.id("ooui-4")).sendKeys(messageData.getText());
        driver.findElement(By.id("ooui-3")).sendKeys(messageData.getPageName());
        driver.findElement(By.linkText("Отправить")).click();
    }
}
