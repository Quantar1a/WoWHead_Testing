package baseTest;

import data.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasePage;
import tools.Setting;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;

@UpdatePoint("23.09.2023")
@Description("Base class for all tests")
public abstract class BaseTestClass
{
    protected static WebDriver webDriver;

    @BeforeSuite
    public void beforeSuite()
    {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        Setting.selectBrowser(Configuration.activeBrowser);
        Setting.deleteCookie(Configuration.isDeleteAllCookie);
        Setting.setTimeOuts(Configuration.pageTimeLoad, Configuration.implicitlyWait);
        webDriver = Setting.getWebDriver();
        webDriver.manage().window().maximize();
        BasePage.driverSetUp(webDriver);
    }

    @AfterSuite
    public void afterSuite()
    {
        webDriver.quit();
    }
}
