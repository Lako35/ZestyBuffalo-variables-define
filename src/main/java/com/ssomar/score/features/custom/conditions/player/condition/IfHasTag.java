package com.ssomar.score.features.custom.conditions.player.condition;

import com.ssomar.score.features.FeatureParentInterface;
import com.ssomar.score.features.custom.conditions.player.PlayerConditionFeature;
import com.ssomar.score.features.custom.conditions.player.PlayerConditionRequest;
import com.ssomar.score.features.types.list.ListUncoloredStringFeature;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Optional;

public class IfHasTag extends PlayerConditionFeature<ListUncoloredStringFeature, IfHasTag> {

    public IfHasTag(FeatureParentInterface parent) {
        super(parent, "ifHasTag", "If has tag", new String[]{}, Material.ANVIL, false);
    }

    @Override
    public boolean verifCondition(PlayerConditionRequest request) {
        Player player = request.getPlayer();
        if (hasCondition()) {
            boolean notValid = false;
            for (String tag : getCondition().getValue()) {
                if (!player.getScoreboardTags().contains(tag)) {
                    notValid = true;
                    break;
                }
            }
            if (notValid) {
                runInvalidCondition(request);
                return false;
            }
        }
        return true;
    }

    @Override
    public IfHasTag getValue() {
        return this;
    }

    @Override
    public void subReset() {
        setCondition(new ListUncoloredStringFeature(getParent(), "ifHasTag", new ArrayList<>(), "If has tag", new String[]{}, Material.ANVIL, false, true, Optional.empty()));
    }

    @Override
    public boolean hasCondition() {
        return getCondition().getValue().size() > 0;
    }

    @Override
    public IfHasTag getNewInstance(FeatureParentInterface parent) {
        return new IfHasTag(parent);
    }
}
