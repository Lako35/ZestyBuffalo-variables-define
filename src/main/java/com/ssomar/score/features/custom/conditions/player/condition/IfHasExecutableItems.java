package com.ssomar.score.features.custom.conditions.player.condition;

import com.ssomar.score.features.FeatureParentInterface;
import com.ssomar.score.features.custom.conditions.player.PlayerConditionFeature;
import com.ssomar.score.features.custom.conditions.player.PlayerConditionRequest;
import com.ssomar.score.features.custom.ifhas.executableitems.group.HasExecutableItemGroupFeature;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class IfHasExecutableItems extends PlayerConditionFeature<HasExecutableItemGroupFeature, IfHasExecutableItems> {

    public IfHasExecutableItems(FeatureParentInterface parent) {
        super(parent, "ifHasExecutableItems", "If has Executableitems", new String[]{}, Material.ANVIL, false);
    }

    @Override
    public boolean verifCondition(PlayerConditionRequest request) {
        Player player = request.getPlayer();
        if (hasCondition() && !getCondition().verifHas(player.getInventory().getContents(), player.getInventory().getHeldItemSlot())) {
            runInvalidCondition(request);
            return false;
        }
        return true;
    }

    @Override
    public IfHasExecutableItems getValue() {
        return this;
    }

    @Override
    public void subReset() {
        setCondition(new HasExecutableItemGroupFeature(getParent(), "ifHasExecutableItems", "If has Executableitems", new String[]{}, Material.DIAMOND, false, true));
    }

    @Override
    public boolean hasCondition() {
        return !getCondition().getHasExecutableItems().isEmpty();
    }

    @Override
    public IfHasExecutableItems getNewInstance(FeatureParentInterface parent) {
        return new IfHasExecutableItems(parent);
    }
}
