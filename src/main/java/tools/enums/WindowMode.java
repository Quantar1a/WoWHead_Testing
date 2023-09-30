package tools.enums;

import data.Configuration;
import org.openqa.selenium.Dimension;

public enum WindowMode
{
    MAXIMIZE,
    MINIMIZE,
    CUSTOM(Configuration.size);

    WindowMode(Dimension dimension)
    {
        this.dimension = dimension;
    }

    Dimension dimension;

    WindowMode()
    {}
}
