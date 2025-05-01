package testscripts;

import org.testng.annotations.Test;
import pages.CounsellorLogin;
import pages.CounsellorRegisterPage;

public class CounsellorLoginScript extends BaseTest {

    @Test
    public void Login() throws Exception {
        CounsellorRegisterPage cp = new CounsellorRegisterPage(driver);
        cp.registerCounsellor();
        String generatedEmail = CounsellorRegisterPage.generatedEmail;  // Get the email generated during registration
        String commonPassword = CounsellorRegisterPage.generatedPassword;

        CounsellorLogin cl = new CounsellorLogin(driver);
        cl.loginCounsellor(generatedEmail, commonPassword);
    }}
