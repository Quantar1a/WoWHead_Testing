package pages.pageActions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.pageLocators.TodayInWoWPageComponentLocators;
import tools.anotations.UpdatePoint;
import tools.enums.TodayInWoWSwitcher;

import java.util.List;

@UpdatePoint("24.10.2023")
public class TodayInWoWPageComponentActions extends BasePage implements PageActions
{
    private TodayInWoWPageComponentLocators todayInWoWPageComponentLocators;

    public TodayInWoWPageComponentActions()
    {
        todayInWoWPageComponentLocators = new TodayInWoWPageComponentLocators();
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
            case NA_REALM -> switchButton = todayInWoWPageComponentLocators.getNASwitcher();
            case EU_REALM -> switchButton = todayInWoWPageComponentLocators.getEUSwitcher();
        }
        return switchButton;
    }

    public WebElement getSpecificToken(TodayInWoWSwitcher switcher)
    {
        WebElement token = null;
        switch(switcher) {
            case NA_REALM -> token = todayInWoWPageComponentLocators.getUSTokenPrice();
            case EU_REALM -> token = todayInWoWPageComponentLocators.getEUTokenPrice();
        }
        return token;
    }

    public List<WebElement> getSpecificListOfAffixes(TodayInWoWSwitcher switcher)
    {
        List<WebElement> list = null;
        switch (switcher) {
            case NA_REALM -> list = todayInWoWPageComponentLocators.getUSAffixes();
            case EU_REALM -> list = todayInWoWPageComponentLocators.getEUAffixes();
        }
        return list;
    }
}
