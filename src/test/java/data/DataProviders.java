package data;

import org.testng.annotations.DataProvider;
import pages.pageObjects.WoWHeadMainPage;
import tools.anotations.UpdatePoint;
import tools.enums.MainPageElements;
import tools.enums.Professions;
import tools.enums.Specializations;
import tools.enums.TodayInWoWSwitcher;

import java.util.ArrayList;
import java.util.List;

@UpdatePoint("28.10.2023")
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
                {TodayInWoWSwitcher.EU_REALM},
                {TodayInWoWSwitcher.NA_REALM}
        };
    }

//    @DataProvider(name = "indexes")
//    public Object[][] indexes()
//    {
//        Object[][] objects = new Object[new WoWHeadMainPageLocators().getRecentNewsList().size()][1];
//        Object[][] objects = new Object[new WoWHeadMainPage().;
//
//        for (int i = 0; i < objects.length; i++) {
//            objects[i][0] = i;
//        }
//
//        return objects;
//    }

    @DataProvider(name = "professions")
    public Object[][] professions()
    {
        Object[][] obj = new Object[Professions.values().length][1];
        ArrayList <Professions> listOfProfessions= new ArrayList<>(List.of(Professions.values()));

        for (int i = 0; i < Professions.values().length; i++) {
            obj[i][0] = listOfProfessions.get(i);
        }

        return obj;
    }

    @DataProvider(name = "specializations")
    public Object[][] specializations()
    {
        Object[][] obj = new Object[Specializations.values().length][1];
        ArrayList <Specializations> listOfSpecializations= new ArrayList<>(List.of(Specializations.values()));

        for (int i = 0; i < Specializations.values().length; i++) {
            obj[i][0] = listOfSpecializations.get(i);
        }

        return obj;
    }

    @DataProvider(name = "spells")
    public Object[][] spells()
    {
        return new Object[][]
        {
                {"Execute"},
                {"Heroic Throw"},
                {"Shield Slam"},
        };
    }
}
