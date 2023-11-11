package UI;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.pageObjects.WoWHeadMainPage;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.enums.MainPageElements;
import tools.listeners.CustomListener;

@Listeners(CustomListener.class)
@UpdatePoint("30.10.2023")
public class NewsTest extends BaseTestClass
{
    WoWHeadMainPage woWHeadMainPage;

    @BeforeTest
    public void beforeTest()
    {
        woWHeadMainPage = new Actions(webDriver)
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
        WebElement element = woWHeadMainPage
                .getWebElementFromList(index, MainPageElements.RECENT_NEWS);

        String nameOnMainPage = woWHeadMainPage
                .getWebElementText(element);

        String nameInsideNews = woWHeadMainPage
                .clickToWebRecentNewsElement(element)
                .getTitleText();

        Assert.assertEquals(nameInsideNews, nameOnMainPage);
    }

    @Description("Check if news name equals with news name inside news page for BlueTracker news")
    @Test(dataProvider = "indexes", dataProviderClass = DataProviders.class)
    public void compareBlueTrackerNewsNames(int index)
    {
        WebElement element = woWHeadMainPage
                .getWebElementFromList(index, MainPageElements.BLUE_TRACKER);

        String nameOnMainPage = woWHeadMainPage
                .getWebElementText(element);

        String nameInsideNews = woWHeadMainPage
                .clickToBlueTrackerNewsElement(element)
                .getWebElementText();

        Assert.assertEquals(nameInsideNews, nameOnMainPage);
    }
}