package pages.pageActions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.pageLocators.WoWHeadMainPageLocators;
import tools.anotations.UpdatePoint;
import tools.enums.MainPageElements;
import tools.enums.Professions;
import tools.enums.Specializations;
import tools.enums.TodayInWoWSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UpdatePoint("12.10.2023")
public class WoWHeadMainPageActions extends BasePage implements PageActions
{
    private WoWHeadMainPageLocators woWHeadMainPageLocators;

    public WoWHeadMainPageActions()
    {
        woWHeadMainPageLocators = new WoWHeadMainPageLocators();
    }

    public List<WebElement> selectWebElementList(MainPageElements element)
    {
        List<WebElement> list = null;

        switch (element) {
            case PROFESSIONS -> list = woWHeadMainPageLocators.getProfessionsGuideIcons();
            case RECENT_NEWS -> list = woWHeadMainPageLocators.getRecentNewsList();
            case BLUE_TRACKER -> list = woWHeadMainPageLocators.getBlueTrackerNewsList();
            case PINNED_NEWS -> list = woWHeadMainPageLocators.getPinnedNewsList();
            case ALL_NEWS -> list = woWHeadMainPageLocators.getAllNewsList();
            case SPECIALIZATIONS -> list = woWHeadMainPageLocators.getClassesGuideIcons();
        }
        return list;
    }

    public WoWHeadMainPageActions clickToSwitcherAndSelectRealm(TodayInWoWSwitcher switcher)
    {
        WebElement realm = null;

        switch (switcher) {
            case NA_REALM -> realm = woWHeadMainPageLocators.getNASwitcher();
            case EU_REALM -> realm = woWHeadMainPageLocators.getEUSwitcher();
        }
        realm.click();
        return this;
    }

    public WebElement getToken(TodayInWoWSwitcher switcher)
    {
        WebElement token = null;

        switch (switcher) {
            case NA_REALM -> token = woWHeadMainPageLocators.getUSTokenPrice();
            case EU_REALM -> token = woWHeadMainPageLocators.getEUTokenPrice();
        }
        return token;
    }

    public String getTokenPrice(TodayInWoWSwitcher switcher)
    {
        return this.getToken(switcher).getText();
    }

    public boolean isTokenPresent(TodayInWoWSwitcher switcher)
    {
        return this.getToken(switcher).isDisplayed();
    }

    public List<WebElement> getMythicAffixes(TodayInWoWSwitcher switcher)
    {
        List<WebElement> listOfAffixes = null;
        switch (switcher) {
            case NA_REALM -> listOfAffixes = woWHeadMainPageLocators.getNAAffixes();
            case EU_REALM -> listOfAffixes = woWHeadMainPageLocators.getEUAffixes();
        }
        return listOfAffixes;
    }

    @Step
    public String getWebElementText(WebElement element)
    {
        return element.getText();
    }

    @Step
    public RecentNewsPageActions clickToWebRecentNewsElement(WebElement element)
    {
        element.click();
        return new RecentNewsPageActions();
    }

    @Step
    public BlueTrackerPageActions clickToBlueTrackerNewsElement(WebElement element)
    {
        element.click();
        return new BlueTrackerPageActions();
    }

    @Step
    public WebElement getWebElementFromList(int index, MainPageElements element)
    {
        return this.selectWebElementList(element).get(index);
    }

    private Map<Professions, WebElement> getProfessionMap ()
    {
        List<WebElement> list = woWHeadMainPageLocators.getProfessionsGuideIcons();
        ArrayList<Professions> professions = new ArrayList<>(List.of(Professions.values()));

        Map <Professions, WebElement> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(professions.get(i), list.get(i));
        }
        return map;
    }

    @Step
    public ProfessionGuidePageActions clickToSpecificProfession(Professions profession)
    {
        this.getProfessionMap().get(profession).click();
        return new ProfessionGuidePageActions();
    }

    private Map<Specializations, WebElement> getSpecializationMap ()
    {
        List<WebElement> list = woWHeadMainPageLocators.getClassesGuideIcons();
        ArrayList<Specializations> specializations = new ArrayList<>(List.of(Specializations.values()));

        Map <Specializations, WebElement> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(specializations.get(i), list.get(i));
        }

        return map;
    }

    @Step
    public ClassGuidePageActions clickToSpecificSpecialization(Specializations specialization)
    {
        this.getSpecializationMap().get(specialization).click();
        return new ClassGuidePageActions();
    }
}
