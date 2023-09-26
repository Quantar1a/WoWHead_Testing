package pages.realPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import tools.anotations.Description;
import tools.anotations.UpdatePoint;

import java.time.Duration;

@UpdatePoint("26.09.2023")
public class BlueTrackerNewsPage extends BasePage
{
    WebDriverWait webDriverWait;
    public BlueTrackerNewsPage()
    {
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(xpath = "//h1[@class='heading-size-1']")
    private WebElement title;

    @Description("""
            Get title and return it
            Can`t work without explicitly wait
            """)
    public String getTitle()
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(title));
        String textTitle = title.getText();
        driver.navigate().back();
        return textTitle;
    }
}
