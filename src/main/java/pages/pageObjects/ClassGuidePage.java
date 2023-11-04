package pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.pageComponents.SpecGuideNavigationComponent;
import tools.anotations.UpdatePoint;

@UpdatePoint("30.10.2023")
public class ClassGuidePage extends BasePage implements PageObject
{
    private final Locators locators;
    public final SpecGuideNavigationComponent specGuideNavigationComponent;

    public ClassGuidePage()
    {
        specGuideNavigationComponent = new SpecGuideNavigationComponent();
        locators = new Locators();
    }

    public String getTitleText()
    {
        return locators.title.getText();
    }

    public boolean isGuideBodyDisplayed()
    {
        return locators.guideBody.isDisplayed();
    }


    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//h1[@class='heading-size-1 guide-content-title-favorite']")
        WebElement title;

        @FindBy(xpath = "//div[@id='guide-body']")
        WebElement guideBody;

    }
}
