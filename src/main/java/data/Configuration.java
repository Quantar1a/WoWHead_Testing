package data;

import org.openqa.selenium.Dimension;
import tools.anotations.UpdatePoint;
import tools.enums.Browsers;
import tools.enums.WindowMode;

import java.time.Duration;

//Configuration file
@UpdatePoint("21.09.2023")
public class Configuration
{
    //If true - delete cookie
    public static final boolean isDeleteAllCookie = true;

    //Page time load limit, in seconds
    public static final Duration pageTimeLoad = Duration.ofSeconds(120);

    //Implicitly wait, in seconds
    public static final Duration implicitlyWait = Duration.ofSeconds(180);

    //Choose specific browser
    public static final Browsers activeBrowser = Browsers.GOOGLE_CHROME;

    //Select window mode
    public static final WindowMode windowMode = WindowMode.MAXIMIZE;

    //Set window size
    //Used only when WindowMode is CUSTOM
    public static Dimension size = new Dimension(1800, 1000);
}
