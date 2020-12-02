package helpers;

import data.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.TestBase;

public class LoginHelper extends HelperBase {

    public void login(AccountData accountData) {
        if (isLoggedIn()) {
            if (isLoggedIn(accountData.getUsername()))
                return;
            logout();
        }
        driver.findElement(By.id("Nik")).click();
        driver.findElement(By.id("Nik")).sendKeys(accountData.getUsername());
        driver.findElement(By.id("Password")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("login_subm")).click();
        TestBase.wait(3);
    }

    public void logout() {
        driver.findElement(By.linkText("Выйти")).click();
    }

    public boolean isLoggedIn() {
        return driver.findElements(By.linkText("Выйти")).size() > 0;

    }

    public boolean isLoggedIn(String name) {
        return driver.findElement(By.id("author")).getText().equals(name);
    }


}
