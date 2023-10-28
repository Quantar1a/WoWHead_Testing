package pages.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("28.10.2023")
public class SpellAbilitiesPageLocators extends BasePage implements PageLocators
{
    public SpellAbilitiesPageLocators()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'wowhead-tooltip-width')]")
    private WebElement wowHeadToolTip;

    public WebElement getWowHeadToolTip()
    {
        return wowHeadToolTip;
    }
}
