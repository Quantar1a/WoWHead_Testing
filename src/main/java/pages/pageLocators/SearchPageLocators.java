package pages.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import tools.anotations.UpdatePoint;

import java.util.List;

@UpdatePoint("28.10.2023")
public class SearchPageLocators extends BasePage implements PageLocators
{
    public SearchPageLocators()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='top-results-result-cover']")
    private List<WebElement> listOfTopResults;

    public List<WebElement> getListOfTopResults()
    {
        return listOfTopResults;
    }
}
