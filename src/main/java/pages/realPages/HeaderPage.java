package pages.realPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

@UpdatePoint("26.29.2023")
public class HeaderPage extends BasePage
{
    public HeaderPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='header-logo']")
    private WebElement wowHeadLogo;


    public void returnToMain()
    {
        wowHeadLogo.click();
    }
}
