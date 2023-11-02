package pages.pageComponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.pageObjects.PageObject;

import java.util.List;

public class SpecGuideNavigationComponent extends BasePage implements PageObject
{
    private Locators locators;

    public SpecGuideNavigationComponent()
    {
        locators = new Locators();
    }



    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//div[@id=\"guide-navigation\"]/ul[1]//a[contains(@href, 'wowhead')]")
        List<WebElement> DFSeasonTwo;

        @FindBy(xpath = "//div[@id=\"guide-navigation\"]/ul[2]//a[contains(@href, 'wowhead')]")
        List<WebElement> specBasics;

        @FindBy(xpath = "//div[@id=\"guide-navigation\"]/ul[3]//a[contains(@href, 'wowhead')]")
        List<WebElement> pvp;
    }

    public enum DFSeason2Enum
    {
        CHEAT_SHEET,
        SEASON_2_GUIDE,
        BEST_BUILDS,
        ROTATIONS,
        STAT_PRIORITY,
        BIS_GEAR,
        TEAR_SET,
        MYTHIC_PLUS,
        ABERRUS_RAID_TIPS,
        PRIMORDIAL_STONE
    }

    public enum SpecBasicsEnum
    {
        OVERVIEW,
        ABILITIES,
        CONSUMABLES,
        WEAK_AURAS,
        MACROS_AND_aDDONS,
        LEVELING,
        MAGE_TOWER
    }

    public enum PVPEnum
    {
        OVERVIEW,
        TALENT_BUILD
    }
}
