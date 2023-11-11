package pages.pageObjects;

import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

import java.util.List;

@UpdatePoint("30.10.2023")
public class SearchPage extends BasePage implements PageObject
{
    private final Locators locators;

    public SearchPage()
    {
        locators = new Locators();
    }

    //Obtain list of top results like List<WebElement>
    //And click on first WebElement in list
    @Step
    public SpellAbilitiesPage selectTopResult()
    {
        List< WebElement> list = locators.listOfTopResults;
        Assert.assertFalse(list.isEmpty());
        list.get(1).click();
        return new SpellAbilitiesPage();
    }


    //Class-container for locators
    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//a[@class='top-results-result-cover']")
        List<WebElement> listOfTopResults;

    }
}
