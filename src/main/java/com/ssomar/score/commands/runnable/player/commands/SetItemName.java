package com.ssomar.score.commands.runnable.player.commands;

import com.ssomar.score.commands.runnable.ArgumentChecker;
import com.ssomar.score.commands.runnable.SCommandToExec;
import com.ssomar.score.commands.runnable.player.PlayerCommand;
import com.ssomar.score.utils.strings.StringConverter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* SETITEMNAME {slot} {text} */
public class SetItemName extends PlayerCommand {

    @Override
    public void run(Player p, Player receiver, SCommandToExec sCommandToExec) {
        List<String> args = sCommandToExec.getOtherArgs();

        ItemStack item;
        ItemMeta itemmeta;

        int slot = Integer.valueOf(args.get(0));

        try {
            if(slot == -1) item = receiver.getInventory().getItemInMainHand();
            else item = receiver.getInventory().getItem(slot);

            itemmeta = item.getItemMeta();
        } catch (NullPointerException e) {
            return;
        }

        StringBuilder build = new StringBuilder();

        for (int i = 1; i < args.size(); i++) {
            build.append(args.get(i) + " ");
        }

        itemmeta.setDisplayName(StringConverter.coloredString(build.toString()));

        item.setItemMeta(itemmeta);
    }

    @Override
    public Optional<String> verify(List<String> args, boolean isFinalVerification) {
        if (args.size() < 2) return Optional.of(notEnoughArgs + getTemplate());

        ArgumentChecker ac = checkInteger(args.get(0), isFinalVerification, getTemplate());
        if (!ac.isValid()) return Optional.of(ac.getError());

        return Optional.empty();
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("SETITEMNAME");
        return names;
    }

    @Override
    public String getTemplate() {
        return "SETITEMNAME {slot} {text dont need brackets}";
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
