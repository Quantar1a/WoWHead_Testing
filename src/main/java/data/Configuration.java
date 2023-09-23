package data;

import tools.anotations.Description;
import tools.anotations.UpdatePoint;
import tools.enums.Browsers;

import java.time.Duration;

@UpdatePoint("21.09.2023")
@Description("Configuration file")
public class Configuration
{
    @Description("If true - delete cookie")
    public static final boolean isDeleteAllCookie = true;

    @Description("Page time load limit, in seconds")
    public static final Duration pageTimeLoad = Duration.ofSeconds(30);

    @Description("Implicitly wait, in seconds")
    public static final Duration implicitlyWait = Duration.ofSeconds(40);

    @Description("Choose specific browser")
    public static final Browsers activeBrowser = Browsers.GOOGLE_CHROME;
}
