package UI;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pageActions.HeaderPageActions;
import pages.pageActions.WoWHeadMainPageActions;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.enums.Professions;

@UpdatePoint("16.10.2023")
public class ProfessionGuideTest extends BaseTestClass
{
    WoWHeadMainPageActions woWHeadMainPageActions;

    @BeforeTest
    public void beforeTest()
    {
        new Actions(webDriver).open(new Data().getWOWHEAD_URL());
    }

    @AfterMethod
    public void afterMethod()
    {
        new HeaderPageActions().clickToLogo();
    }
    @Test(dataProvider = "professions", dataProviderClass = DataProviders.class)
    public void professionTest(Professions profession)
    {
        woWHeadMainPageActions = new WoWHeadMainPageActions();
        String title = woWHeadMainPageActions.clickToSpecificProfession(profession).getTitleText().toLowerCase();
        Assert.assertTrue(title.contains(profession.name().toLowerCase()));
    }
}
