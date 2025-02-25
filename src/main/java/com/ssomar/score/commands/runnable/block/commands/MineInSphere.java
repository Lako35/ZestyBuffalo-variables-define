package com.ssomar.score.commands.runnable.block.commands;

import com.ssomar.score.SCore;
import com.ssomar.score.commands.runnable.ActionInfo;
import com.ssomar.score.commands.runnable.SCommandToExec;
import com.ssomar.score.commands.runnable.block.BlockCommand;
import com.ssomar.score.features.custom.detailedblocks.DetailedBlocks;
import com.ssomar.score.utils.placeholders.StringPlaceholder;
import com.ssomar.score.utils.safebreak.SafeBreak;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/* MINEINSPHERE {radius} {ActiveDrop true or false} */
public class MineInSphere extends BlockCommand {

    /**
     * THIS COMMAND MUST BE DELAYED OF AT LEAST 1 TICK
     * WHY ?
     * TO LET ALL ACTIVATORS OF THE ITEMS BE RUNNED CORRECLTY FIRST
     * BECAUSE THIS COMMAND CAN GENERATE ANOTHER EVENT SO IT CAN CREATE THIS SITUATION
     * X ( activator where this command is )
     * Y ( the new event generates by this command)
     * Y
     * Y
     * X
     * X
     * <p>
     * This situation is bad for the variables edition, example with the same situation and with a increment of the variable by one
     * X 1
     * Y 2
     * Y 3
     * Y 4
     * X 2
     * X 3
     * <p>
     * The delay help us to fix that and let us have:
     * X 1
     * X 2
     * X 3
     * Y 4
     * Y 5
     * Y 6
     **/

    @Override
    public void run(Player p, @NotNull Block block, SCommandToExec sCommandToExec) {
        List<String> args = sCommandToExec.getOtherArgs();
        ActionInfo aInfo = sCommandToExec.getActionInfo();

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                /* Cancel a Loop of blockBreakEvent that MineInCbe can create */
                if (aInfo.isEventFromCustomBreakCommand()) return;

                try {
                    int radius = Integer.parseInt(args.get(0));
                    int radiusSquared = radius * radius;
                    Location origin = block.getLocation();

                    boolean drop = true;
                    if (args.size() >= 2) drop = Boolean.parseBoolean(args.get(1));

                    boolean createBBEvent = true;
                    if (args.size() >= 3) createBBEvent = Boolean.parseBoolean(args.get(2));

                    List<Material> blackList = new ArrayList<>();
                    blackList.add(Material.BEDROCK);
                    blackList.add(Material.AIR);

                    boolean isv18plus = SCore.is1v18Plus();
                    if (radius < 10) {
                        for (int y = -radius; y < radius + 1; y++) {
                            for (int x = -radius; x < radius + 1; x++) {
                                for (int z = -radius; z < radius + 1; z++) {
                                    Location toBreakLoc = new Location(block.getWorld(), block.getX() + x, block.getY() + y, block.getZ() + z);
                                    if (toBreakLoc.distanceSquared(origin) > radiusSquared) continue;

                                    if(isv18plus) {
                                        if ((block.getY() + y) < -64) continue;
                                    }else{
                                        if ((block.getY() + y) < 0) continue;
                                    }

                                    Block toBreak = block.getWorld().getBlockAt(block.getX() + x, block.getY() + y, block.getZ() + z);

                                    DetailedBlocks whiteList;
                                    if ((whiteList = aInfo.getDetailedBlocks()) != null) {
                                        /* I have set playerOpt on empty, otherwise if it will spam the error message if too many blocks are broken with a not valid type */
                                        if (!whiteList.isValid(toBreak, Optional.empty(), null, new StringPlaceholder()))
                                            continue;
                                    }

                                    if (!blackList.contains(toBreak.getType())) {

                                        UUID pUUID = null;
                                        if (p != null) pUUID = p.getUniqueId();
                                        SafeBreak.breakBlockWithEvent(toBreak, pUUID, aInfo.getSlot(), drop, createBBEvent, true);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        };
        SCore.schedulerHook.runTask(runnable3, 1L);
    }

    @Override
    public Optional<String> verify(List<String> args, boolean isFinalVerification) {
        return Optional.empty();
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("MINEINSPHERE");
        return names;
    }

    @Override
    public String getTemplate() {
        return "MINEINSPHERE {radius} {ActiveDrop true or false} {create blockBreakEvent true or false}";
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
