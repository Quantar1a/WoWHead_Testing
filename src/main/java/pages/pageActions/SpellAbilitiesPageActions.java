package pages.pageActions;

import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.pageLocators.SpellAbilitiesPageLocators;
import tools.anotations.UpdatePoint;

@UpdatePoint("28.10.2023")
public class SpellAbilitiesPageActions extends BasePage implements PageActions
{
    private SpellAbilitiesPageLocators spellAbilitiesPageLocators;

    public SpellAbilitiesPageActions()
    {
        spellAbilitiesPageLocators = new SpellAbilitiesPageLocators();
    }

    public WebElement returnToolTip()
    {
        return spellAbilitiesPageLocators.getWowHeadToolTip();
    }
}
