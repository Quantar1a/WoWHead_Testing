package UI;

import baseTest.BaseTestClass;
import data.Data;
import data.DataProviders;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.pageActions.WoWHeadMainPageActions;
import tools.anotations.MyDescription;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.enums.MainPageElements;
import tools.enums.TodayInWoWSwitcher;
import tools.listeners.CustomListener;

import java.util.List;

@Listeners(CustomListener.class)
@UpdatePoint("24.10.2023")
public class WebElementsPresentsTest extends BaseTestClass
{
    WoWHeadMainPageActions woWHeadMainPageActions;
    @BeforeTest
    public void beforeTest()
    {
        woWHeadMainPageActions = new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL());
    }

    @MyDescription("""
            According to Testchechs #1-6
            """)
    @Description("Check visible of elements on page")
    @Test(dataProvider = "pageElements", dataProviderClass = DataProviders.class)
    public void checkWebElementsList(MainPageElements element)
    {
        List<WebElement> list = woWHeadMainPageActions.selectWebElementList(element);
        Assert.assertFalse(list.isEmpty());
        System.out.println("The number of " + element.name() + " are " + list.size());

        for (WebElement elem : list) {
            Assert.assertTrue(elem.isDisplayed());
        }
    }

    @MyDescription("""
            According to Testchecks #7
            """)
    @Description("Check token price")
    @Test(dataProvider = "realms", dataProviderClass = DataProviders.class)
    public void checkToken(TodayInWoWSwitcher switcher)
    {
        Assert.assertTrue(woWHeadMainPageActions.getTokenPrice(switcher).isDisplayed());
    }

    @MyDescription("""
            According to Testchecks #8
            """)
    @Description("Check if mythic affixes is displayed")
    @Test(dataProvider = "realms", dataProviderClass = DataProviders.class)
    public void checkMythicAffixes(TodayInWoWSwitcher switcher)
    {
        Assert.assertTrue(woWHeadMainPageActions.isListOfMythicAffixesEmpty(switcher));
    }
}