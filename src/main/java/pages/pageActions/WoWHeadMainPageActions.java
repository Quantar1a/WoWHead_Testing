package pages.pageActions;

import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.pageLocators.WoWHeadMainPageLocators;
import tools.anotations.UpdatePoint;
import tools.enums.MainPageElements;
import tools.enums.TodayInWoWSwitcher;

import java.util.List;

@UpdatePoint("10.10.2023")
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
}
