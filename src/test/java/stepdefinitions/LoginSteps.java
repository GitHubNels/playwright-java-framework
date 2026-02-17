package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelDataProvider;

import static base.BaseTest.page;

public class LoginSteps {

    LoginPage loginPage;

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(page);
        loginPage.openLoginPage();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should see login success message")
    public void user_should_see_login_success_message() {
      System.out.println("Logged in Success");
    }

    @And("Logout the page")
    public void Logout_out_the_page()
    {
        loginPage.clickLogOut();
    }

    @When("Get Data from Excel")
    public void getDataFromExcel() {
       System.out.print("Read Excel Value:"+ loginPage.getExcelValue());
    }
}
