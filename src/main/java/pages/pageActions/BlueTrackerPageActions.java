package pages.pageActions;

import pages.BasePage;
import pages.pageLocators.BlueTrackerPageLocators;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class BlueTrackerPageActions extends BasePage implements PageActions
{
    private BlueTrackerPageLocators blueTrackerPageLocators;

    public BlueTrackerPageActions()
    {
        blueTrackerPageLocators = new BlueTrackerPageLocators();
    }
}
