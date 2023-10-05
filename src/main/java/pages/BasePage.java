package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tools.anotations.Description;

@Description("Base class for all pages")
public abstract class BasePage
{
    protected static WebDriver driver;

    public static void driverSetUp(WebDriver webDriver)
    {
        driver = webDriver;
    }

    public BasePage clickToElement(WebElement element)
    {
        element.click();
        return this;
    }

    public BasePage sendKeysToElement(WebElement element, Keys keys)
    {
        element.sendKeys(keys);
        return this;
    }

    public BasePage sendKeysToElement(WebElement element, String str)
    {
        element.sendKeys(str);
        return this;
    }
}
