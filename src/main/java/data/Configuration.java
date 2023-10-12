package data;

import org.openqa.selenium.Dimension;
import tools.anotations.MyDescription;
import tools.anotations.UpdatePoint;
import tools.enums.Browsers;
import tools.enums.WindowMode;

import java.time.Duration;

@UpdatePoint("21.09.2023")
@MyDescription("Configuration file")
public class Configuration
{
    @MyDescription("If true - delete cookie")
    public static final boolean isDeleteAllCookie = true;

    @MyDescription("Page time load limit, in seconds")
    public static final Duration pageTimeLoad = Duration.ofSeconds(120);

    @MyDescription("Implicitly wait, in seconds")
    public static final Duration implicitlyWait = Duration.ofSeconds(120);

    @MyDescription("Choose specific browser")
    public static final Browsers activeBrowser = Browsers.GOOGLE_CHROME;

    @MyDescription("""
            Select window mode
            """)
    public static final WindowMode windowMode = WindowMode.MAXIMIZE;

    @MyDescription("""
            Set window size
            Used only when WindowMode is CUSTOM
            """)
    public static Dimension size = new Dimension(1800, 1000);
}
