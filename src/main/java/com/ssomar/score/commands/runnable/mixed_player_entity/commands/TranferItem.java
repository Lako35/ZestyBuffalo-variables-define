package com.ssomar.score.commands.runnable.mixed_player_entity.commands;

import com.ssomar.score.SsomarDev;
import com.ssomar.score.api.executableitems.events.AddItemInPlayerInventoryEvent;
import com.ssomar.score.api.executableitems.events.RemoveItemInPlayerInventoryEvent;
import com.ssomar.score.commands.runnable.ArgumentChecker;
import com.ssomar.score.commands.runnable.SCommandToExec;
import com.ssomar.score.commands.runnable.mixed_player_entity.MixedCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TranferItem extends MixedCommand {

    @Override
    public void run(Player p, Entity receiver, SCommandToExec sCommandToExec) {
        SsomarDev.testMsg("TranferItem", true);
        List<String> args = sCommandToExec.getOtherArgs();

        int initalSlot = Double.valueOf(args.get(0)).intValue();

        ItemStack toTransfer = null;
        PlayerInventory inventory = p.getInventory();
        if (initalSlot == -1)
            initalSlot = inventory.getHeldItemSlot();
        toTransfer = inventory.getItem(initalSlot);
        inventory.clear(initalSlot);

        if (toTransfer == null) return;

        RemoveItemInPlayerInventoryEvent eventToCall = new RemoveItemInPlayerInventoryEvent(p, toTransfer, initalSlot);
        Bukkit.getPluginManager().callEvent(eventToCall);

        int slot = Double.valueOf(args.get(1)).intValue();

        boolean drop = false;
        if(args.size() > 2) drop = Boolean.parseBoolean(args.get(2));

        ItemStack toDrop = null;
        if (receiver instanceof Player) {
            Player pReceiver = (Player) receiver;
            PlayerInventory inventory2 = pReceiver.getInventory();
            if (slot == -1)
                slot = inventory2.getHeldItemSlot();
            toDrop = inventory2.getItem(slot);
            SsomarDev.testMsg("TranferItem toDrop: " + toDrop, true);
            inventory2.setItem(slot, toTransfer);

            /* Call add event only for player */
            AddItemInPlayerInventoryEvent eventToCall2 = new AddItemInPlayerInventoryEvent(pReceiver, toTransfer, slot);
            Bukkit.getPluginManager().callEvent(eventToCall2);

            /* Call remove event for the receiver */
            RemoveItemInPlayerInventoryEvent eventToCall3 = new RemoveItemInPlayerInventoryEvent(pReceiver, toDrop, slot);
            Bukkit.getPluginManager().callEvent(eventToCall3);
        } else {
            if (!(receiver instanceof LivingEntity)) {
                SsomarDev.testMsg("TranferItem Receiver is not a player or a living entity", true);
                return;
            }
            LivingEntity livingReceiver = (LivingEntity) receiver;
            EntityEquipment equipment = livingReceiver.getEquipment();
            if (equipment == null) {
                SsomarDev.testMsg("TranferItem Receiver has no equipment", true);
                return;
            }
            switch (slot) {
                case -1: {
                    toDrop = equipment.getItemInMainHand();
                    equipment.setItemInMainHand(toTransfer);
                    break;
                }
                case 40: {
                    toDrop = equipment.getItemInOffHand();
                    equipment.setItemInOffHand(toTransfer);
                    break;
                }
                case 36: {
                    toDrop = equipment.getBoots();
                    equipment.setBoots(toTransfer);
                    break;
                }
                case 37: {
                    toDrop = equipment.getLeggings();
                    equipment.setLeggings(toTransfer);
                    break;
                }
                case 38: {
                    toDrop = equipment.getChestplate();
                    equipment.setChestplate(toTransfer);
                    break;
                }
                case 39: {
                    toDrop = equipment.getHelmet();
                    equipment.setHelmet(toTransfer);
                    break;
                }
            }
        }
        if (toDrop != null){
            SsomarDev.testMsg("TranferItem toDrop end: " + toDrop, true);
            if(drop) receiver.getLocation().getWorld().dropItem(receiver.getLocation(), toDrop);
            else {
                inventory.setItem(initalSlot, toDrop);
                /* Call add event for the player */
                AddItemInPlayerInventoryEvent eventToCall4 = new AddItemInPlayerInventoryEvent(p, toDrop, initalSlot);
                Bukkit.getPluginManager().callEvent(eventToCall4);
            }
        }
    }


    @Override
    public Optional<String> verify(List<String> args, boolean isFinalVerification) {

        if (args.size() < 2) return Optional.of(notEnoughArgs + getTemplate());

        ArgumentChecker ac = checkSlot(args.get(0), isFinalVerification, getTemplate());
        if (!ac.isValid()) return Optional.of(ac.getError());

        ArgumentChecker ac2 = checkSlot(args.get(1), isFinalVerification, getTemplate());
        if (!ac2.isValid()) return Optional.of(ac2.getError());

        return Optional.empty();
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("TRANSFER_ITEM");
        return names;
    }

    @Override
    public String getTemplate() {
        return "TRANSFER_ITEM {slot of launcher} {slot of receiver} [boolean drop]";
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
