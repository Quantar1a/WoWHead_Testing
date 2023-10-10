package pages.pageLocators;

import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class RecentNewsPageLocators extends BasePage implements PageLocators
{
    public RecentNewsPageLocators()
    {
        PageFactory.initElements(driver, this);
    }
}
