package pages.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//h1[@class='heading-size-1 guide-content-title-favorite']")
    private WebElement title;

    public WebElement getTitle()
    {
        return title;
    }
}
