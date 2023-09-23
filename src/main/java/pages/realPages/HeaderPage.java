package pages.realPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class HeaderPage extends BasePage
{
    public HeaderPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='header-logo']")
    WebElement wowHeadLogo;


    public MainPage returnToMain()
    {
        wowHeadLogo.click();
        return new MainPage();
    }
}
