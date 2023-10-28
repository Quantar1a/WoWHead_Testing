package pages.pageActions;

import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.pageLocators.SearchPageLocators;
import tools.anotations.UpdatePoint;

import java.util.List;

@UpdatePoint("28.10.2023")
public class SearchPageActions extends BasePage implements PageActions
{
    private SearchPageLocators searchPageLocators;

    public SearchPageActions()
    {
        searchPageLocators = new SearchPageLocators();
    }

    @Step
    public SpellAbilitiesPageActions selectTopResult()
    {
        List< WebElement> list = searchPageLocators.getListOfTopResults();
        Assert.assertFalse(list.isEmpty());
        list.get(1).click();
        return new SpellAbilitiesPageActions();
    }
}
