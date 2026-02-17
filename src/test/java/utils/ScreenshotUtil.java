package utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ScreenshotUtil {

    public static void captureScreenshot(Page page, String testName) {

        String filePath = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(filePath))
                .setFullPage(true));
    }
}
