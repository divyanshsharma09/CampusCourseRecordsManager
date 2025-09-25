package edu.ccrm.config;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class AppConfig {

    private static AppConfig instance;

    private final Path dataFolder;

    // Private constructor prevents external instantiation
    private AppConfig() {
        // Load or define configuration here, for example:
        this.dataFolder = Paths.get("data");
    }

    // Global access point to get the instance
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public Path getDataFolder() {
        return dataFolder;
    }
}
