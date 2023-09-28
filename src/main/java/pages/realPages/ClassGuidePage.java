package pages.realPages;

import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class ClassGuidePage extends BasePage
{
    public ClassGuidePage()
    {
        PageFactory.initElements(driver, this);
    }
}
