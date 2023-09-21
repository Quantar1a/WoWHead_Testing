package data;

import tools.anotations.Description;
import tools.anotations.UpdatePoint;
import tools.enums.Browsers;

import java.time.Duration;

@UpdatePoint("21.09.2023")
@Description("Configuration file")
public class Configuration
{
    public static final boolean isDeleteAllCookie = true;
    public static final Duration pageTimeLoad = Duration.ofSeconds(60);
    public static final Duration implicitlyWait = Duration.ofSeconds(20);
    public static final Browsers activeBrowser = Browsers.GOOGLE_CHROME;
}
