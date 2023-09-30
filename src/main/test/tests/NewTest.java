package tests;

import baseTest.BaseTestClass;
import data.Data;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.realPages.HeaderPage;
import pages.realPages.MainPage;
import tools.classes.Actions;

public class NewTest extends BaseTestClass
{
    Data data;
    HeaderPage headerPage;
    MainPage mainPage;

    @BeforeTest
    public void beforeTest()
    {
        data = new Data();
        new Actions(webDriver)
                .open(data.getWOWHEAD_URL());
        new HeaderPage().dismissAlert();
    }

    @DataProvider(name = "provider")
    public Object[][] dataProvider() {
        return new Object[][]{
            {"Brewfest"},
            {"Pilgrim's Bounty"},
            {"Hallow's End"}
        };
    }

    @Test(dataProvider = "provider")
    public void searchElement(String str)
    {
        headerPage = new HeaderPage();
        mainPage = new MainPage();

        headerPage.clickToElement(headerPage.getInput())
                .sendKeysInElement(headerPage.getInput(), str)
                .sendSpecificKeys(headerPage.getInput(), Keys.ENTER);
    }

    @AfterTest
    public void afterTest()
    {
        new HeaderPage()
                .returnToMain();
    }
}
