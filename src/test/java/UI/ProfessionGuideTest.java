package UI;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.pageObjects.WoWHeadMainPage;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.enums.Professions;
import tools.listeners.CustomListener;

@Listeners(CustomListener.class)
@UpdatePoint("30.10.2023")
public class ProfessionGuideTest extends BaseTestClass
{
    WoWHeadMainPage woWHeadMainPage;

    @BeforeTest
    public void beforeTest()
    {
        woWHeadMainPage = new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL());
    }

    @AfterMethod
    public void afterMethod()
    {
        woWHeadMainPage
                .headerPageComponent
                .clickToLogo();
    }

    @Test(dataProvider = "professions", dataProviderClass = DataProviders.class)
    public void professionTest(Professions profession)
    {
        String title = woWHeadMainPage
                .clickToSpecificProfession(profession)
                .getTitleText()
                .toLowerCase();

        Assert.assertTrue(title.contains(profession.name().toLowerCase()));
    }
}
