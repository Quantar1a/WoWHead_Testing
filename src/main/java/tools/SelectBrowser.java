package tools;

import tools.enums.Browsers;

@FunctionalInterface
public interface SelectBrowser
{
    void selectSpecificBrowser(Browsers browser);
}
