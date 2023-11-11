package tools.classes;

import pages.pageObjects.WoWHeadMainPage;
import tools.anotations.UpdatePoint;

@UpdatePoint("30.09.2023")
@FunctionalInterface
public interface OpenURL
{
    WoWHeadMainPage open(String URL);
}
