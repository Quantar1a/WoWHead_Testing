package tests;

import baseTest.BaseTestClass;
import data.Data;
import org.testng.annotations.*;
import pages.realPages.HeaderPage;
import tools.classes.Actions;
import tools.enums.Specializations;

public class ClassGuideTest extends BaseTestClass
{
    @DataProvider(name = "provider")
    public Object[][] provider()
    {
        return new Object[][]
        {
                {Specializations.BLOOD_DEATH_KNIGHT},
                {Specializations.PROTECTION_WARRIOR},
                {Specializations.RESTORATION_DRUID}
        };
    }

    @BeforeTest
    public void beforeTest()
    {
        new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL());
    }

    @Test(dataProvider = "provider")
    public void test(Specializations spec)
    {
//        Assert.assertTrue(new MainPage()
//                .clickToSpecificSpecialization(spec)
//                .getTitleName());
    }

    @AfterMethod
    public void afterTest()
    {
        new HeaderPage().returnToMain();
    }
}