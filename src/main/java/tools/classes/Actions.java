package tools.classes;

import org.openqa.selenium.WebDriver;
import pages.pageActions.WoWHeadMainPageActions;
import pages.pageActions.componentPages.HeaderPageActions;
import tools.anotations.MyDescription;
import tools.anotations.UpdatePoint;

@MyDescription("Different actions with WebDriver")
@UpdatePoint("25.09.2023")
public class Actions implements OpenURL
{
    WebDriver driver;

    public Actions(WebDriver webDriver)
    {
        this.driver = webDriver;
    }

    @MyDescription("Open URL in browser")
    public WoWHeadMainPageActions open(String URL)
    {
        driver.get(URL);
        return new WoWHeadMainPageActions();
    }
}
