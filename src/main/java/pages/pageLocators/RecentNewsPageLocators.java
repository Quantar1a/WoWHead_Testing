package pages.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("12.10.2023")
public class RecentNewsPageLocators extends BasePage implements PageLocators
{
    public RecentNewsPageLocators()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='heading-size-1']")
    private WebElement newsTitle;

    public WebElement getNewsTitle()
    {
        return newsTitle;
    }
}
