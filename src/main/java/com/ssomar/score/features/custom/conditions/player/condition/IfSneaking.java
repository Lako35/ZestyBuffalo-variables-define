package com.ssomar.score.features.custom.conditions.player.condition;

import com.ssomar.score.features.FeatureParentInterface;
import com.ssomar.score.features.custom.conditions.player.PlayerConditionFeature;
import com.ssomar.score.features.custom.conditions.player.PlayerConditionRequest;
import com.ssomar.score.features.types.BooleanFeature;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class IfSneaking extends PlayerConditionFeature<BooleanFeature, IfSneaking> {


    public IfSneaking(FeatureParentInterface parent) {
        super(parent, "ifSneaking", "If sneaking", new String[]{}, Material.ANVIL, false);
    }

    @Override
    public boolean verifCondition(PlayerConditionRequest request) {
        Player player = request.getPlayer();
        if (hasCondition() && !player.isSneaking()) {
            runInvalidCondition(request);
            return false;
        }
        return true;
    }

    @Override
    public IfSneaking getValue() {
        return this;
    }

    @Override
    public void subReset() {
        setCondition(new BooleanFeature(getParent(), "ifSneaking", false, "If sneaking", new String[]{}, Material.LEVER, false, true));
    }

    @Override
    public boolean hasCondition() {
        return getCondition().getValue();
    }

    @Override
    public IfSneaking getNewInstance(FeatureParentInterface parent) {
        return new IfSneaking(parent);
    }
}
