package pages.pageLocators;

import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class BlueTrackerPageLocators extends BasePage implements PageLocators
{
    public BlueTrackerPageLocators()
    {
        PageFactory.initElements(driver, this);
    }
}
