package tools.exceptions;

import data.Configuration;

public class NotAppropriateWindowSizeException extends Exception
{
    String message = "Incorrectly specified window size in Configuration file.\n" +
            "                Width must be between 800 - 1920;\n" +
            "                Height must be between 600 - 1080;\n" +
            "                Existent size: \n" +
            "                Width: " + Configuration.size.width + " \n" +
            "                Height: " + Configuration.size.height;

    @Override
    public String toString()
    {
        return "NotAppropriateWindowSizeException{" +
                message + '\'' +
                '}';
    }
}
