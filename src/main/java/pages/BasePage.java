package pages;

import org.openqa.selenium.WebDriver;
import tools.anotations.Description;

@Description("Base class for all pages")
public abstract class BasePage
{
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver)
    {
        driver = webDriver;
    }
}
