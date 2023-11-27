package commonutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class contains all the common utilies required for json pasrsing
 */
public class JSONUtilities {
    static String jsonData = "";

    public static String getJSONData(String filename) {
        try {
            jsonData = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return jsonData;
    }
}
