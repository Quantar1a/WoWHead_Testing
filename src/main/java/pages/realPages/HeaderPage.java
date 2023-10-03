package pages.realPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import tools.anotations.UpdatePoint;

import java.time.Duration;

@UpdatePoint("26.29.2023")
public class HeaderPage extends BasePage
{
    public HeaderPage()
    {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
    @FindBy(xpath = "//a[@class='header-logo']")
    private WebElement wowHeadLogo;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement input;

    @FindBy(xpath = "//button[@class='notifications-dialog-buttons-decline btn']")
    WebElement dismissButton;

    public void returnToMain()
    {
        wowHeadLogo.click();
    }

    public WebElement getInput()
    {
        return input;
    }

    public BasePage dismissAlert()
    {
        dismissButton.click();
        return this;
    }
}
