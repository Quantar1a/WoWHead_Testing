package pages.realPages;

import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class ProfessionGuidePage extends BasePage
{
    public ProfessionGuidePage()
    {
        PageFactory.initElements(driver, this);
    }
}
