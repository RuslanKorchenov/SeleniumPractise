package helpers;

import org.openqa.selenium.Dimension;

public class WindowHelper extends HelperBase {
    public void getSite(String link) {
        driver.get(link);
    }

    public void setWinSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }
}
