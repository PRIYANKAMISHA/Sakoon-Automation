package pages;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.IOException;

public class ClientRegPageUsingExcel extends BasePage {
    public ClientRegPageUsingExcel(WebDriver driver) throws IOException {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Contact us' and @href='#']")
    WebElement ContactUsMenu;


    @FindBy(xpath = "//a[text()='Get Help Now']")
    WebElement GetHelpNow;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement FirstNameField;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement LastNameField;

    @FindBy(xpath = "//input[@name='dob']")
    WebElement Dob;


    @FindBy(xpath = "(//div[@class='nice-select form-control'])[2]")
    WebElement Selectcodedropdown;
    @FindBy(xpath = "//li[@data-value='1' and contains(text(), 'USA')]")
    WebElement SelectUSA;

    @FindBy(xpath = "//input[@id='contact_no']")
    WebElement Phonenumber;

    @FindBy(xpath = "//input[@id='email_id']")
    WebElement Email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement Password;

    @FindBy(xpath = "//input[@id='cnfpassword']")
    WebElement ConfirmPassword;

    @FindBy(xpath = "//input[@id='male']")
    WebElement Gender;

    @FindBy(xpath = "//label[@for='customCheck1']")
    WebElement AgreeCheckbox;

    @FindBy(xpath = "//button[text()='Sign Up']")
    WebElement SignUpButton;

    public void register(String firstName, String lastName, String dob, String contact, String email, String password, String confirmPassword) {
        mouseHover(driver, ContactUsMenu);
        GetHelpNow.click();
        FirstNameField.sendKeys(firstName);
        LastNameField.sendKeys(lastName);
        Dob.sendKeys(dob);
        waitForElementToBeClickable(driver, Selectcodedropdown, 10);
        Selectcodedropdown.click();
        SelectUSA.click();
        waitForElementToBeClickable(driver, Phonenumber, 10);
        Phonenumber.sendKeys(contact);
        Email.sendKeys(email);
        Password.sendKeys(password);
        ConfirmPassword.sendKeys(confirmPassword);
        Gender.click();
        AgreeCheckbox.click();
        SignUpButton.click();
    }
    }
