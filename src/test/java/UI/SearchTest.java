package UI;

import baseTest.BaseTestClass;
import data.Data;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.anotations.UpdatePoint;
import tools.classes.Actions;

@UpdatePoint("19.10.2023")
public class SearchTest extends BaseTestClass
{
    @BeforeTest
    public void beforeTest()
    {
        new Actions(webDriver)
                .open(new Data().getWOWHEAD_URL())
                .declineNotifications();
    }

    @Test
    public void firstTest()
    {

    }
}
