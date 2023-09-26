package pages.realPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;

import java.time.Duration;
import java.util.List;

@UpdatePoint("26.09.2023")
public class BlueTrackerPage extends BasePage
{
    WebDriverWait webDriverWait;

    public BlueTrackerPage()
    {
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }


    private final By listOfNews = By.xpath("//tr[@class='listview-row']");
    private final List<WebElement> list = driver.findElements(listOfNews);

    @Description("""
            Check if the name of news in the list coincidence with the name of the news title
            If coincidence - return true
            Because the name contains flag, directly equals do not work in this case
            Can`t work without explicitly wait
            """)
    public boolean selectAndCheckBlueTracker(int index)
    {
        boolean result = false;

        WebElement element = list.get(index);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        String nameInList = element.getText();
        element.click();
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
        String nameInNews = new BlueTrackerNewsPage().getTitle();

        if (nameInList.contains(nameInNews)) {
            result = true;
        }
        return result;
    }
}
