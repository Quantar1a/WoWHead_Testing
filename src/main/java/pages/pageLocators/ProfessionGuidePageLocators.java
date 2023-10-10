package pages.pageLocators;

import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class ProfessionGuidePageLocators extends BasePage implements PageLocators
{
    public ProfessionGuidePageLocators()
    {
        PageFactory.initElements(driver, this);
    }
}
