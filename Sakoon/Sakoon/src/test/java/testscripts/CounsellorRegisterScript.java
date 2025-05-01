package testscripts;

import org.testng.annotations.Test;
import pages.CounsellorRegisterPage;

public class CounsellorRegisterScript extends BaseTest {

    @Test
    public void Register() throws Exception {

        CounsellorRegisterPage cp = new CounsellorRegisterPage(driver);
        cp.registerCounsellor();
    }
}
