package pages.pageLocators;

import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class ClassGuidePageLocators extends BasePage implements PageLocators
{
    public ClassGuidePageLocators()
    {
        PageFactory.initElements(driver, this);
    }
}
