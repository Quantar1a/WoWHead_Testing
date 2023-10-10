package data;

import org.testng.annotations.DataProvider;
import tools.anotations.UpdatePoint;
import tools.enums.MainPageElements;
import tools.enums.TodayInWoWSwitcher;

@UpdatePoint("10.10.2023")
public class DataProviders
{
    @DataProvider(name = "pageElements")
    public Object[][] pageElements()
    {
        return new Object[][]{
                {MainPageElements.PROFESSIONS},
                {MainPageElements.SPECIALIZATIONS},
                {MainPageElements.BLUE_TRACKER},
                {MainPageElements.RECENT_NEWS},
                {MainPageElements.PINNED_NEWS},
                {MainPageElements.ALL_NEWS}
        };
    }

    @DataProvider(name = "realms")
    public Object[][] realms()
    {
        return new Object[][]{
                {TodayInWoWSwitcher.NA_REALM},
                {TodayInWoWSwitcher.EU_REALM}
        };
    }
}
