package pages.pageActions.componentPages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.BasePage;
import pages.pageActions.PageActions;
import pages.pageActions.WoWHeadMainPageActions;
import pages.pageLocators.componentPages.HeaderPageLocators;
import tools.anotations.UpdatePoint;

@UpdatePoint("21.10.2023")
public class HeaderPageActions extends BasePage implements PageActions
{
    private HeaderPageLocators headerPageLocators;

    public HeaderPageActions()
    {
        headerPageLocators = new HeaderPageLocators();
    }

    public void clickToLogo()
    {
        headerPageLocators.getWoWHeadLogo().click();
    }

    public void declineNotifications()
    {
        headerPageLocators.getDeclineButtonOnNotification().click();
    }

    @Step
    public WoWHeadMainPageActions sendKeysToInput(String request)
    {
        headerPageLocators.getInput().sendKeys(request, Keys.ENTER);
        return new WoWHeadMainPageActions();
    }
}
