package tools.classes;

import pages.pageActions.WoWHeadMainPageActions;
import tools.anotations.UpdatePoint;

@UpdatePoint("25.09.2023")
@FunctionalInterface
public interface OpenURL
{
    WoWHeadMainPageActions open(String URL);
}
