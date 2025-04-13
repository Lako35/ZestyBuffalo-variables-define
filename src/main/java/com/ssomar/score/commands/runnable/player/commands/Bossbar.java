package com.ssomar.score.commands.runnable.player.commands;

import com.ssomar.score.SCore;
import com.ssomar.score.SsomarDev;
import com.ssomar.score.commands.runnable.CommandSetting;
import com.ssomar.score.commands.runnable.SCommandToExec;
import com.ssomar.score.commands.runnable.player.PlayerCommand;
import com.ssomar.score.utils.scheduler.ScheduledTask;
import com.ssomar.score.utils.strings.StringConverter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Bossbar extends PlayerCommand {

    private static Bossbar instance;
    Map<Player, Map<org.bukkit.boss.BossBar, ScheduledTask>> cache;

    public Bossbar() {
        instance = this;
        cache = new HashMap<>();
        CommandSetting time = new CommandSetting("time", 0, Integer.class, 200);
        CommandSetting color = new CommandSetting("color", 1, BarColor.class, BarColor.BLUE);
        CommandSetting text = new CommandSetting("text", 2, String.class, "Hello_world");
        CommandSetting count = new CommandSetting("count", -1, Integer.class, 0);
        CommandSetting countTicks = new CommandSetting("countTicks", -1, Boolean.class, false);
        CommandSetting countOrder = new CommandSetting("countOrder", -1, String.class, "descending");
        CommandSetting hideCount = new CommandSetting("hideCount", -1, Boolean.class, false);
        // NO_OVERRIDE , OVERRIDE_ALL, OVERRIDE_SAME_TEXT
        CommandSetting overrideMode = new CommandSetting("overrideMode", -1, String.class, "NO_OVERRIDE");

        text.setAcceptUnderScoreForLongText(true);
        List<CommandSetting> settings = getSettings();
        settings.add(time);
        settings.add(color);
        settings.add(text);
        settings.add(count);
        settings.add(countTicks);
        settings.add(countOrder);
        settings.add(hideCount);
        settings.add(overrideMode);
        setNewSettingsMode(true);
    }

    @Override
    public void run(Player p, Player receiver, SCommandToExec sCommandToExec) {
        BarColor color = (BarColor) sCommandToExec.getSettingValue("color");
        String text = (String) sCommandToExec.getSettingValue("text");
        Integer time = (Integer) sCommandToExec.getSettingValue("time");
        Integer count = (Integer) sCommandToExec.getSettingValue("count");
        Boolean countTicks = (Boolean) sCommandToExec.getSettingValue("countTicks");
        String countOrder = ((String) sCommandToExec.getSettingValue("countOrder")).toLowerCase();
        boolean isAscending = countOrder.equalsIgnoreCase("ascending");
        boolean hideCount = (Boolean) sCommandToExec.getSettingValue("hideCount");
        String overrideMode = (String) sCommandToExec.getSettingValue("overrideMode");

        List<String> args = sCommandToExec.getOtherArgs();
        StringBuilder message = new StringBuilder(text);
        message.append(" ");
        for (String s : args) {
            message.append(s).append(" ");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        String coloredMessage = StringConverter.coloredString(message.toString());

        if (overrideMode.equalsIgnoreCase("OVERRIDE_ALL")) {
            Map<org.bukkit.boss.BossBar, ScheduledTask> tasks = this.cache.get(receiver);
            if (tasks != null) {
                for (Map.Entry<org.bukkit.boss.BossBar, ScheduledTask> entry : tasks.entrySet()) {
                    removeBoosBar(entry.getKey(), receiver);
                }
            }
        } else if (overrideMode.equalsIgnoreCase("OVERRIDE_SAME_TEXT")) {
            SsomarDev.testMsg("Override mode: " + overrideMode, true);
            Map<org.bukkit.boss.BossBar, ScheduledTask> tasks = this.cache.get(receiver);
            if (tasks != null) {
                for (Map.Entry<org.bukkit.boss.BossBar, ScheduledTask> entry : tasks.entrySet()) {
                    SsomarDev.testMsg("Checking boss bar with same text: " + entry.getKey().getTitle(), true);
                    SsomarDev.testMsg("Boss bar with same text: " + entry.getKey().getTitle() + " vs " + coloredMessage, true);
                    if (entry.getKey().getTitle().contains(coloredMessage)) {
                        SsomarDev.testMsg("Removing boss bar with same text: " + entry.getKey().getTitle(), true);
                        removeBoosBar(entry.getKey(), receiver);
                    }
                }
            }
        }


        if(!coloredMessage.isEmpty()) {

            BossBar bossBar = Bukkit.createBossBar(coloredMessage, color, BarStyle.SOLID);
            bossBar.addPlayer(receiver);

            // Register bossbar without task
            if(cache.containsKey(receiver)) {
                cache.get(receiver).put(bossBar, null);
            } else {
                Map<org.bukkit.boss.BossBar, ScheduledTask> map = new HashMap<>();
                map.put(bossBar, null);
                cache.put(receiver, map);
            }

            final String finalMessage = message.toString();

            if (count > 0) {
                AtomicReference<ScheduledTask> task = new AtomicReference<>();
                Runnable runnable = new Runnable() {
                    int counter = isAscending ? 0 : count;

                    @Override
                    public void run() {
                        if (isAscending) {
                            if (counter >= count) {
                                removeBoosBar(bossBar, receiver);
                                return;
                            }
                            counter++;
                        } else {
                            if (counter <= 0) {
                                removeBoosBar(bossBar, receiver);
                                return;
                            }
                            counter--;
                        }

                        String countText = String.valueOf(counter);
                        if (!countTicks) {
                            countText += "s";
                        }
                        bossBar.setProgress((double) counter / count);
                        if (hideCount) {
                            bossBar.setTitle(StringConverter.coloredString(finalMessage));
                        } else bossBar.setTitle(StringConverter.coloredString(finalMessage + " " + countText));
                    }
                };
                task.set(SCore.schedulerHook.runRepeatingTask(runnable, 1, countTicks ? 1 : 20));

                // Register bossbar with task
                if(cache.containsKey(receiver)) {
                    cache.get(receiver).put(bossBar, task.get());
                } else {
                    Map<org.bukkit.boss.BossBar, ScheduledTask> map = new HashMap<>();
                    map.put(bossBar, task.get());
                    cache.put(receiver, map);
                }
            } else {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        removeBoosBar(bossBar, receiver);
                    }
                };
                SCore.schedulerHook.runTask(runnable, time);
            }
        }
    }

    public  void removeBoosBar(org.bukkit.boss.BossBar bossBar, Player p) {
        bossBar.removeAll();
        Map<org.bukkit.boss.BossBar, ScheduledTask> tasks = this.cache.get(p);
        if (tasks == null) return;
        ScheduledTask task = tasks.get(bossBar);
        if (task == null) return;
        task.cancel();
        tasks.remove(bossBar);
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("BOSSBAR");
        return names;
    }

    @Override
    public String getTemplate() {
        return "BOSSBAR time:200 color:BLUE text:Hello_world count:0 countTicks:false countOrder:descending";
    }

    @Override
    public ChatColor getColor() {
        return null;
    }

    @Override
    public ChatColor getExtraColor() {
        return null;
    }

    public static Bossbar getInstance() {
        if (instance == null) {
            instance = new Bossbar();
        }
        return instance;
    }

    public void clearTasks(Player p) {
        Map<org.bukkit.boss.BossBar, ScheduledTask> tasks = this.cache.get(p);
        if (tasks != null) {
            for (Map.Entry<org.bukkit.boss.BossBar, ScheduledTask> entry : tasks.entrySet()) {
                removeBoosBar(entry.getKey(), p);
            }
            tasks.clear();
        }
    }
}