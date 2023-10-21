package UI;

import baseTest.BaseTestClass;
import data.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.pageActions.HeaderPageActions;
import pages.pageActions.WoWHeadMainPageActions;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.listeners.CustomListener;

@Listeners(CustomListener.class)
@UpdatePoint("21.10.2023")
public class SearchTest extends BaseTestClass
{
    WoWHeadMainPageActions woWHeadMainPageActions;

    @BeforeTest
    public void beforeTest()
    {
        new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL())
                .declineNotifications();
    }

    @Test
    public void checkAchievementCondition()
    {
        woWHeadMainPageActions = new HeaderPageActions()
                .sendKeysToInput("mankriks wife");

        Assert.assertTrue(woWHeadMainPageActions.isMapPresent());
        Assert.assertEquals(woWHeadMainPageActions.getMapPointCount(), 114);
    }
}
