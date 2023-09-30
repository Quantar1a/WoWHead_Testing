package tools.classes;

import data.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;
import tools.enums.Browsers;
import tools.enums.WindowMode;
import tools.exceptions.NotAppropriateWindowSizeException;

import java.time.Duration;

@UpdatePoint("23.09.2023")
@Description("Setting for load browsers")
public class Setting
{
    static WebDriver driver;

    @Description("Possibility to clear cookie")
    public static void deleteCookie(Boolean isDeleteCookie)
    {
        if (isDeleteCookie) {
            driver.manage().deleteAllCookies();
        }
    }

    @Description("Select specific browser")
    public static void selectBrowser(Browsers browser)
    {
        switch (browser) {
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case MICROSOFT_EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case GOOGLE_CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
    }

    @Description("Set page load and implicitly wait timeouts")
    public static void setTimeOuts(Duration pageLoadTimeOut, Duration implicitlyWaitTimeOut)
    {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut);
        driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeOut);
    }

    @Description("""
            Set window size
            """)
    public static void setWindowSize(WindowMode mode) throws NotAppropriateWindowSizeException
    {
        switch (mode) {
            case CUSTOM -> {
                if (Configuration.size.width < 800 || Configuration.size.height < 600 ||
                        Configuration.size.width > 1920 || Configuration.size.height > 1080) {
                    throw new NotAppropriateWindowSizeException();
                } else {
                    driver.manage().window().setSize(Configuration.size);
                }
            }
            case MAXIMIZE -> {
                driver.manage().window().maximize();
            }
            case MINIMIZE -> {
                driver.manage().window().minimize();
            }
        }
    }

    @Description("Return instance webdriver")
    public static WebDriver getWebDriver()
    {
        return driver;
    }
}
