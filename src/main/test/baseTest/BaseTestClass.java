package baseTest;

import data.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.BasePage;
import tools.ClearCookie;
import tools.SelectBrowser;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;
import tools.enums.Browsers;

@UpdatePoint("21.09.2023")
@Description("Base class for all tests")
public abstract class BaseTestClass
{
    protected static WebDriver webDriver;

    ClearCookie clearCookie = (boolean isDeleteCookie) -> {
        if (isDeleteCookie){
            webDriver.manage().deleteAllCookies();
        }
    };

    SelectBrowser selectBrowser = (Browsers browser)  -> {
        switch (browser) {
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
            case MS_EDGE -> {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
            }
            case GOOGLE_CHROME -> {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
        }
    };

    @BeforeSuite
    public void beforeSuite()
    {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        selectBrowser.selectSpecificBrowser(Configuration.activeBrowser);
        clearCookie.deleteCookie(Configuration.isDeleteAllCookie);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Configuration.pageTimeLoad);
        webDriver.manage().timeouts().implicitlyWait(Configuration.implicitlyWait);
        BasePage.setDriver(webDriver);

    }

    @AfterSuite
    public void afterSuite()
    {
        webDriver.quit();
    }
}
