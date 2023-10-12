package tests;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.pageActions.WoWHeadMainPageActions;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.enums.MainPageElements;

@UpdatePoint("12.10.2023")
public class TestClass extends BaseTestClass
{
    WoWHeadMainPageActions woWHeadMainPageActions;
    @BeforeTest
    public void beforeTest()
    {
        new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL());
    }

    @AfterMethod
    public void afterTest()
    {
        webDriver.navigate().back();
    }

    @Description("Check if news name equals with news name inside news page for RecentNews")
    @Test(dataProvider = "indexes", dataProviderClass = DataProviders.class)
    public void compareRecentNewsNames(int index)
    {
        woWHeadMainPageActions = new WoWHeadMainPageActions();
        WebElement element = woWHeadMainPageActions.getWebElementFromList(index, MainPageElements.RECENT_NEWS);

        String nameOnMainPage = woWHeadMainPageActions
                .getWebElementText(element);

        String nameInsideNews = woWHeadMainPageActions
                .clickToWebRecentNewsElement(element)
                .getTitleText();
        Assert.assertEquals(nameInsideNews, nameOnMainPage);
    }

    @Description("Check if news name equals with news name inside news page for BlueTracker news")
    @Test(dataProvider = "indexes", dataProviderClass = DataProviders.class)
    public void compareBlueTrackerNEws(int index)
    {
        woWHeadMainPageActions = new WoWHeadMainPageActions();
        WebElement element = woWHeadMainPageActions
                .getWebElementFromList(index, MainPageElements.BLUE_TRACKER);

        String nameOnMainPage = woWHeadMainPageActions
                .getWebElementText(element);

        String nameInsideNews = woWHeadMainPageActions
                .clickToBlueTrackerNewsElement(element)
                .getWebElementText();

        Assert.assertEquals(nameInsideNews, nameOnMainPage);
    }
}