package baseTest;

import data.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasePage;
import tools.classes.Setting;
import tools.anotations.UpdatePoint;
import tools.exceptions.NotAppropriateWindowSizeException;

//Base class for all tests
@UpdatePoint("23.09.2023")
public abstract class BaseTestClass
{
    protected static WebDriver webDriver;

    @BeforeSuite
    public void beforeSuite() throws NotAppropriateWindowSizeException
    {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        Setting.selectBrowser(Configuration.activeBrowser);
        Setting.deleteCookie(Configuration.isDeleteAllCookie);
        Setting.setTimeOuts(Configuration.pageTimeLoad, Configuration.implicitlyWait);
        Setting.setWindowSize(Configuration.windowMode);
        webDriver = Setting.getWebDriver();
        BasePage.driverSetUp(webDriver);
    }

    @AfterSuite
    public void afterSuite()
    {
        webDriver.quit();
    }
}
