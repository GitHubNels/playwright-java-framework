package objects;

import base.BaseTest;

public class LoginPageobject extends BaseTest
{
    // Locators (private → encapsulation)
    public String usernameInput = "#username";
    public String passwordInput = "#password";
    public String loginButton   = "#submit";
    public String logoutButton = "div.post-content a";
    public String loginSuccess = "div.post-header h1";
}
