package pages.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

import java.util.List;

@UpdatePoint("10.10.2023")
public class WoWHeadMainPageLocators extends BasePage implements PageLocators
{
    public WoWHeadMainPageLocators()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='news-recent-posts-rows-row'][@data-visible='true']")
    private List<WebElement> recentNewsList;

    @FindBy(xpath = "//div[@class='news-recent-posts-rows-row']//a[contains(@class, 'blizzard-blue')]")
    private List <WebElement> blueTrackerNewsList;

    @FindBy(xpath = "//div[@class='news-content-spotlight-class-guides-icons']//a[contains(@href, '/classes/')]")
    private List <WebElement> classesGuideIcons;

    @FindBy(xpath = "//div[@class='news-content-spotlight-class-guides-icons']//a[contains(@href, '/professions/')]")
    private  List<WebElement> professionsGuideIcons;

    @FindBy(xpath = "//div[@class='news-list'][@data-pinned='true']/div[@data-visible='true']")
    private List<WebElement> pinnedNewsList;

    @FindBy(xpath = "//div[@data-zaf-dynamic='list']//div[@class='news-list-card']")
    private List<WebElement> allNewsList;

    @FindBy(xpath = "//a[@class='switcher-choice'][text()='NA']")
    private WebElement NASwitcher;

    @FindBy(xpath = "//a[@class='switcher-choice'][text()='EU']")
    private WebElement EUSwitcher;

    @FindBy(xpath = "//section[@id='EU-group-wow-token-price']//span[@class='moneygold']")
    private WebElement EUTokenPrice;

    @FindBy(xpath = "//section[@id='US-group-wow-token-price']//span[@class='moneygold']")
    private WebElement USTokenPrice;

    @FindBy(xpath = "//section[contains(@id, 'EU-group-mythicaffix-line-')]")
    private List<WebElement> EUAffixes;

    @FindBy(xpath = "//section[contains(@id, 'US-group-mythicaffix-line-')]")
    private List<WebElement> NAAffixes;

    public List<WebElement> getRecentNewsList()
    {
        return recentNewsList;
    }

    public List<WebElement> getBlueTrackerNewsList()
    {
        return blueTrackerNewsList;
    }

    public List<WebElement> getClassesGuideIcons()
    {
        return classesGuideIcons;
    }

    public List<WebElement> getProfessionsGuideIcons()
    {
        return professionsGuideIcons;
    }

    public List<WebElement> getPinnedNewsList()
    {
        return pinnedNewsList;
    }

    public List<WebElement> getAllNewsList()
    {
        return allNewsList;
    }

    public WebElement getNASwitcher()
    {
        return NASwitcher;
    }

    public WebElement getEUSwitcher()
    {
        return EUSwitcher;
    }

    public WebElement getEUTokenPrice()
    {
        return EUTokenPrice;
    }

    public WebElement getUSTokenPrice()
    {
        return USTokenPrice;
    }

    public List<WebElement> getEUAffixes()
    {
        return EUAffixes;
    }

    public List<WebElement> getNAAffixes()
    {
        return NAAffixes;
    }
}
