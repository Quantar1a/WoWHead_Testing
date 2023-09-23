package pages.realPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.Arrays;
import java.util.List;

public class MainPage extends BasePage
{
    public MainPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='Blood Death Knight']")
    WebElement bloodDeathKnight;

    public void selectBloodDeathKnight()
    {
        bloodDeathKnight.click();
    }
}
