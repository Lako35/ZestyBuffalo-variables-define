package com.ssomar.score.features.custom.conditions.entity.condition;

import com.ssomar.score.features.FeatureParentInterface;
import com.ssomar.score.features.custom.conditions.entity.EntityConditionFeature;
import com.ssomar.score.features.custom.conditions.entity.EntityConditionRequest;
import com.ssomar.score.features.types.BooleanFeature;
import org.bukkit.Material;
import org.bukkit.entity.Entity;

public class IfInvulnerable extends EntityConditionFeature<BooleanFeature, IfInvulnerable> {

    public IfInvulnerable(FeatureParentInterface parent) {
        super(parent, "ifInvulnerable", "If invulnerable", new String[]{}, Material.ANVIL, false);
    }

    @Override
    public boolean verifCondition(EntityConditionRequest request) {
        Entity entity = request.getEntity();
        if (hasCondition() && !entity.isInvulnerable()) {
            runInvalidCondition(request);
            return false;
        }
        return true;
    }

    @Override
    public IfInvulnerable getValue() {
        return this;
    }

    @Override
    public void subReset() {
        setCondition(new BooleanFeature(getParent(), "ifInvulnerable", false, "If invulnerable", new String[]{}, Material.ANVIL, false, true));
    }

    @Override
    public boolean hasCondition() {
        return getCondition().getValue();
    }

    @Override
    public IfInvulnerable getNewInstance(FeatureParentInterface parent) {
        return new IfInvulnerable(parent);
    }
}
