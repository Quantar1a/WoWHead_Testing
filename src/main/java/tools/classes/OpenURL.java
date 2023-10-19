package tools.classes;

import pages.pageActions.HeaderPageActions;
import tools.anotations.UpdatePoint;

@UpdatePoint("25.09.2023")
@FunctionalInterface
public interface OpenURL
{
    HeaderPageActions open(String URL);
}
