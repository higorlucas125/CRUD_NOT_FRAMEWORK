package com.crud_not_framework.dao;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static Properties properties = new Properties();

    static {
        try (InputStream inputStream = DatabaseConnection.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new FileNotFoundException("Arquivo não encontrado no diretorio src/main/resources");
            }

            properties.load(inputStream);

            Class.forName(properties.getProperty("jdbc.driver"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        return DriverManager.getConnection(url, user, password);
    }
}
