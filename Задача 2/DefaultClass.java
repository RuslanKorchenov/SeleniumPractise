import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DefaultClass {
    private WebDriver driver;

    public DefaultClass(WebDriver driver) {
        this.driver = driver;
    }

    public void getSite(String link) {
        driver.get(link);
    }

    public void setWinSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void login(AccountData accountData) {
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("wpName1")).click();
        driver.findElement(By.cssSelector(".mw-htmlform-field-HTMLTextField:nth-child(1)")).click();
        driver.findElement(By.id("wpName1")).click();
        driver.findElement(By.id("wpName1")).sendKeys(accountData.getUsername());
        driver.findElement(By.id("wpPassword1")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("wpPassword1")).sendKeys(Keys.ENTER);
        wait(3);
    }
    public void doExit() {
        wait(3);
        driver.findElement(By.linkText("Выйти")).click();
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
