package UI;

import baseTest.BaseTestClass;
import data.Data;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.pageActions.componentPages.HeaderPageActions;
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
        woWHeadMainPageActions = new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL());
        woWHeadMainPageActions
                .headerPageActions
                .declineNotifications();

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
}
