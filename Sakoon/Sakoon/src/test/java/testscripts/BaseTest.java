package testscripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        if (BasePage.getValue("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (BasePage.getValue("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Please enter either chrome/ firefox");
        }
        driver.manage().window().maximize();
        driver.get(BasePage.getValue("url"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    //@AfterClass
    public void tearDown() {
        driver.quit();
    }

}
