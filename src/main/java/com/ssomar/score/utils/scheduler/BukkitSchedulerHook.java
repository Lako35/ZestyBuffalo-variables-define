package com.ssomar.score.utils.scheduler;

import com.ssomar.score.SCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class BukkitSchedulerHook implements SchedulerHook {
    private final SCore SCore;

    public BukkitSchedulerHook(SCore SCore) {
        this.SCore = SCore;
    }

    @Override
    public ScheduledTask runTask(Runnable runnable, long delay) {
        if (delay > 0) return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLater(SCore, runnable, delay).getTaskId());
        else return new BukkitScheduledTask(Bukkit.getScheduler().runTask(SCore, runnable).getTaskId());
    }

    @Override
    public ScheduledTask runRepeatingTask(Runnable runnable, long initDelay, long period) {
        return new BukkitScheduledTask(Bukkit.getScheduler().scheduleSyncRepeatingTask(SCore, runnable, initDelay, period));
    }

    @Override
    public ScheduledTask runAsyncTask(Runnable runnable, long delay) {
        if(delay > 0){
            return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLaterAsynchronously(SCore, runnable, delay).getTaskId());
        }
        else return new BukkitScheduledTask(Bukkit.getScheduler().runTaskAsynchronously(SCore, runnable).getTaskId());
    }

    @Override
    public ScheduledTask runAsyncRepeatingTask(Runnable runnable, long initDelay, long period) {
        return new BukkitScheduledTask(Bukkit.getScheduler().scheduleAsyncRepeatingTask(SCore, runnable, initDelay, period));
    }

    @Override
    public ScheduledTask runEntityTask(Runnable runnable, Runnable retired, Entity entity, long delay) {
        return runTask(runnable, delay);
    }

    @Override
    public ScheduledTask runLocationTask(Runnable runnable, Location location, long delay) {
        return runTask(runnable, delay);
    }

    @Override
    public ScheduledTask runEntityTaskAsap(Runnable runnable, Runnable retired, Entity entity) {
        if (Bukkit.isPrimaryThread()) {
            runnable.run();
            return new ScheduledTask() {
                @Override
                public void cancel() {}

                @Override
                public boolean isCancelled() {
                    return false;
                }
            };
        }
        return runTask(runnable, 0);
    }

    private static class BukkitScheduledTask implements ScheduledTask {
        private final int taskId;

        private BukkitScheduledTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void cancel() {
            Bukkit.getScheduler().cancelTask(taskId);
        }

        @Override
        public boolean isCancelled() {
            return !Bukkit.getScheduler().isQueued(taskId) && !Bukkit.getScheduler().isCurrentlyRunning(taskId);
        }
    }

}

