package pages.realPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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


@UpdatePoint("03.10.2023")
public class MainPage extends BasePage
{
    public MainPage()
    {
        PageFactory.initElements(driver, this);
    }

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    @FindBy(xpath = "//h1[@class='heading-size-1 guide-content-title-favorite']")
    WebElement title;

    private final By recentNewsElements = By.xpath("//div[@data-type='news']//div[@class='news-recent-posts-rows-row']");
    private final By pinnedNewsElements = By.xpath("//div[@data-pinned='true']//div[@class='news-list-card']");
    private final By allNewsElements = By.xpath("//div[@data-zaf-dynamic='list']/div");
    private final By blueTrackerElements = By.xpath("//a[contains(@href, '/blue-tracker/topic/')]");
    private final By specializationsElement = By.xpath("//div[@class='news-content-spotlight-class-guides-icons']//a[contains(@href, '/guide/classes/')]");
    private final By professionsElement = By.xpath("//div[@class='news-content-spotlight-class-guides-icons']//a[contains(@href, '/guide/professions/')]");

    public List<WebElement> selectList(MainPageElements element)
    {
        By locator = null;
        switch (element) {
            case ALL_NEWS -> locator = allNewsElements;
            case PINNED_NEWS -> locator = pinnedNewsElements;
            case RECENT_NEWS -> locator = recentNewsElements;
            case BLUE_TRACKER -> locator = blueTrackerElements;
        }

        List <WebElement> list = driver.findElements(locator);
        return list;
    }

    @Description("""
            Check if list of elements is empty. If not - return true.
            """)
    public boolean checkIfListOfElementsIsNotEmpty(List<WebElement> list)
    {
        return !(list.isEmpty());
    }

    public boolean checkContents (int index, MainPageElements element)
    {
        List<WebElement> list = this.selectList(element);
        WebElement elem = list.get(index);
        String nameInList = elem.getText();
        elem.click();
        wait.until(ExpectedConditions.invisibilityOf(elem));
        String nameInsideNews = new RecentNewsPage().returnTitleName();
        return nameInList.contains(nameInsideNews);
    }

    public HashMap<Professions, WebElement> getProfessionSet()
    {
        ArrayList<Professions> professionList = new ArrayList<>(List.of(Professions.values()));
        List<WebElement> webElementsList = driver.findElements(professionsElement);
        HashMap<Professions, WebElement> map = new HashMap<>();

        for (int i = 0; i < webElementsList.size(); i++) {
            map.put(professionList.get(i), webElementsList.get(i));
        }

        return map;
    }
    public HashMap<Specializations, WebElement> getSpecializationSet()
    {
        ArrayList<Specializations> specializationsList = new ArrayList<>(List.of(Specializations.values()));
        List<WebElement> webElementsList = driver.findElements(specializationsElement);

        HashMap<Specializations, WebElement> map = new HashMap<>();

        for (int i = 0; i < webElementsList.size(); i++) {
            map.put(specializationsList.get(i), webElementsList.get(i));
        }

        return map;
    }

    public MainPage clickToSpecificSpecialization(Specializations spec)
    {
        this.getSpecializationSet().get(spec).click();
        return this;
    }

    public MainPage clickToSpecificProfession(Professions prof)
    {
        this.getSpecializationSet().get(prof).click();
        return this;
    }

    public boolean getTitleName()
    {
        System.out.println(title.getText());
        return title.isDisplayed();
    }
}