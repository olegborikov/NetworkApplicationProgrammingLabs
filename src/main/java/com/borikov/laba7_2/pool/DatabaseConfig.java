package com.borikov.laba7_2.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class DatabaseConfig {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String FILE_NAME = "property/database.properties";
    private static final String DATABASE_URL = "database.url";
    private static final String DATABASE_USERNAME = "database.username";
    private static final String DATABASE_PASSWORD = "database.password";
    private final String url;
    private final String username;
    private final String password;

    DatabaseConfig() {
        Properties properties = new Properties();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(FILE_NAME);
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "Error while reading properties file: {}", FILE_NAME, e);
            throw new RuntimeException("Error while reading properties file: " + FILE_NAME, e);
        }
        url = properties.getProperty(DATABASE_URL);
        username = properties.getProperty(DATABASE_USERNAME);
        password = properties.getProperty(DATABASE_PASSWORD);
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        final StringBuilder stringRepresentation = new StringBuilder("DatabaseConfig{");
        stringRepresentation.append(", url='").append(url).append('\'');
        stringRepresentation.append(", username='").append(username).append('\'');
        stringRepresentation.append(", password='").append(password).append('\'');
        stringRepresentation.append('}');
        return stringRepresentation.toString();
    }
}
