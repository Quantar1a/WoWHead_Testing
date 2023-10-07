package tests;

import baseTest.BaseTestClass;
import data.Data;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.realPages.BlueTrackerPage;
import pages.realPages.HeaderPage;
import pages.realPages.MainPage;
import pages.realPages.RecentNewsPage;
import tools.classes.Actions;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;
import tools.enums.MainPageElements;

import java.util.List;

@UpdatePoint("28.09.2023")
@Description("""
        
        """)
public class MainPageComplexTest extends BaseTestClass
{
    Data data = new Data();
    MainPage mainPage;

    @BeforeTest
    public void beforeTest()
    {
        new Actions(webDriver)
                .open(data.getWOWHEAD_URL());
    }

    @DataProvider(name = "RecentNews")
    public Object[][] getRecentNews()
    {
        mainPage = new MainPage();
        Object indexes[][] = new Object[mainPage.selectList(MainPageElements.RECENT_NEWS).size()][1];

        for (int i = 0; i < indexes.length; i++) {
            indexes[i][0] = i;
        }
        return indexes;
    }

    @Description("""
            According to Testcase #6
            """)
    @Test(dataProvider = "RecentNews")
    public void checkRecentNews(int index)
    {
        mainPage = new MainPage();
        String titleInMainPage = mainPage.selectList(MainPageElements.RECENT_NEWS).get(index).getText();
        mainPage.clickToElementInList(index, mainPage.selectList(MainPageElements.RECENT_NEWS));
        String titleInNews = new RecentNewsPage().returnTitleName();
        Assert.assertEquals(titleInNews, titleInMainPage);
    }

    @DataProvider(name = "BlueTracker")
    public Object[][] getBlueTracker()
    {
        mainPage = new MainPage();
        Object indexes[][] = new Object[mainPage.selectList(MainPageElements.BLUE_TRACKER).size()][1];

        for (int i = 0; i < indexes.length; i++) {
            indexes[i][0] = i;
        }
        return indexes;
    }

    @Description("""
            According to Testcase #5
            """)
    @Test(dataProvider = "BlueTracker")
    public void checkBlueTracker(int index)
    {
        mainPage = new MainPage();
        String titleInMainPage = mainPage.selectList(MainPageElements.BLUE_TRACKER).get(index).getText();
        mainPage.clickToElementInList(index, mainPage.selectList(MainPageElements.BLUE_TRACKER));
        String titleInNews = new BlueTrackerPage().getTitle();
        Assert.assertEquals(titleInNews, titleInMainPage);
    }

    @AfterMethod
    public void afterTest()
    {
        new HeaderPage().returnToMain();
    }
}