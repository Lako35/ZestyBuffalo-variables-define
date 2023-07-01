package com.ssomar.score.features.custom.conditions.block.condition;

import com.ssomar.score.features.FeatureParentInterface;
import com.ssomar.score.features.custom.conditions.block.BlockConditionFeature;
import com.ssomar.score.features.custom.conditions.block.BlockConditionRequest;
import com.ssomar.score.features.types.BooleanFeature;
import com.ssomar.score.usedapi.MyCoreProtectAPI;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class IfMustBeNatural extends BlockConditionFeature<BooleanFeature, IfMustBeNatural> {

    public IfMustBeNatural(FeatureParentInterface parent) {
        super(parent, "ifMustBeNatural", "If must be natural", new String[]{}, Material.ANVIL, false);
    }

    @Override
    public boolean hasCondition() {
        return getCondition().getValue();
    }

    @Override
    public boolean verifCondition(BlockConditionRequest request) {
        if (hasCondition()) {
            Block b = request.getBlock();
            if (!MyCoreProtectAPI.isNaturalBlock(b)) {
                runInvalidCondition(request);
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
    public void subReset() {
        setCondition(new BooleanFeature(getParent(), "ifMustBeNatural", false, "If must be natural", new String[]{}, Material.ANVIL, false, true));
    }

    @Override
    public IfMustBeNatural getNewInstance(FeatureParentInterface parent) {
        return new IfMustBeNatural(parent);
    }

}
