package pages;

import org.openqa.selenium.WebDriver;

//Base class for all pages
public abstract class BasePage
{
    protected static WebDriver driver;

    public static void driverSetUp(WebDriver webDriver)
    {
        driver = webDriver;
    }
}