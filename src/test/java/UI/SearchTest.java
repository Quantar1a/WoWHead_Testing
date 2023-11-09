package UI;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.pageObjects.SearchPage;
import pages.pageObjects.WoWHeadMainPage;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.listeners.CustomListener;

@Listeners(CustomListener.class)
@UpdatePoint("30.10.2023")
public class SearchTest extends BaseTestClass
{
    WoWHeadMainPage woWHeadMainPage;

    @BeforeTest
    public void beforeTest()
    {
        woWHeadMainPage = new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL());
        woWHeadMainPage
                .headerPageComponent
                .declineNotifications();

    }

    @AfterMethod
    public void afterTest()
    {
        woWHeadMainPage
                .headerPageComponent
                .clickToLogo();
    }

    @Test
    public void checkAchievementCondition()
    {
        woWHeadMainPage
                .headerPageComponent
                .sendKeysToInput("mankriks wife");

        Assert.assertTrue(woWHeadMainPage.isMapPresent());
        Assert.assertEquals(woWHeadMainPage.getMapPointCount(), 114);
    }

    //Search spell inside WoWHead database
    @Test(dataProvider = "spells", dataProviderClass = DataProviders.class)
    public void searchSpells(String spellName)
    {
        woWHeadMainPage
                .headerPageComponent
                .sendKeysToInput(spellName);

        Assert.assertTrue(new SearchPage()
                .selectTopResult()
                .returnToolTip()
                .isDisplayed());
    }
}
