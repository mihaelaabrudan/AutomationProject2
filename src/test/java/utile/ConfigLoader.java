package utile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties;
    private static ConfigLoader instance;

    public ConfigLoader(String propertyFilePath){
        properties = new Properties();

        try(FileInputStream inputStream = new FileInputStream(propertyFilePath)){
            properties.load(inputStream);

        }catch(IOException e){
            throw new RuntimeException("Fisierul de proprietati nu a fost gasit in locatie" + propertyFilePath);
        }

    }

    public static ConfigLoader getInstance(String propertyFilePath) {
        if (instance == null) {
            instance = new ConfigLoader(propertyFilePath);
        }
        return instance;
    }



    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
