package config;

public class EnvironmentConfig {

    private static final String BASE_URI = "https://jsonplaceholder.typicode.com";

    private EnvironmentConfig() {
        // Private constructor to prevent instantiation
    }

    public static String getBaseUri() {
        return BASE_URI;
    }
}