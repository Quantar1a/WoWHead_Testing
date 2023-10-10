package pages.pageActions;

import pages.BasePage;
import pages.pageLocators.RecentNewsPageLocators;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class RecentNewsPageActions extends BasePage implements PageActions
{
    private RecentNewsPageLocators recentNewsPageLocators;

    public RecentNewsPageActions()
    {
        recentNewsPageLocators = new RecentNewsPageLocators();
    }
}
