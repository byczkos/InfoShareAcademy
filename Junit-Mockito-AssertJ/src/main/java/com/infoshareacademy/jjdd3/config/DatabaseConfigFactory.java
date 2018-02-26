package com.infoshareacademy.jjdd3.config;

public class DatabaseConfigFactory {
    public static DatabaseConfig getForDatabase(String host, int port) {
        if (host == null || host.equals("")) {
            throw new IllegalArgumentException("Host cannot be empty!");
        }

        DatabaseConfig config = new DatabaseConfig();

        config.setHost(host);
        config.setPort(port);

        return config;
    }
}
