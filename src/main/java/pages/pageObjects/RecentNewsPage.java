package pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("30.10.2023")
public class RecentNewsPage extends BasePage implements PageObject
{
    private final Locators locators;

    public RecentNewsPage()
    {
        locators = new Locators();
    }

    //Return title name
    public String getTitleText()
    {
        return locators.newsTitle.getText();
    }


    //Class-container for locators
    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//h1[@class='heading-size-1']")
        WebElement newsTitle;

    }
}
