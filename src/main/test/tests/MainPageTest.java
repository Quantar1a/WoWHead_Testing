package tests;

import baseTest.BaseTestClass;
import data.Data;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.realPages.BlueTrackerPage;
import pages.realPages.HeaderPage;
import pages.realPages.MainPage;
import tools.Actions;
import tools.anotations.Description;

public class MainPageTest extends BaseTestClass
{
    Data data = new Data();

    @BeforeTest
    public void beforeTest()
    {
        new Actions(webDriver)
                .open(data.getWOWHEAD_URL())
                .selectBlueTracker();
    }

    @Description("""
            According to testcase #1"
            Check is Blue Tracker list contains any element
            """)
    @Test
    public void blueTrackerPresenceCheck()
    {
        Assert.assertTrue(new MainPage().blueTrackerPresence());
    }

    @DataProvider(name = "provider")
    public Object[][] parameters()
    {
        return new Object[][] {
                {0},{1}, {2}, {3},{4},{5}, {6},{7}, {8}, {9}
        };
    }

    @Description("According to testcase #1")
    @Test (dataProvider = "provider")
    public void blueTrackerTest(int index)
    {
        Assert.assertTrue(new BlueTrackerPage().selectAndCheckBlueTracker(index));
    }


    @AfterTest
    public void afterTest()
    {
        new HeaderPage().returnToMain();
    }
}
