package listeners;

import base.BaseTest;
import com.microsoft.playwright.Page;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object currentClass = result.getInstance();

        // Get page from BaseTest
        Page page = ((BaseTest) currentClass).page;

        String testName = result.getName();

        ScreenshotUtil.captureScreenshot(page, testName);

        System.out.println("Screenshot captured for failed test: " + testName);
    }
}
