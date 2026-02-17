package base;

import com.microsoft.playwright.*;
import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    public static Page page;
    String browserName = ConfigReader.getProperty("browser");
    boolean headless = Boolean.parseBoolean(
            ConfigReader.getProperty("headless")
    );

    @Before
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

    @After
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
