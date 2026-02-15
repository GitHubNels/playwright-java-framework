package base;

import com.microsoft.playwright.*;
import config.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    public Page page;
    String browserName = ConfigReader.getProperty("browser");
    boolean headless = Boolean.parseBoolean(
            ConfigReader.getProperty("headless")
    );
    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setChannel(browserName)
                        .setHeadless(headless)
        );

        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
