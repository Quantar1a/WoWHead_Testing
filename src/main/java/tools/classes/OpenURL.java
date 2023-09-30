package tools.classes;

import pages.realPages.MainPage;
import tools.anotations.UpdatePoint;

@UpdatePoint("25.09.2023")
@FunctionalInterface
public interface OpenURL
{
    MainPage open(String URL);
}
