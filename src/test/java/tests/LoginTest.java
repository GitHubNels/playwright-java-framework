package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelDataProvider;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginExcelData",dataProviderClass = ExcelDataProvider.class)
    public void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(page);


        loginPage.openLoginPage();
        loginPage.login(username, password);
        loginPage.clickLogOut();
    }
}
