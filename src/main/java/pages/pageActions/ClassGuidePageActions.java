package pages.pageActions;

import pages.BasePage;
import pages.pageLocators.ClassGuidePageLocators;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class ClassGuidePageActions extends BasePage implements PageActions
{
    private ClassGuidePageLocators classGuidePageLocators;

    public ClassGuidePageActions()
    {
        classGuidePageLocators = new ClassGuidePageLocators();
    }
}
