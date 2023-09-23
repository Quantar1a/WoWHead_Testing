package tests.classGuide;

import baseTest.BaseTestClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.realPages.HeaderPage;
import pages.realPages.MainPage;

public class ClassGuideTest extends BaseTestClass
{
    @Test
    public void test()
    {
        webDriver.get("https://www.wowhead.com");
        new MainPage().selectBloodDeathKnight();
    }

    @AfterTest
    public void afterTest()
    {
        new HeaderPage().returnToMain();
    }
}
