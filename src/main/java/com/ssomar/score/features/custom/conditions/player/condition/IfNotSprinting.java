package com.ssomar.score.features.custom.conditions.player.condition;

import com.ssomar.score.features.FeatureParentInterface;
import com.ssomar.score.features.custom.conditions.player.PlayerConditionFeature;
import com.ssomar.score.features.custom.conditions.player.PlayerConditionRequest;
import com.ssomar.score.features.types.BooleanFeature;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class IfNotSprinting extends PlayerConditionFeature<BooleanFeature, IfNotSprinting> {

    public IfNotSprinting(FeatureParentInterface parent) {
        super(parent, "ifNotSprinting", "If not sprinting", new String[]{}, Material.ANVIL, false);
    }

    @Override
    public boolean verifCondition(PlayerConditionRequest request) {
        Player player = request.getPlayer();
        if (hasCondition() && player.isSprinting()) {
            runInvalidCondition(request);
            return false;
        }
        return true;
    }

    @Override
    public IfNotSprinting getValue() {
        return this;
    }

    @Override
    public void subReset() {
        setCondition(new BooleanFeature(getParent(), "ifNotSprinting", false, "If not sprinting", new String[]{}, Material.LEVER, false, true));
    }

    @Override
    public boolean hasCondition() {
        return getCondition().getValue();
    }

    @Override
    public IfNotSprinting getNewInstance(FeatureParentInterface parent) {
        return new IfNotSprinting(parent);
    }
}
