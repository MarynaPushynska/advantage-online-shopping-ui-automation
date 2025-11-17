package com.maryna.advantage.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1. Creating the object of Properties (CREATE OBJECT)
    // make it private so we are limiting access to the object;
    // static it's make sure it`s created and loaded before everything else

    private static Properties properties = new Properties();

    static {

        try {

            //2. Open file from java memory using InputStream (OPEN FILE)
            FileInputStream file = new FileInputStream("configuration.properties");

            //3. Load the properties file to Properties object (LOAD PROPERTIES)

            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }


    //CREATE THE UTILITY METHOD TO USE THE OBJECT TO READ
    //4. Use properties object to read from the file (READ PROPERTIES)

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


}
