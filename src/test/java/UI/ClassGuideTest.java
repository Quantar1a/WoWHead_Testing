package UI;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.pageActions.HeaderPageActions;
import pages.pageActions.WoWHeadMainPageActions;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.enums.Specializations;
import tools.listeners.CustomListener;

@Listeners(CustomListener.class)
@UpdatePoint("16.10.2023")
public class ClassGuideTest extends BaseTestClass
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

    @Test(dataProvider = "specializations", dataProviderClass = DataProviders.class)
    public void specializationTest(Specializations specialization)
    {
        woWHeadMainPageActions = new WoWHeadMainPageActions();
        String title = woWHeadMainPageActions.clickToSpecificSpecialization(specialization).getTitleText().toLowerCase();
        String specializationName = specialization.name().toLowerCase().replace("_", " ");
        Assert.assertTrue(title.contains(specializationName));
    }
}
