package com.ssomar.score.sobject.sactivator.conditions.condition.worldcondition.basics;

import com.ssomar.score.sobject.sactivator.conditions.condition.ConditionType;
import com.ssomar.score.sobject.sactivator.conditions.condition.worldcondition.WorldCondition;
import com.ssomar.score.utils.SendMessage;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IfWeather extends WorldCondition<List<String>> {


    public IfWeather() {
        super(ConditionType.WEATHER_LIST, "ifWeather", "If weather", new String[]{}, new ArrayList<>(), " &cThe weather must change to active the activator: &6%activator% &cof this item!");
    }

    @Override
    public boolean verifCondition(World world, Optional<Player> playerOpt, SendMessage messangeSender) {
        if(getCondition() != null && getCondition().size() > 0) {
            String currentW = "";
            if(world.isThundering()) currentW = "STORM";

            else if(world.hasStorm()) currentW = "RAIN";
            else currentW = "CLEAR";

            if(!getCondition().contains(currentW)) {
                sendErrorMsg(playerOpt, messangeSender);
                return false;
            }
        }
        return true;
    }
}
