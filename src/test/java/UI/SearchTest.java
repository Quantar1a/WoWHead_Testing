package UI;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.pageActions.SearchPageActions;
import pages.pageActions.WoWHeadMainPageActions;
import tools.anotations.MyDescription;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.listeners.CustomListener;

@Listeners(CustomListener.class)
@UpdatePoint("28.10.2023")
public class SearchTest extends BaseTestClass
{
    WoWHeadMainPageActions woWHeadMainPageActions;

    @BeforeTest
    public void beforeTest()
    {
        woWHeadMainPageActions = new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL());
        woWHeadMainPageActions
                .headerPageActions
                .declineNotifications();

    }

    @AfterMethod
    public void afterTest()
    {
        woWHeadMainPageActions
                .headerPageActions
                .clickToLogo();
    }

    @Test
    public void checkAchievementCondition()
    {
        woWHeadMainPageActions
                .headerPageActions
                .sendKeysToInput("mankriks wife");

        Assert.assertTrue(woWHeadMainPageActions.isMapPresent());
        Assert.assertEquals(woWHeadMainPageActions.getMapPointCount(), 114);
    }

    @MyDescription("Search spell inside WoWHead database")
    @Test(dataProvider = "spells", dataProviderClass = DataProviders.class)
    public void searchSpells(String spellName)
    {
        woWHeadMainPageActions
                .headerPageActions
                .sendKeysToInput(spellName);

        Assert.assertTrue(new SearchPageActions()
                .selectTopResult()
                .returnToolTip()
                .isDisplayed());
    }
}
