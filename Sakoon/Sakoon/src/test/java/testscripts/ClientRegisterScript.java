package testscripts;

import org.testng.annotations.Test;
import pages.ClientRegisterPageUsingFakeLibrary;

public class ClientRegisterScript extends BaseTest {

@Test
    public void Register() throws Exception {

    ClientRegisterPageUsingFakeLibrary rg = new ClientRegisterPageUsingFakeLibrary(driver);
    rg.register();
}
}
