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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


@UpdatePoint("28.09.2023")
public class MainPage extends BasePage
{
    public MainPage()
    {
        PageFactory.initElements(driver, this);
    }

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    private final By recentNewsElements = By.xpath("//div[@data-type='news']//div[@class='news-recent-posts-rows-row']");
    private final By pinnedNewsElements = By.xpath("//div[@data-pinned='true']//div[@class='news-list-card']");
    private final By allNewsElements = By.xpath("//div[@data-zaf-dynamic='list']/div");
    private final By blueTrackerElements = By.xpath("//a[contains(@href, '/blue-tracker/topic/')]");

    @FindBy(xpath = "//img[@alt='Blood Death Knight']")
    private WebElement bloodDeathKnight;


    public void selectBloodDeathKnight()
    {
        bloodDeathKnight.click();
    }

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

//    public ArrayList<Boolean> checkContentsList ()
//    {
//        List<WebElement> list = driver.findElements(recentNewsElements);
//        ArrayList<Boolean> result = new ArrayList<>();
//        String nameInsidePage;
//        String nameInList;
//
//        for (WebElement element : list) {
//            nameInList = wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
//            element.click();
//            wait.until(ExpectedConditions.invisibilityOf(element));
//            nameInsidePage = new RecentNewsPage().returnTitleName();
//            result.add(nameInList.contains(nameInsidePage));
//        }
//
//        return result;
//    }
}