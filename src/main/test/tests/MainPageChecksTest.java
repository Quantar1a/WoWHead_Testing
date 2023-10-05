package tests;

import baseTest.BaseTestClass;
import data.Data;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.realPages.HeaderPage;
import pages.realPages.MainPage;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;
import tools.enums.MainPageElements;

@UpdatePoint("05.10.2023")
public class MainPageChecksTest extends BaseTestClass
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
                {MainPageElements.RECENT_NEWS},
                {MainPageElements.PROFESSIONS},
                {MainPageElements.SPECIALIZATIONS}
        };
    }

    @Description("""
            According to TestChecks 1-6
            """)
    @Test(dataProvider = "listOfContainers")
    public void checkIfContainerIsNotEmpty(MainPageElements container)
    {
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkIfListOfElementsIsNotEmpty(mainPage.selectList(container)));
    }

    @AfterTest
    public void afterTest()
    {
        new HeaderPage().returnToMain();
    }
}
