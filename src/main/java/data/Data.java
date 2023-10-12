package data;

import tools.anotations.MyDescription;
import tools.anotations.UpdatePoint;

@UpdatePoint("21.09.2023")
@MyDescription("Container for all necessary data")
public class Data
{
    final String WOWHEAD_URL = "https://www.wowhead.com";

    public String getWOWHEAD_URL()
    {
        return WOWHEAD_URL;
    }
}
