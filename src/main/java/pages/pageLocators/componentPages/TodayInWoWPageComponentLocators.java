package pages.pageLocators.componentPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.pageLocators.PageLocators;
import tools.anotations.UpdatePoint;

import java.util.List;

@UpdatePoint("24.10.2023")
public class TodayInWoWPageComponentLocators extends BasePage implements PageLocators
{
    public TodayInWoWPageComponentLocators()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='NA']")
    private WebElement NASwitcher;

    @FindBy(xpath = "//a[text()='EU']")
    private WebElement EUSwitcher;

    @FindBy(xpath = "//section[contains(@id, 'EU-group-mythicaffix-line-')]")
    private List<WebElement> EUAffixes;

    @FindBy(xpath = "//section[contains(@id, 'US-group-mythicaffix-line-')]")
    private List<WebElement> USAffixes;

    @FindBy(xpath = "//section[@id='EU-group-wow-token-price']//span")
    private WebElement EUTokenPrice;

    @FindBy(xpath = "//section[@id='US-group-wow-token-price']//span")
    private WebElement USTokenPrice;

    public WebElement getNASwitcher()
    {
        return NASwitcher;
    }

    public WebElement getEUSwitcher()
    {
        return EUSwitcher;
    }

    public List<WebElement> getEUAffixes()
    {
        return EUAffixes;
    }

    public List<WebElement> getUSAffixes()
    {
        return USAffixes;
    }

    public WebElement getEUTokenPrice()
    {
        return EUTokenPrice;
    }

    public WebElement getUSTokenPrice()
    {
        return USTokenPrice;
    }
}
