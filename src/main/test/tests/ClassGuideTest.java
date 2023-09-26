package tests;

import baseTest.BaseTestClass;
import data.Data;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.realPages.HeaderPage;
import tools.Actions;

public class ClassGuideTest extends BaseTestClass
{
    Data data = new Data();

    @Test
    public void test()
    {
        new Actions(webDriver)
                .open(data.getWOWHEAD_URL())
                .selectBloodDeathKnight();
    }

    @AfterTest
    public void afterTest()
    {
        new HeaderPage().returnToMain();
    }
}

