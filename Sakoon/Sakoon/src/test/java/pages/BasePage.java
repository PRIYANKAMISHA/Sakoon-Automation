package pages;

import com.github.javafaker.Faker;
import org.ini4j.Ini;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.faker = new Faker(new Locale("en-IND"));
        PageFactory.initElements(driver, this);
    }

    public static String getValue(String key) {
        String path = System.getProperty("user.dir") + File.separator + "config.properties";
        String value = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void takeScreenshot(WebDriver driver) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File("./screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }

    public static void mouseHover(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public static void click(WebDriver driver, WebElement element) {
        new Actions(driver).click(element).perform();
    }

    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static void sendTextToAlert(WebDriver driver, String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public static void selectByText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }
 
    public static void selectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    public static void scroll(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollByPixels(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


    public String generateFirstName() {
        String firstName = faker.name().firstName(); // Declare and assign the variable
        System.out.println("Generated First Name: " + firstName);
        return firstName;
    }
    public String generateLastName() {
        String lastName = faker.name().lastName();
        System.out.println("Generated Last Name: " + lastName);
        return lastName;

    }
    public String generateDOB() {
        String dob = "10/05/1995";
        System.out.println("Generated DOB: " + dob);
        return dob;
    }
    public String generatePhoneNumber() {
        String phoneNumber = faker.number().digits(10);
        System.out.println("Generated Phone Number: " + phoneNumber);
        return phoneNumber;
    }
   /* public String generatePassword() {
        String password = faker.internet().password(8, 15);
        System.out.println("Generated Password: " + password);
        return password;
    }

    */
   public String generatePassword() {
       String password = "admin12345"; // Fixed password for all users
       System.out.println("Generated Password: " + password);
       return password;
   }
    public String generateEmail() {
        String email = faker.name().firstName().toLowerCase() + faker.number().digits(3) + "@yopmail.com";
        System.out.println("Generated Email: " + email);
        return email;
    }


    public void waitElement(long sec) {
        try {
            Thread.sleep(sec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementVisible(WebDriver driver, int sec, WebElement element) {
        new WebDriverWait(driver, sec).until(ExpectedConditions.visibilityOf(element));
    }

    public static String getValue(String header, String key) {
        String path = System.getProperty("user.dir") + File.separator + "TestData.ini";
        String value = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            Ini prop = new Ini();
            prop.load(fis);
            value = prop.get(header, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }
}


