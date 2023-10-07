package pages.realPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;
import tools.enums.MainPageElements;
import tools.enums.Professions;
import tools.enums.Specializations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@UpdatePoint("07.10.2023")
public class MainPage extends BasePage
{
    public MainPage()
    {
        PageFactory.initElements(driver, this);
    }

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    @FindBy(xpath = "//h1[@class='heading-size-1 guide-content-title-favorite']")
    private WebElement title;

    @FindBy(xpath = "//div[@data-type='news']//div[@class='news-recent-posts-rows-row']//a")
    private List<WebElement> recentNewsList;

    @FindBy(xpath = "//div[@data-pinned='true']//div[@class='news-list-card']")
    private List<WebElement> pinnedNewsList;

    @FindBy(xpath = "//div[@data-zaf-dynamic='list']/div")
    private List<WebElement> allNewsList;

    @FindBy(xpath = "//a[contains(@href, '/blue-tracker/')]")
    private List<WebElement> blueTrackerList;

    @FindBy(xpath = "//div[@class='news-content-spotlight-class-guides-icons']//a[contains(@href, '/guide/classes/')]")
    private List <WebElement> specializationsList;

    @FindBy(xpath = "//div[@class='news-content-spotlight-class-guides-icons']//a[contains(@href, '/guide/professions/')]")
    private List <WebElement> professionsList;

    @FindBy(xpath = "//a[@class='switcher-choice'][text()='NA']")
    private WebElement switcherToNARealm;

    @FindBy(xpath = "//a[@class='switcher-choice'][text()='EU']")
    private WebElement switcherToEURealm;

    @FindBy(xpath = "//section[@id='EU-group-wow-token-price']//span[@class='moneygold']")
    private WebElement tokenPriceEU;

    @FindBy(xpath = "//section[@id='US-group-wow-token-price']//span[@class='moneygold']")
    private WebElement tokenPriceUS;

    public WebElement clickToSwitcherAndGetToken(MainPageElements element)
    {
        WebElement switcher = null;
        WebElement token = null;

        switch (element) {
            case NA_REALM -> {
                    switcher = switcherToNARealm;
                    token = tokenPriceUS;
            }
            case EU_REALM ->{
                    switcher = switcherToEURealm;
                    token = tokenPriceEU;
            }
        }
        switcher.click();
        return token;
    }

    public List<WebElement> selectList(MainPageElements element)
    {
        List <WebElement> list = null;

        switch (element) {
            case ALL_NEWS -> list = allNewsList;
            case PINNED_NEWS -> list = pinnedNewsList;
            case RECENT_NEWS -> list = recentNewsList;
            case BLUE_TRACKER -> list = blueTrackerList;
            case PROFESSIONS -> list = professionsList;
            case SPECIALIZATIONS -> list = specializationsList;
        }
        return list;
    }

    @Description("""
            Check if list of elements is empty. If not - return true.
            """)
    public boolean checkIfListOfElementsIsNotEmpty(List<WebElement> list)
    {
        return !(list.isEmpty());
    }

    public WebElement getProfessionMap(Professions prof)
    {
        ArrayList<Professions> professions = new ArrayList<>(List.of(Professions.values()));
        HashMap<Professions, WebElement> map = new HashMap<>();

        for (int i = 0; i < professionsList.size(); i++) {
            map.put(professions.get(i), professionsList.get(i));
        }

        return map.get(prof);
    }

    public WebElement getSpecializationMap(Specializations spec)
    {
        ArrayList<Specializations> specializations = new ArrayList<>(List.of(Specializations.values()));
        HashMap<Specializations, WebElement> map = new HashMap<>();

        for (int i = 0; i < specializationsList.size(); i++) {
            map.put(specializations.get(i), specializationsList.get(i));
        }

        return map.get(spec);
    }

    public boolean getTitleName()
    {
        System.out.println(title.getText());
        return title.isDisplayed();
    }

    public void clickToElementInList(int index, List<WebElement> list)
    {
        list.get(index).click();
    }
}