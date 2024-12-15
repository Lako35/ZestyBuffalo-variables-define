package com.ssomar.score.commands.runnable.player.commands;

import com.ssomar.score.commands.runnable.CommandSetting;
import com.ssomar.score.commands.runnable.SCommandToExec;
import com.ssomar.score.commands.runnable.player.PlayerCommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SetItemModel extends PlayerCommand {

    public SetItemModel() {
        CommandSetting slot = new CommandSetting("slot", 0, Integer.class, -1);
        slot.setSlot(true);
        CommandSetting name = new CommandSetting("model", 1, String.class, "minecraft:stone");
        List<CommandSetting> settings = getSettings();
        settings.add(slot);
        settings.add(name);
        setNewSettingsMode(true);
    }

    @Override
    public void run(Player p, Player receiver, SCommandToExec sCommandToExec) {
        ItemStack item;
        ItemMeta itemmeta;
        String name = (String) sCommandToExec.getSettingValue("model");
        int slot = (int) sCommandToExec.getSettingValue("slot");
        if (slot == -1) item = receiver.getInventory().getItemInMainHand();
        else item = receiver.getInventory().getItem(slot);

        if (item == null || item.getType() == Material.AIR) return;
        if (!item.hasItemMeta()) {
            item.setItemMeta(new ItemStack(item.getType()).getItemMeta());
        }

        itemmeta = item.getItemMeta();

        itemmeta.setItemModel(NamespacedKey.fromString(name));

        item.setItemMeta(itemmeta);
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("SET_ITEM_MODEL");
        names.add("SETITEMMODEL");
        return names;
    }

    @Override
    public String getTemplate() {
        return "SET_ITEM_MODEL slot:-1 model:minecraft:stone";
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
