package helpers;

import data.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import tests.TestBase;

public class LoginHelper extends HelperBase {

    public void login(AccountData accountData) {
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("wpName1")).click();
        driver.findElement(By.cssSelector(".mw-htmlform-field-HTMLTextField:nth-child(1)")).click();
        driver.findElement(By.id("wpName1")).click();
        driver.findElement(By.id("wpName1")).sendKeys(accountData.getUsername());
        driver.findElement(By.id("wpPassword1")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("wpPassword1")).sendKeys(Keys.ENTER);
        TestBase.wait(3);
    }
    public void logout() {
        TestBase.wait(3);
        driver.findElement(By.linkText("Выйти")).click();
    }



}
