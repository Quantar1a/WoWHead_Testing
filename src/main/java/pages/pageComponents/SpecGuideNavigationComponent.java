package pages.pageComponents;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.pageObjects.ClassGuidePage;
import pages.pageObjects.PageObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpecGuideNavigationComponent extends BasePage implements PageObject
{
    private Locators locators;

    private HashMap<GuideNavigation, WebElement> guideNavigationWebElementHashMap;

    public SpecGuideNavigationComponent()
    {
        locators = new Locators();
        guideNavigationWebElementHashMap = this.setGuideNavigationWebElementHashMap();
    }

    private HashMap<GuideNavigation, WebElement> setGuideNavigationWebElementHashMap()
    {
        List <WebElement> webElementsArrayList = locators.guideNavigation;
        ArrayList <GuideNavigation> guideNavigationElementsArrayList = new ArrayList<>(List.of(GuideNavigation.values()));
        HashMap <GuideNavigation, WebElement> map = new HashMap<>();

        for (int i = 0; i < webElementsArrayList.size(); i++) {
            map.put(guideNavigationElementsArrayList.get(i), webElementsArrayList.get(i));
        }
        return map;
    }

    @Step
    public ClassGuidePage clickToGuideNavigationElement(GuideNavigation guideNavigation)
    {
        guideNavigationWebElementHashMap.get(guideNavigation).click();
        return new ClassGuidePage();
    }

    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//div[@id=\"guide-navigation\"]//a[contains(@href, 'wowhead')]")
        List<WebElement> guideNavigation;
    }

    public enum GuideNavigation
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
        PRIMORDIAL_STONE,
        PVE_OVERVIEW,
        ABILITIES,
        CONSUMABLES,
        WEAK_AURAS,
        MACROS_AND_ADDONS,
        GLOSSARY,
        COMMON_QUESTIONS,
        LEVELING,
        MAGE_TOWER,
        PVP_OVERVIEW,
        PVP_TALENT_BUILD
    }
}
