package com.cs.config;

import com.cs.adaptors.Output;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class serves the configurations provided in config.properties
 *
 * @author anuja
 */
public class Configuration {

    private static final String configFile = "config.properties";

    private static final Configuration configuration = new Configuration();

    Properties properties = new Properties();

    public static Configuration getInstance() {
        return configuration;
    }

    public String getProperty(Property property) {
        String value = null;
        if (properties.containsKey(property.name())) {
            value = properties.getProperty(property.name());
        }
        return value;
    }

    private Configuration() {
    }

    public void initialize() {
        try (InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream(configFile)) {
            if (inputStream != null) {
                properties.load(inputStream);
                System.out.println("log:Configuration Initialized");
            } else {
                throw new FileNotFoundException("property file '" + configFile
                        + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("log:Loading default configuration");
            properties.setProperty(Property.OUTPUT.name(), Output.CONSOLE.name());
        }
    }


}