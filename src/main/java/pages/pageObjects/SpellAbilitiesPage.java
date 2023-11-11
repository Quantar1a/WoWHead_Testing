package pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("30.10.2023")
public class SpellAbilitiesPage extends BasePage implements PageObject
{
    private final Locators locators;

    public SpellAbilitiesPage()
    {
        locators = new Locators();
    }

    //Return wow head tooltip
    public WebElement returnToolTip()
    {
        return locators.wowHeadToolTip;
    }


    //Class-container for locators
    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//div[contains(@class, 'wowhead-tooltip-width')]")
        WebElement wowHeadToolTip;

    }
}
