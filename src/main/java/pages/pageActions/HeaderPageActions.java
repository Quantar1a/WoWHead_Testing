package pages.pageActions;

import pages.BasePage;
import pages.pageLocators.HeaderPageLocators;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class HeaderPageActions extends BasePage implements PageActions
{
    private HeaderPageLocators headerPageLocators;

    public HeaderPageActions()
    {
        headerPageLocators = new HeaderPageLocators();
    }
}