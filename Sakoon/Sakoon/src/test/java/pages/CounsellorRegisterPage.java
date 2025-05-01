package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CounsellorRegisterPage extends BasePage {
    public static String generatedEmail;
    public static String generatedPassword = "admin12345";
    public CounsellorRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Join Us']")
    WebElement JoinUs;
    @FindBy(xpath = "//a[text()='Vacancies']")
    WebElement Vacancies;
    @FindBy (xpath = "//input[@name='first_name']")
    WebElement FirstName;

    @FindBy(xpath = "//input[@name='last_name']\n")
    WebElement LastName;
    @FindBy(xpath = "//input[@id='dobd']")
    WebElement DOB;

    @FindBy(xpath = "//span[text()='Phone code']")
    WebElement Phonecode;

    @FindBy(xpath = "//li[@data-value='1']")
    WebElement SelectUSA;
    @FindBy(xpath = "//input[@name='contact_no']")
    WebElement PhoneNumber;

    @FindBy(id = "email_id")
    WebElement Email;

    @FindBy(xpath = "//input[@placeholder='I Work With']")
    WebElement Selectwork;

    @FindBy(xpath = "//select[@id='multiple']//option[@value='Males']")
    WebElement MaleFemale;

    @FindBy(xpath = "//input[@name='password']")
    WebElement Password;

    @FindBy(xpath = "//input[@name='confirm_password']")
 WebElement ConfirmPassword;

    @FindBy(xpath = "//input[@name='gender']")
    WebElement Gender;

    @FindBy(xpath = "//input[@name='language[]']")
    WebElement Language;
    @FindBy(xpath = "//input[@name='support_with[]'][@value='1']")
    WebElement Video;

    @FindBy(xpath = "//input[@name='support_with[]'][@value='0']")
    WebElement Phone;

    @FindBy(xpath = "//label[text()='I agree to Sakoon.']")
    WebElement AgreeCheckbox;
    @FindBy(xpath = "//button[text()=\"Sign Up\"]")
    WebElement SignUpButton;

    public void registerCounsellor() {
        mouseHover(driver, JoinUs);
        Vacancies.click();
        FirstName.sendKeys(generateFirstName());
        LastName.sendKeys(generateLastName());
        DOB.sendKeys(generateDOB());
        Phonecode.click();
        SelectUSA.click();
        PhoneNumber.sendKeys(generatePhoneNumber());
        generatedEmail = generateEmail();
        Email.sendKeys(generatedEmail);

       // MaleFemale.click();
        String generatedPassword = generatePassword(); // Store password for confirmation
        Password.sendKeys(generatedPassword);
        ConfirmPassword.sendKeys(generatedPassword);
        Gender.click();

        Language.click();
        Video.click();
        Phone.click();
        AgreeCheckbox.click();
        waitForElementToBeClickable(driver, SignUpButton, 10);
        SignUpButton.click();
    }
    public String generateEmail() {
        // You can use Faker library to generate a fake email address here
        return "user" + System.currentTimeMillis() + "@yopmail.com";
    }


}
