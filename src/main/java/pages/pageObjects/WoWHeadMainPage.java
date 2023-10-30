package pages.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.pageComponents.HeaderPageComponent;
import pages.pageComponents.TodayInWoWPageComponent;
import tools.anotations.UpdatePoint;
import tools.enums.MainPageElements;
import tools.enums.Professions;
import tools.enums.Specializations;
import tools.enums.TodayInWoWSwitcher;

import java.util.*;

@UpdatePoint("30.10.2023")
public class WoWHeadMainPage extends BasePage implements PageObject
{
    private final Locators locators;
    public HeaderPageComponent headerPageComponent;
    public TodayInWoWPageComponent todayInWoWPageComponent;

    public WoWHeadMainPage()
    {
        locators = new Locators();
        headerPageComponent = new HeaderPageComponent();
        todayInWoWPageComponent = new TodayInWoWPageComponent();
    }

    public List<WebElement> selectWebElementList(MainPageElements element)
    {
        List<WebElement> list = null;

        switch (element) {
            case PROFESSIONS -> list = locators.professionsGuideIcons;
            case RECENT_NEWS -> list = locators.recentNewsList;
            case BLUE_TRACKER -> list = locators.blueTrackerNewsList;
            case PINNED_NEWS -> list = locators.pinnedNewsList;
            case ALL_NEWS -> list = locators.allNewsList;
            case SPECIALIZATIONS -> list = locators.classesGuideIcons;
        }
        return list;
    }

    @Step
    public String getWebElementText(WebElement element)
    {
        return element.getText();
    }

    @Step
    public RecentNewsPage clickToWebRecentNewsElement(WebElement element)
    {
        element.click();
        return new RecentNewsPage();
    }

    @Step
    public BlueTrackerPage clickToBlueTrackerNewsElement(WebElement element)
    {
        element.click();
        return new BlueTrackerPage();
    }

    @Step
    public WebElement getWebElementFromList(int index, MainPageElements element)
    {
        return this.selectWebElementList(element).get(index);
    }

    private Map<Professions, WebElement> getProfessionMap ()
    {
        List<WebElement> list = locators.professionsGuideIcons;
        ArrayList<Professions> professions = new ArrayList<>(List.of(Professions.values()));

        Map <Professions, WebElement> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(professions.get(i), list.get(i));
        }
        return map;
    }

    @Step
    public ProfessionGuidePage clickToSpecificProfession(Professions profession)
    {
        this.getProfessionMap().get(profession).click();
        return new ProfessionGuidePage();
    }

    private Map<Specializations, WebElement> getSpecializationMap ()
    {
        List<WebElement> list = locators.classesGuideIcons;
        ArrayList<Specializations> specializations = new ArrayList<>(List.of(Specializations.values()));

        Map <Specializations, WebElement> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(specializations.get(i), list.get(i));
        }
        return map;
    }

    @Step
    public ClassGuidePage clickToSpecificSpecialization(Specializations specialization)
    {
        this.getSpecializationMap().get(specialization).click();
        return new ClassGuidePage();
    }

    public boolean isMapPresent()
    {
        return locators.map.isDisplayed();
    }

    public int getMapPointCount()
    {
        return locators.mapPoints.size();
    }

    @Step
    public WebElement getTokenPrice(TodayInWoWSwitcher switcher)
    {
        WebElement element = todayInWoWPageComponent.getTokenPrice(switcher);
        System.out.println("Token price in " + switcher.name() + " realm is: " + element.getText());
        return element;
    }

    @Step
    public boolean isListOfMythicAffixesEmpty(TodayInWoWSwitcher switcher)
    {
        List<WebElement> list = todayInWoWPageComponent.getSpecificListOfAffixes(switcher);
        for(WebElement elem : list) {
            System.out.println(elem.getText());
        }
        return !list.isEmpty();
    }



    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//div[@class='news-recent-posts-rows-row'][@data-visible='true']//a")
        List<WebElement> recentNewsList;

        @FindBy(xpath = "//a[contains(@href, '/blue-tracker/')]")
        List <WebElement> blueTrackerNewsList;

        @FindBy(xpath = "//div[@class='news-content-spotlight-class-guides-icons']//a[contains(@href, '/classes/')]")
        List <WebElement> classesGuideIcons;

        @FindBy(xpath = "//div[@class='news-content-spotlight-class-guides-icons']//a[contains(@href, '/professions/')]")
        List<WebElement> professionsGuideIcons;

        @FindBy(xpath = "//div[@class='news-list'][@data-pinned='true']/div[@data-visible='true']")
        List<WebElement> pinnedNewsList;

        @FindBy(xpath = "//div[@data-zaf-dynamic='list']//div[@class='news-list-card']")
        List<WebElement> allNewsList;

        @FindBy(xpath = "//div[@class='mapper-overlay']")
        WebElement map;

        @FindBy(xpath = "//span[@class='mapper-map']//div[@class='pin']")
        List<WebElement> mapPoints;
    }
}
