package pages.pageLocators.componentPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.pageLocators.PageLocators;
import tools.anotations.UpdatePoint;

import java.util.List;

@UpdatePoint("21.10.2023")
public class HeaderPageLocators extends BasePage implements PageLocators
{
    public HeaderPageLocators()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='header-logo']")
    private WebElement woWHeadLogo;

    @FindBy(xpath = "//button[@class='notifications-dialog-buttons-decline btn']")
    private WebElement declineButtonOnNotification;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement input;

    public WebElement getDeclineButtonOnNotification()
    {
        return declineButtonOnNotification;
    }

    public WebElement getWoWHeadLogo()
    {
        return woWHeadLogo;
    }

    public WebElement getInput()
    {
        return input;
    }
}
