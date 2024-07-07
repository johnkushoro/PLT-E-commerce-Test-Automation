package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Config {
    private static final Logger logger = Logger.getLogger(Config.class.getName());

    public static Properties PROPERTIES;

    public static void setConfig() {
        PROPERTIES = new Properties();
        try {
            FileInputStream configFile = new FileInputStream("src/main/resources/config/config.properties");
            PROPERTIES.load(configFile);
        } catch (IOException e) {
            logger.severe("Error loading config.properties file: " + e.getMessage());
            throw new RuntimeException("Error loading config.properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return Config.PROPERTIES.getProperty(key);
    }

    public static String getPropertyWithException(String key) throws Exception {
        String value = Config.PROPERTIES.getProperty(key);
        if(null == value || value.isEmpty())
            throw new Exception("Property not found: " + key);

        return value;
    }
}
