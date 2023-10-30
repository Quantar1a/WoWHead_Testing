package pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("30.10.2023")
public class BlueTrackerPage extends BasePage implements PageObject
{
    private final Locators locators;

    public BlueTrackerPage()
    {
        locators = new Locators();
    }

    public String getWebElementText()
    {
        return locators.newsTitle.getText();
    }



    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//h1[@class='heading-size-1']")
        WebElement newsTitle;
    }
}
