package com.ssomar.score.features.custom.variables.real;

import com.ssomar.executableitems.ExecutableItems;
import com.ssomar.score.SCore;
import com.ssomar.score.features.custom.variables.base.variable.VariableFeature;
import com.ssomar.score.features.custom.variables.update.variable.VariableUpdateFeature;
import com.ssomar.score.splugin.SPlugin;
import com.ssomar.score.utils.DynamicMeta;
import com.ssomar.score.utils.emums.VariableUpdateType;
import com.ssomar.score.utils.placeholders.StringPlaceholder;
import com.ssomar.score.utils.strings.StringConverter;
import com.ssomar.score.utils.writer.NameSpaceKeyWriterReader;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VariableRealString extends VariableReal<String> implements Serializable {

    public VariableRealString(VariableFeature<String> config, ItemStack item, @NotNull DynamicMeta dMeta) {
        super(config, item, dMeta);
    }

    public VariableRealString(VariableFeature<String> config, PersistentDataContainer dataContainer) {
        super(config, dataContainer);
    }

    public VariableRealString(VariableFeature<String> config, ConfigurationSection configurationSection) {
        super(config, configurationSection);
    }

    public void modifVariable(VariableUpdateFeature update, @Nullable Player p, @Nullable StringPlaceholder sp){
        String modification = update.getStringUpdate().getValue().get();
        if (sp != null) modification = sp.replacePlaceholder(modification);
        if (p != null && SCore.hasPlaceholderAPI) modification = PlaceholderAPI.setPlaceholders(p, modification);

        if (update.getType().getValue().get().equals(VariableUpdateType.MODIFICATION)) {
            setValue(getValue() + modification);
        } else setValue(modification);
    }

    @Override
    public void modifVariable(ItemStack item, @NotNull DynamicMeta dMeta, VariableUpdateFeature update, @Nullable Player p, @Nullable StringPlaceholder sp) {
        modifVariable(update, p, sp);
        writeValue(item, dMeta);
    }

    @Override
    public void modifVariable(PersistentDataContainer dataContainer, VariableUpdateFeature update, @Nullable Player p, @Nullable StringPlaceholder sp) {
        modifVariable(update, p, sp);
        writeValue(dataContainer);
    }

    @Override
    public void modifVariable(@NotNull ConfigurationSection configurationSection, VariableUpdateFeature update, @Nullable Player p, @Nullable StringPlaceholder sp) {
        modifVariable(update, p, sp);
        writeValue(configurationSection);
    }

    @Override
    public Optional<String> readValue(ItemStack item, DynamicMeta dMeta) {
        getItemKeyWriterReader().writeStringIfNull((SPlugin) SCore.plugin, item, dMeta, "SCORE-" + getConfig().getVariableName().getValue().get().toUpperCase(), (String) getConfig().getDefaultValue());

        Optional<String> value;
        Optional<String> potentialOldEIValue;
        if(SCore.hasExecutableItems && (potentialOldEIValue = getItemKeyWriterReader().readString(ExecutableItems.plugin, item, dMeta, "EI-" + getConfig().getVariableName().getValue().get().toUpperCase())).isPresent()){
            value = potentialOldEIValue;
            setValue(value.get());
            writeValue(item, dMeta);
        }
        else value = getItemKeyWriterReader().readString(SCore.plugin, item, dMeta, "SCORE-" + getConfig().getVariableName().getValue().get().toUpperCase());
        return value;
    }

    @Override
    public Optional<String> readValue(PersistentDataContainer dataContainer) {
        NameSpaceKeyWriterReader.writeStringIfNull((SPlugin) SCore.plugin, dataContainer,"SCORE-" + getConfig().getVariableName().getValue().get().toUpperCase(), (String) getConfig().getDefaultValue());

        Optional<String> value;
        Optional<String> potentialOldEIValue;
        if(SCore.hasExecutableItems && (potentialOldEIValue = NameSpaceKeyWriterReader.readString(ExecutableItems.plugin, dataContainer,"EI-" + getConfig().getVariableName().getValue().get().toUpperCase())).isPresent()){
            value = potentialOldEIValue;
            setValue(value.get());
            writeValue(dataContainer);
        }
        else value = NameSpaceKeyWriterReader.readString(SCore.plugin, dataContainer, "SCORE-" + getConfig().getVariableName().getValue().get().toUpperCase());
        return value;
    }

    @Override
    public Optional<String> readValue(ConfigurationSection configurationSection) {
        String varUpper = getConfig().getVariableName().getValue().get().toUpperCase();
        if(!configurationSection.contains(varUpper)) configurationSection.set(varUpper, getConfig().getDefaultValue());
        return Optional.ofNullable(configurationSection.getString(varUpper));
    }

    @Override
    public void writeValue(ItemStack item, DynamicMeta dMeta) {
        getItemKeyWriterReader().writeString(SCore.plugin, item, dMeta, "SCORE-" + getConfig().getVariableName().getValue().get().toUpperCase(), getValue());
    }

    @Override
    public void writeValue(PersistentDataContainer dataContainer) {
        NameSpaceKeyWriterReader.writeString(SCore.plugin, dataContainer,"SCORE-" + getConfig().getVariableName().getValue().get().toUpperCase(), getValue());
    }

    @Override
    public void writeValue(ConfigurationSection configurationSection) {
        configurationSection.set(getConfig().getVariableName().getValue().get().toUpperCase(), getValue());
    }

    @Override
    public String replaceVariablePlaceholder(String s, boolean includeRefreshTag) {

        boolean isRefreshable = includeRefreshTag && getConfig().getIsRefreshableClean().getValue();
        String optTag = isRefreshable ? getConfig().getRefreshTag().getValue().get() : "";

        String toReplace = "%var_" + getConfig().getVariableName().getValue().get() + "%";
        if (s.contains(toReplace)) {
            s = s.replaceAll(toReplace, optTag + StringConverter.coloredString(getValue()) + (isRefreshable ? getPlaceholderTag(toReplace) : "")+ optTag);
        }
        return s;
    }

    @Override
    public String getPlaceholderWithTag(String s) {
        Map<String, String> tags = getTranscoPlaceholders();
        for (Map.Entry<String, String> entry : tags.entrySet()) {
            if (s.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return "";
    }

    public Map<String, String> getTranscoPlaceholders() {
        Map<String, String> tags = new HashMap<>();
        tags.put("§汉", "%var_" + getConfig().getVariableName().getValue().get() + "%");
        return tags;
    }

    public String getPlaceholderTag(String placeholder) {
        Map<String, String> tags = getTranscoPlaceholders();
        for (Map.Entry<String, String> entry : tags.entrySet()) {
            if (entry.getValue().equals(placeholder)) {
                return entry.getKey();
            }
        }
        return "";
    }

    @Override
    public String replaceVariablePlaceholder(String s) {
        return replaceVariablePlaceholder(s, false);
    }
}
