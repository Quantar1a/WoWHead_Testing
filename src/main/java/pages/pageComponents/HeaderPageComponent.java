package pages.pageComponents;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.pageObjects.PageObject;
import tools.anotations.UpdatePoint;

@UpdatePoint("30.10.2023")
public class HeaderPageComponent extends BasePage implements PageObject
{
    private final Locators locators;

    public HeaderPageComponent()
    {
        locators = new Locators();
    }

    public void clickToLogo()
    {
        locators.woWHeadLogo.click();
    }

    public void declineNotifications()
    {
        locators.declineButtonOnNotification.click();
    }

    @Step
    public void sendKeysToInput(String request)
    {
        locators.input.sendKeys(request, Keys.ENTER);
    }


    //Class-container for locators
    private class Locators
    {
        Locators()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//a[@class='header-logo']")
        WebElement woWHeadLogo;

        @FindBy(xpath = "//button[@class='notifications-dialog-buttons-decline btn']")
        WebElement declineButtonOnNotification;

        @FindBy(xpath = "//input[@name='q']")
        WebElement input;
    }
}
