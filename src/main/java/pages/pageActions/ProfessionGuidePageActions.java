package pages.pageActions;

import pages.BasePage;
import pages.pageLocators.ProfessionGuidePageLocators;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class ProfessionGuidePageActions extends BasePage implements PageActions
{
    private ProfessionGuidePageLocators professionGuidePageLocators;

    public ProfessionGuidePageActions()
    {
        professionGuidePageLocators = new ProfessionGuidePageLocators();
    }

    public String getTitleText()
    {
        return professionGuidePageLocators.getTitle().getText();
    }
}
