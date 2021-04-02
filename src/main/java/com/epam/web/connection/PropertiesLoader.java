package com.epam.web.connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public Properties loadProperties(String filename) throws IOException {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) {

            if (inputStream == null) {
                throw new IOException("No file found");
            }
            Properties properties = new Properties();
            properties.load(inputStream);

            return properties;
        }
    }
}