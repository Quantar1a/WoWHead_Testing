package pages.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("10.10.2023")
public class HeaderPageLocators extends BasePage implements PageLocators
{
    public HeaderPageLocators()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='header-logo']")
    private WebElement woWHeadLogo;

    public WebElement getWoWHeadLogo()
    {
        return woWHeadLogo;
    }
}
