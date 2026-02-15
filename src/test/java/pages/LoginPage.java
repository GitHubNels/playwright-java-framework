package pages;

import com.microsoft.playwright.Page;
import config.ConfigReader;
import objects.LoginPageobject;

public class LoginPage {

  LoginPageobject loginPageobject = new LoginPageobject();

    private Page page;


    // Constructor
    public LoginPage(Page page)
    {
        this.page = page;
    }

    // Page actions
    public void openLoginPage() {
        page.navigate(ConfigReader.getProperty("baseUrl"));
    }

    public void enterUsername(String username) {
        page.fill(loginPageobject.usernameInput, username);
    }

    public void enterPassword(String password) {
        page.fill(loginPageobject.passwordInput, password);
    }

    public void clickLogin() {
        page.click(loginPageobject.loginButton);
    }

    // Business action
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    //click logout
    public void clickLogOut()
    {
        page.click(loginPageobject.logoutButton);
    }
}
