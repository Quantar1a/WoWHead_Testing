package data;

import tools.anotations.UpdatePoint;

//Container for all necessary data
@UpdatePoint("21.09.2023")
public class Data
{
    final String WOWHEAD_URL = "https://www.wowhead.com";

    public String getWOWHEAD_URL()
    {
        return WOWHEAD_URL;
    }
}
