package tests.classGuide;

import baseTest.BaseTestClass;
import org.testng.annotations.Test;

public class ClassGuideTest extends BaseTestClass
{
    @Test
    public void test()
    {
        webDriver.get("https://www.wowhead.com");
    }
}
