package e2e.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;



    public static Properties readProperties(String filePath) throws IOException {

        try {
            FileInputStream fileInputStream =new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return properties;

    }

    public static String getPropertyValues(String key){
        return properties.getProperty(key);
    }
}
