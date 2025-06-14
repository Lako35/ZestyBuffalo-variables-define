package com.ssomar.score.commands.runnable.player.commands;

import com.ssomar.score.SCore;
import com.ssomar.score.commands.runnable.CommandSetting;
import com.ssomar.score.commands.runnable.SCommandToExec;
import com.ssomar.score.commands.runnable.player.PlayerCommand;
import com.ssomar.score.utils.EntityBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class SpawnEntityOnCursor extends PlayerCommand {

    public SpawnEntityOnCursor() {
        CommandSetting entity = new CommandSetting("entity", 0, EntityBuilder.class, "ZOMBIE");
        CommandSetting amount = new CommandSetting("amount", 1, Integer.class, 1);
        CommandSetting maxRange = new CommandSetting("maxRange", 2, Integer.class, 200);
        List<CommandSetting> settings = getSettings();
        settings.add(entity);
        settings.add(amount);
        settings.add(maxRange);
        setNewSettingsMode(true);
    }

    @Override
    public void run(Player p, Player receiver, SCommandToExec sCommandToExec) {
        int range = (int) sCommandToExec.getSettingValue("maxRange");
        int amount = (int) sCommandToExec.getSettingValue("amount");

        EntityBuilder entityBuilder = (EntityBuilder) sCommandToExec.getSettingValue("entity");

        Block block = receiver.getTargetBlock(null, range);

        if (!block.getType().equals(Material.AIR)) {

            Location loc = block.getLocation();
            loc.add(0, 1, 0);

            // Can be null
            EntityType toSpawnEntityType = entityBuilder.getEntityType();
            EntityType lightning = SCore.is1v20v5Plus() ? EntityType.LIGHTNING_BOLT : EntityType.valueOf("LIGHTNING");

            for (int i = 0; i < amount; i++) {

                if (toSpawnEntityType != null && toSpawnEntityType.equals(lightning)) {
                    receiver.getWorld().strikeLightning(loc);
                    continue;
                }

                Entity e = entityBuilder.buildEntity(loc);
                if (toSpawnEntityType != null && toSpawnEntityType.equals(EntityType.FIREBALL))
                    e.setVelocity(new Vector(0, 0, 0));
            }
        }
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("SPAWN_ENTITY_ON_CURSOR");
        names.add("SPAWNENTITYONCURSOR");
        return names;
    }

    @Override
    public String getTemplate() {
        return "SPAWN_ENTITY_ON_CURSOR entity:ZOMBIE amount:1 maxRange:200";
    }

    @Override
    public ChatColor getColor() {
        return null;
    }

    @Override
    public ChatColor getExtraColor() {
        return null;
    }

}
