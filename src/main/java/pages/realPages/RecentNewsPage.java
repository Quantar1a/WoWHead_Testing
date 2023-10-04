package pages.realPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class RecentNewsPage extends BasePage
{
    public RecentNewsPage()
    {
        PageFactory.initElements(driver, this);
    }

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    @FindBy(xpath = "//h1[@class='heading-size-1']")
    private WebElement titleElement;

    public String returnTitleName()
    {
        return wait.until(ExpectedConditions.visibilityOf(titleElement)).getText();
    }
}
