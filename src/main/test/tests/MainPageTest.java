package tests;

import baseTest.BaseTestClass;
import data.Data;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.realPages.HeaderPage;
import pages.realPages.MainPage;
import tools.classes.Actions;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;
import tools.enums.MainPageElements;

import java.util.List;

@UpdatePoint("28.09.2023")
@Description("""
        
        """)
public class MainPageTest extends BaseTestClass
{
    Data data = new Data();
    MainPage mainPage;

    @BeforeTest
    public void beforeTest()
    {
        new Actions(webDriver)
                .open(data.getWOWHEAD_URL());
    }

    @DataProvider(name = "listOfContainers")
    public Object[][] containers() {
        return new Object[][] {
                {MainPageElements.BLUE_TRACKER},
                {MainPageElements.ALL_NEWS},
                {MainPageElements.PINNED_NEWS},
                {MainPageElements.RECENT_NEWS}
        };
    }

    @Description("""
            According to Testcase #1-4
            """)
    @Test(dataProvider = "listOfContainers")
    public void checkIfContainerIsNotEmpty(MainPageElements container)
    {
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkIfListOfElementsIsNotEmpty(mainPage.selectList(container)));
    }

    @DataProvider(name = "listOfRecentNews")
    public Object[][] listOfRecentNews() {
        mainPage = new MainPage();
        List<WebElement> list = mainPage.selectList(MainPageElements.RECENT_NEWS);
        Object[][] obj = new Object[list.size()][1];

        for (int i = 0; i < list.size(); i++) {
            obj[i][0] = i;
        }

        return obj;
    }

    @Description("""
            According to Testcase #6
            """)
    @Test(dataProvider = "listOfRecentNews")
    public void checkRecentNewsNames(int index)
    {
        Assert.assertTrue(new MainPage().checkContents(index, MainPageElements.RECENT_NEWS));
    }

    @AfterTest
    public void afterTest()
    {
        new HeaderPage().returnToMain();
    }
}