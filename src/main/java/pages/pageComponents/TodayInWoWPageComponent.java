package pages.pageComponents;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.pageObjects.PageObject;
import tools.anotations.UpdatePoint;
import tools.enums.TodayInWoWSwitcher;

import java.util.List;

@UpdatePoint("30.10.2023")
public class TodayInWoWPageComponent extends BasePage implements PageObject
{
    private final Locators locators;

    public TodayInWoWPageComponent()
    {
        locators = new Locators();
    }

    @Step
    public WebElement getTokenPrice(TodayInWoWSwitcher switcher)
    {
        this.getSpecificSwitcher(switcher).click();
        return this.getSpecificToken(switcher);
    }

    @Step
    public List<WebElement> getMythicAffixes(TodayInWoWSwitcher switcher)
    {
        this.getSpecificSwitcher(switcher).click();
        return this.getSpecificListOfAffixes(switcher);
    }

    public WebElement getSpecificSwitcher(TodayInWoWSwitcher switcher)
    {
        WebElement switchButton = null;
        switch(switcher) {
            case NA_REALM -> switchButton = locators.NASwitcher;
            case EU_REALM -> switchButton = locators.EUSwitcher;
        }
        return switchButton;
    }

    public WebElement getSpecificToken(TodayInWoWSwitcher switcher)
    {
        WebElement token = null;
        switch(switcher) {
            case NA_REALM -> token = locators.USTokenPrice;
            case EU_REALM -> token = locators.EUTokenPrice;
        }
        return token;
    }

    public List<WebElement> getSpecificListOfAffixes(TodayInWoWSwitcher switcher)
    {
        List<WebElement> list = null;
        switch (switcher) {
            case NA_REALM -> list = locators.USAffixes;
            case EU_REALM -> list = locators.EUAffixes;
        }
        return list;
    }



    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//a[text()='NA']")
        WebElement NASwitcher;

        @FindBy(xpath = "//a[text()='EU']")
        WebElement EUSwitcher;

        @FindBy(xpath = "//section[contains(@id, 'EU-group-mythicaffix-line-')]")
        List<WebElement> EUAffixes;

        @FindBy(xpath = "//section[contains(@id, 'US-group-mythicaffix-line-')]")
        List<WebElement> USAffixes;

        @FindBy(xpath = "//section[@id='EU-group-wow-token-price']//span")
        WebElement EUTokenPrice;

        @FindBy(xpath = "//section[@id='US-group-wow-token-price']//span")
        WebElement USTokenPrice;
    }
}
