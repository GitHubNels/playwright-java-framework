package factory;

import com.microsoft.playwright.*;
import config.ConfigReader;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;

    // Singleton – Playwright
    private static Playwright getPlaywright() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        return playwright;
    }

    // Singleton – Browser (Polymorphic behavior)
    private static Browser getBrowser() {

        if (browser == null) {

            String browserName = ConfigReader.getProperty("browser").toLowerCase();
            boolean headless = Boolean.parseBoolean(
                    ConfigReader.getProperty("headless")
            );

            BrowserType.LaunchOptions options =
                    new BrowserType.LaunchOptions().setHeadless(headless);

            switch (browserName) {

                case "chrome":
                    options.setChannel("chrome");
                    browser = getPlaywright().chromium().launch(options);
                    break;

                case "firefox":
                    browser = getPlaywright().firefox().launch(options);
                    break;

                default:
                    throw new RuntimeException(
                            "Unsupported browser: " + browserName
                    );
            }
        }
        return browser;
    }

    // Factory method
    public static Page getPage() {
        BrowserContext context = getBrowser().newContext();
        return context.newPage();
    }

    // Cleanup
    public static void close() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}
