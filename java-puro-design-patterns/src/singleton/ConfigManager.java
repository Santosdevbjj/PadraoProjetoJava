package singleton;

public class ConfigManager {
    private static ConfigManager instance;
    private String appName;

    private ConfigManager() {
        this.appName = "Sistema de Pagamentos";
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }
}
