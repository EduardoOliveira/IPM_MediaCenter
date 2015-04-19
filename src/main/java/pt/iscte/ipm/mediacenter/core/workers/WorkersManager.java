package pt.iscte.ipm.mediacenter.core.workers;

import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkersManager {
    private static WorkersManager ourInstance = new WorkersManager();
    private static ThreadPoolExecutor executor;
    private static long total = 0;

    public static void addRunnable(Runnable runnable) {
        getInstance();
        total++;
        executor.execute(runnable);
    }

    public static synchronized int getPendingTasksCount() {
        return executor.getQueue().size();
    }

    public static synchronized long getTotalTasksCount(){
        return total;
    }

    public static synchronized long getCompletedTasksCount(){
        return total - getPendingTasksCount();
    }

    public static WorkersManager getInstance() {
        return ourInstance;
    }

    private WorkersManager() {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(SettingsManager.getIntegerSetting("server", "workers"));
    }
}
