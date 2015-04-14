package pt.iscte.ipm.mediacenter.core.workers;

import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkersManager {
    private static WorkersManager ourInstance = new WorkersManager();
    private static ExecutorService executor;

    public static void addRunnable(Runnable runnable){
        getInstance();
        executor.execute(runnable);
    }

    public static WorkersManager getInstance() {
        return ourInstance;
    }

    private WorkersManager() {
        executor = Executors.newFixedThreadPool(SettingsManager.getIntegerSetting("server","workers"));
    }
}
