package commonutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Purpose of this class is to read data from config.properties file
 */
public class PropertyUtils {
    public static Properties prop = new Properties();

    public static String getPropertyValue(String key) throws IOException {
        Properties prop = readPropertiesFile();
        return prop.getProperty(key);
    }

    public static Properties readPropertiesFile() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream("config.properties");
        prop.load(inputStream);
        return prop;
    }

}
