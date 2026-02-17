package stepdefinitions;

import factory.PlaywrightFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

import static base.BaseTest.page;

public class Hooks {

    @Before
    public void setUp() {
        page = PlaywrightFactory.getPage();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(page, scenario.getName());
            System.out.println("Screenshot captured for failed scenario: " + scenario.getName());
        }

        page.context().close();
        PlaywrightFactory.close();
    }
}
