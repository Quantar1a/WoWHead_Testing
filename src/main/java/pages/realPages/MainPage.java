package pages.realPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;

import java.util.List;


@UpdatePoint("26.09.2023")
public class MainPage extends BasePage
{
    public MainPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()=\'Blue Tracker\']")
    WebElement blueTracker;

    By blueTrackerListOnMainPage = By.xpath("//a[contains(@class, 'blizzard-blue')]");

    @FindBy(xpath = "//img[@alt='Blood Death Knight']")
    WebElement bloodDeathKnight;

    public void selectBloodDeathKnight()
    {
        bloodDeathKnight.click();
    }

    @Description("Select Blue Tracker page")
    public void selectBlueTracker()
    {
        blueTracker.click();
    }

    @Description("""
            Check, if Blue Tracker is empty
            If empty - return false
            """)
    public boolean blueTrackerPresence()
    {
        List<WebElement> list = driver.findElements(blueTrackerListOnMainPage);
        return !list.isEmpty();
    }
}
