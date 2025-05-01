package testscripts;

import org.testng.annotations.Test;
import pages.ClientRegPageUsingExcel;
import pages.ClientRegisterPageUsingFakeLibrary;
import utils.ExcelUtils;

public class ClientRegUsingExcel extends BaseTest {

    @Test
    public void registerMultipleClientsFromExcel() throws Exception {
        String excelPath = System.getProperty("user.dir") + "\\testdata\\regdata.xlsx";
        ExcelUtils excel = new ExcelUtils(excelPath, "Sheet1");

        int rowCount = excel.getRowCount();

        for (int r = 1; r <= rowCount; r++) {
            String firstName = excel.getCellData(r, 0);
            String lastName = excel.getCellData(r, 1);
            String dob = excel.getCellData(r, 2);
            String phoneCode = excel.getCellData(r, 3); // optional
            String contact = excel.getCellData(r, 4);
            String email = excel.getCellData(r, 5);
            String religion = excel.getCellData(r, 6); // optional
            String password = excel.getCellData(r, 7);
            String confirmPassword = excel.getCellData(r, 8);


            ClientRegPageUsingExcel regPageUsingExcel = new ClientRegPageUsingExcel(driver);

            regPageUsingExcel.register(firstName, lastName, dob, contact, email, password, confirmPassword);

            // Optional: Wait and navigate back
            Thread.sleep(3000);
            //driver.navigate().back(); // Or reload form page if required
        }
    }

}
