package UI;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.pageActions.componentPages.HeaderPageActions;
import pages.pageActions.WoWHeadMainPageActions;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.enums.Professions;
import tools.listeners.CustomListener;

@Listeners(CustomListener.class)
@UpdatePoint("16.10.2023")
public class ProfessionGuideTest extends BaseTestClass
{
    WoWHeadMainPageActions woWHeadMainPageActions;

    @BeforeTest
    public void beforeTest()
    {
        woWHeadMainPageActions = new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL());
    }

    @AfterMethod
    public void afterMethod()
    {
        woWHeadMainPageActions
                .headerPageActions
                .clickToLogo();
    }

    @Test(dataProvider = "professions", dataProviderClass = DataProviders.class)
    public void professionTest(Professions profession)
    {
        String title = woWHeadMainPageActions
                .clickToSpecificProfession(profession)
                .getTitleText()
                .toLowerCase();

        Assert.assertTrue(title.contains(profession.name().toLowerCase()));
    }
}
