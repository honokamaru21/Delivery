package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //this class will read from configuration.properties file. then it will pass those values to our tests

    private static Properties properties;

    // we need to load configuration.properties file into properties variable
    //static block will run before everything in class

    static {
        try {
            //first of all we need to provide a path to our properties file
            String path = "src//test//resources//configuration.properties";

            //to read from the file
            FileInputStream inputStream = new FileInputStream(path);

            //now we need to load into the properties variable.
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();

        } catch (IOException e){
            //if exception happens we want to know where it is coming from and the reason
            e.printStackTrace();
        }
    }

    //properties.getProperty(key)
    public static String getProperty(String key){
        return properties.getProperty(key).trim();
    }
}
