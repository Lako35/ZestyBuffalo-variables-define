package com.ssomar.testRecode.features.custom.conditions.block.condition;

import com.ssomar.score.menu.GUI;
import com.ssomar.score.usedapi.MyCoreProtectAPI;
import com.ssomar.score.utils.SendMessage;
import com.ssomar.testRecode.features.FeatureParentInterface;
import com.ssomar.testRecode.features.custom.conditions.block.BlockConditionFeature;
import com.ssomar.testRecode.features.types.BooleanFeature;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.Optional;

public class IfMustBeNatural extends BlockConditionFeature<BooleanFeature, IfMustBeNatural> {

    public IfMustBeNatural(FeatureParentInterface parent) {
        super(parent, "", "", new String[]{}, Material.ANVIL, false);
    }

    @Override
    public boolean verifCondition(Block b, Optional<Player> playerOpt, SendMessage messangeSender, Event event) {
        if (getCondition().getValue()) {
            if (!MyCoreProtectAPI.isNaturalBlock(b)) {
                sendErrorMsg(playerOpt, messangeSender);
                cancelEvent(event);
                return false;
            }
        }
        return true;
    }

    @Override
    public IfMustBeNatural getValue() {
        return this;
    }

    @Override
    public String [] getEditorDescription(){
        String [] finalDescription = new String[super.getEditorDescription().length + 1];
        if(getCondition().getValue())
            finalDescription[finalDescription.length - 1] = "&7Enable: &a&l✔";
        else
            finalDescription[finalDescription.length - 1] = "&7Enable: &c&l✘";
        return finalDescription;
    }

    @Override
    public IfMustBeNatural initItemParentEditor(GUI gui, int slot) {
        return null;
    }

    @Override
    public void subReset() {
        setCondition(new BooleanFeature(getParent(), "ifMustBeNatural", false, "If must be natural", new String[]{}, Material.ANVIL, false));
    }

    @Override
    public IfMustBeNatural getNewInstance() {
        return new IfMustBeNatural(getParent());
    }

}
