package com.ssomar.score.commands.runnable.mixed_player_entity.commands;

import com.ssomar.particles.commands.XParticle;
import com.ssomar.score.SCore;
import com.ssomar.score.commands.runnable.CommandSetting;
import com.ssomar.score.commands.runnable.CommmandThatRunsCommand;
import com.ssomar.score.commands.runnable.SCommandToExec;
import com.ssomar.score.commands.runnable.mixed_player_entity.MixedCommand;
import com.ssomar.score.configs.messages.Message;
import com.ssomar.score.configs.messages.MessageMain;
import org.bukkit.ChatColor;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Around extends MixedCommand {

    private final static Boolean DEBUG = false;

    public Around() {
        CommandSetting distance = new CommandSetting("distance", 0, Double.class, 3d);
        CommandSetting displayMsgIfNoPlayer = new CommandSetting("displayMsgIfNoPlayer", 1, Boolean.class, true, true);
        CommandSetting throughBlocks = new CommandSetting("throughBlocks", -1, Boolean.class, true);
        CommandSetting safeDistance = new CommandSetting("safeDistance", -1, Double.class, 0d);
        CommandSetting offsetYaw = new CommandSetting("offsetYaw", -1, Double.class, 0d);
        CommandSetting offsetPitch = new CommandSetting("offsetPitch", -1, Double.class, 0d);
        CommandSetting offsetDistance = new CommandSetting("offsetDistance", -1, Double.class, 0d);
        List<CommandSetting> settings = getSettings();
        settings.add(distance);
        settings.add(displayMsgIfNoPlayer);
        settings.add(throughBlocks);
        settings.add(safeDistance);
        settings.add(offsetYaw);
        settings.add(offsetPitch);
        settings.add(offsetDistance);
        setNewSettingsMode(true);
        setCanExecuteCommands(true);
    }

    public static void aroundExecution(Entity receiver, SCommandToExec sCommandToExec, boolean displayMsgIfNoTargetHit) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                double distance = (double) sCommandToExec.getSettingValue("distance");
                boolean throughBlocks = (boolean) sCommandToExec.getSettingValue("throughBlocks");
                double safeDistance = (double) sCommandToExec.getSettingValue("safeDistance");

                double offsetYaw = (double) sCommandToExec.getSettingValue("offsetYaw");
                double offsetPitch = (double) sCommandToExec.getSettingValue("offsetPitch");
                double offsetDistance = (double) sCommandToExec.getSettingValue("offsetDistance");

                Vector offset = XParticle.calculDirection(offsetYaw, offsetPitch).multiply(offsetDistance);
                Location loc = receiver.getLocation().add(offset);

                List<Player> targets = new ArrayList<>();
                for (Entity e : loc.getNearbyEntities(distance, distance, distance)) {
                    if (e instanceof Player) {
                        Player target = (Player) e;

                        if(safeDistance > 0) {
                            Location targetLoc = target.getLocation();
                            if(loc.distance(targetLoc) <= safeDistance) continue;
                        }

                        if(!throughBlocks){
                            Location receiverLoc = receiver.getLocation();
                            if(receiver instanceof LivingEntity) receiverLoc = ((LivingEntity) receiver).getEyeLocation();

                            // Check see feet and yers
                            List<Location> toCheck = new ArrayList<>();
                            toCheck.add(target.getLocation());
                            toCheck.add(target.getEyeLocation());
                            // middle between locatiuon and eyelocation
                            toCheck.add(target.getLocation().add(0, 1, 0));
                            boolean valid = false;
                            for(Location l : toCheck){
                                double distanceBetween = receiverLoc.distance(l);
                                Vector direction = l.toVector().subtract(receiverLoc.toVector()).normalize();
                                RayTraceResult rayTraceResult = receiver.getWorld().rayTraceBlocks(receiverLoc, direction, distanceBetween, FluidCollisionMode.NEVER, true);
                                if(rayTraceResult == null) {
                                    valid = true;
                                    break;
                                }
                            }
                            if(!valid) continue;
                        }

                        if (target.hasMetadata("NPC") || target.equals(receiver)) continue;
                        targets.add(target);
                    }
                }

                boolean hit = CommmandThatRunsCommand.runPlayerCommands(targets, sCommandToExec.getOtherArgs(),sCommandToExec.getActionInfo());

                if (!hit && displayMsgIfNoTargetHit && receiver instanceof Player)
                    sm.sendMessage(receiver, MessageMain.getInstance().getMessage(SCore.plugin, Message.NO_PLAYER_HIT));
            }
        };
        SCore.schedulerHook.runLocationTask(runnable, receiver.getLocation(), 0);
    }





    @Override
    public void run(Player p, Player receiver, SCommandToExec sCommandToExec) {
        aroundExecution(receiver, sCommandToExec, (boolean) sCommandToExec.getSettingValue("displayMsgIfNoPlayer"));
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("AROUND");
        return names;
    }

    @Override
    public String getTemplate() {
        return "AROUND distance:3.0 displayMsgIfNoPlayer:true throughBlocks:true safeDistance:0.0 {Your commands here}";
    }

    @Override
    public ChatColor getColor() {
        return ChatColor.LIGHT_PURPLE;
    }

    @Override
    public ChatColor getExtraColor() {
        return ChatColor.DARK_PURPLE;
    }

    @Override
    public void run(Player p, Entity entity, SCommandToExec sCommandToExec) {
        aroundExecution(entity, sCommandToExec, false);
    }
}
