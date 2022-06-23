package com.ssomar.scoretestrecode.features.custom.variables.update.group;

import com.ssomar.score.menu.GUI;
import com.ssomar.score.splugin.SPlugin;
import com.ssomar.scoretestrecode.editor.NewGUIManager;
import com.ssomar.scoretestrecode.features.FeatureInterface;
import com.ssomar.scoretestrecode.features.FeatureParentInterface;
import com.ssomar.scoretestrecode.features.FeatureWithHisOwnEditor;
import com.ssomar.scoretestrecode.features.FeaturesGroup;
import com.ssomar.scoretestrecode.features.custom.variables.update.variable.VariableUpdateFeature;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter @Setter
public class VariableUpdateGroupFeature extends FeatureWithHisOwnEditor<VariableUpdateGroupFeature, VariableUpdateGroupFeature, VariableUpdateGroupFeatureEditor, VariableUpdateGroupFeatureEditorManager> implements FeaturesGroup<VariableUpdateFeature> {

    private Map<String, VariableUpdateFeature> variablesUpdates;

    public VariableUpdateGroupFeature(FeatureParentInterface parent) {
        super(parent, "variables", "Variables", new String[]{"&7&oThe variables"}, GUI.WRITABLE_BOOK, false);
        reset();
    }

    @Override
    public void reset() {
        this.variablesUpdates = new HashMap<>();
    }

    @Override
    public List<String> load(SPlugin plugin, ConfigurationSection config, boolean isPremiumLoading) {
        List<String> error = new ArrayList<>();
        if(config.isConfigurationSection(this.getName())) {
            ConfigurationSection enchantmentsSection = config.getConfigurationSection(this.getName());
            for(String attributeID : enchantmentsSection.getKeys(false)) {
                VariableUpdateFeature attribute = new VariableUpdateFeature(this, attributeID);
                List<String> subErrors = attribute.load(plugin, enchantmentsSection, isPremiumLoading);
                if (subErrors.size() > 0) {
                    error.addAll(subErrors);
                    continue;
                }
                variablesUpdates.put(attributeID, attribute);
            }
        }
        return error;
    }

    @Override
    public void save(ConfigurationSection config) {
        config.set(this.getName(), null);
        ConfigurationSection attributesSection = config.createSection(this.getName());
        for(String enchantmentID : variablesUpdates.keySet()) {
            variablesUpdates.get(enchantmentID).save(attributesSection);
        }
    }

    @Override
    public VariableUpdateGroupFeature getValue() {
        return this;
    }

    @Override
    public VariableUpdateGroupFeature initItemParentEditor(GUI gui, int slot) {
        String[] finalDescription = new String[getEditorDescription().length + 2];
        System.arraycopy(getEditorDescription(), 0, finalDescription, 0, getEditorDescription().length);
        finalDescription[finalDescription.length -2] = gui.CLICK_HERE_TO_CHANGE;
        finalDescription[finalDescription.length -1] = "&7&oVariable(s) added: &e"+ variablesUpdates.size();

        gui.createItem(getEditorMaterial(), 1, slot, gui.TITLE_COLOR + getEditorName(), false, false, finalDescription);
        return this;
    }

    @Override
    public void updateItemParentEditor(GUI gui) {

    }

    @Override
    public void extractInfoFromParentEditor(NewGUIManager manager, Player player) {

    }

    @Override
    public VariableUpdateGroupFeature clone() {
        VariableUpdateGroupFeature eF = new VariableUpdateGroupFeature(getParent());
        eF.setVariablesUpdates(new HashMap<>(this.getVariablesUpdates()));
        return eF;
    }

    @Override
    public List<FeatureInterface> getFeatures() {
        return new ArrayList<>(variablesUpdates.values());
    }

    @Override
    public String getParentInfo() {
        return getParent().getParentInfo();
    }

    @Override
    public ConfigurationSection getConfigurationSection() {
        ConfigurationSection section = getParent().getConfigurationSection();
        if(section.isConfigurationSection(this.getName())) {
            return section.getConfigurationSection(this.getName());
        }
        else return section.createSection(this.getName());
    }

    @Override
    public File getFile() {
        return getParent().getFile();
    }

    @Override
    public void reload() {
        for(FeatureInterface feature : getParent().getFeatures()) {
            if(feature instanceof VariableUpdateGroupFeature) {
                VariableUpdateGroupFeature eF = (VariableUpdateGroupFeature) feature;
                eF.setVariablesUpdates(this.getVariablesUpdates());
                break;
            }
        }
    }

    @Override
    public void openBackEditor(@NotNull Player player) {
        getParent().openEditor(player);
    }

    @Override
    public void openEditor(@NotNull Player player) {
        VariableUpdateGroupFeatureEditorManager.getInstance().startEditing(player, this);
    }

    @Override
    public void createNewFeature(@NotNull Player editor) {
        String baseId = "varUpdt";
        for(int i = 0; i < 1000; i++) {
            String id = baseId + i;
            if(!variablesUpdates.containsKey(id)) {
                VariableUpdateFeature eF = new VariableUpdateFeature(this, id);
                variablesUpdates.put(id, eF);
                eF.openEditor(editor);
                break;
            }
        }
    }

    @Override
    public void deleteFeature(@NotNull Player editor, VariableUpdateFeature feature) {
        variablesUpdates.remove(feature.getId());
    }

}
