import io.appium.java_client.windows.WindowsDriver;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    private static WindowsDriver driver = null;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown()
    {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    @Before
    public void clear() {
        driver.findElementByName("Clear").click();
        Assert.assertEquals(Integer.toString(0), getResult());
    }

    @Test
    public void addition() {
        driver.findElementByName("Eight").click();
        driver.findElementByName("Eight").click();
        driver.findElementByName("Plus").click();
        driver.findElementByName("Nine").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals(Integer.toString(88 + 9), getResult());
    }

    @Test
    public void subtraction() {
        driver.findElementByName("Seven").click();
        driver.findElementByName("Minus").click();
        driver.findElementByName("Zero").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals(Integer.toString(7), getResult());
    }

    @Test
    public void division() {
        driver.findElementByName("One").click();
        driver.findElementByName("Two").click();
        driver.findElementByName("Five").click();
        driver.findElementByName("Divide by").click();
        driver.findElementByName("Two").click();
        driver.findElementByName("Five").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals(Integer.toString(125 / 25), getResult());
    }

    @Test
    public void multiplication() {
        driver.findElementByName("Nine").click();
        driver.findElementByName("Multiply by").click();
        driver.findElementByName("Nine").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals(Integer.toString(9 * 9), getResult());
    }

    @Test
    public void combination() {
        driver.findElementByName("Nine").click();
        driver.findElementByName("Multiply by").click();
        driver.findElementByName("Nine").click();
        driver.findElementByName("Plus").click();
        driver.findElementByName("One").click();
        driver.findElementByName("Two").click();
        driver.findElementByName("Three").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals(Integer.toString(9 * 9 + 123), getResult());
    }

    protected String getResult() {
        return driver.findElementByAccessibilityId("CalculatorResults").getText().replace("Display is", "").trim();
    }
}
