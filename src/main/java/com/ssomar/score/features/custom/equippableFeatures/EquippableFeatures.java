package com.ssomar.score.features.custom.equippableFeatures;

import com.ssomar.score.SCore;
import com.ssomar.score.features.*;
import com.ssomar.score.features.editor.GenericFeatureParentEditor;
import com.ssomar.score.features.editor.GenericFeatureParentEditorManager;
import com.ssomar.score.features.types.BooleanFeature;
import com.ssomar.score.features.types.SlotFeature;
import com.ssomar.score.features.types.SoundFeature;
import com.ssomar.score.features.types.UncoloredStringFeature;
import com.ssomar.score.features.types.list.ListEntityTypeFeature;
import com.ssomar.score.menu.GUI;
import com.ssomar.score.splugin.SPlugin;
import com.ssomar.score.utils.backward_compatibility.SoundUtils;
import com.ssomar.score.utils.emums.AttributeSlot;
import com.ssomar.score.utils.emums.ResetSetting;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class EquippableFeatures extends FeatureWithHisOwnEditor<EquippableFeatures, EquippableFeatures, GenericFeatureParentEditor, GenericFeatureParentEditorManager> implements FeatureForItem {

    private BooleanFeature enable;
    private SlotFeature slot;
    private BooleanFeature enableSound;
    private SoundFeature sound;

    private UncoloredStringFeature model;
    private UncoloredStringFeature cameraOverlay;

    private BooleanFeature isDamageableOnHurt;
    private BooleanFeature isDispensable;
    private BooleanFeature isSwappable;

    private ListEntityTypeFeature allowedEntities;

    public EquippableFeatures(FeatureParentInterface parent) {
        super(parent, FeatureSettingsSCore.equippableFeatures);
        reset();
    }

    @Override
    public void reset() {
        enable = new BooleanFeature(this, false, FeatureSettingsSCore.enable, false);
        slot = new SlotFeature(this,  Optional.of(AttributeSlot.BODY), FeatureSettingsSCore.slot);
        slot.setOnlyArmorSlots(true);
        enableSound = new BooleanFeature(this, false, FeatureSettingsSCore.enableSound, false);
        sound = new SoundFeature(this, Optional.of(Sound.ITEM_ARMOR_EQUIP_DIAMOND), FeatureSettingsSCore.sound);
        model = new UncoloredStringFeature(this, Optional.empty(), FeatureSettingsSCore.equipModel, false);
        cameraOverlay = new UncoloredStringFeature(this, Optional.empty(), FeatureSettingsSCore.cameraOverlay, false);
        isDamageableOnHurt = new BooleanFeature(this, false, FeatureSettingsSCore.damageableOnHurt, false);
        isDispensable = new BooleanFeature(this, true, FeatureSettingsSCore.dispensable, false);
        isSwappable = new BooleanFeature(this, true, FeatureSettingsSCore.swappable, false);
        allowedEntities = new ListEntityTypeFeature(this, new ArrayList<>(Collections.singleton(EntityType.PLAYER)), FeatureSettingsSCore.allowedEntities, false);
    }

    @Override
    public List<String> load(SPlugin plugin, ConfigurationSection config, boolean isPremiumLoading) {
        List<String> errors = new ArrayList<>();
        if (config.isConfigurationSection(getName())) {
            ConfigurationSection section = config.getConfigurationSection(getName());
            for (FeatureInterface feature : getFeatures()) {
                errors.addAll(feature.load(plugin, section, isPremiumLoading));
            }

        }

        return errors;
    }

    @Override
    public void save(ConfigurationSection config) {
        config.set(getName(), null);
        ConfigurationSection section = config.createSection(getName());
        for (FeatureInterface feature : getFeatures()) {
            feature.save(section);
        }
    }

    @Override
    public EquippableFeatures getValue() {
        return this;
    }

    @Override
    public EquippableFeatures initItemParentEditor(GUI gui, int slot) {
        int len = 11;
        String[] finalDescription = new String[getEditorDescription().length + len];
        System.arraycopy(getEditorDescription(), 0, finalDescription, 0, getEditorDescription().length);
        finalDescription[finalDescription.length - len] = GUI.CLICK_HERE_TO_CHANGE;
        len--;

        finalDescription[finalDescription.length - len] = "&7Enable: &e" + (enable.getValue() ? "&a&l✔" : "&c&l✘");
        len--;
        finalDescription[finalDescription.length - len] = "&7Slot: &e" + this.slot.getValue().get();
        len--;
        finalDescription[finalDescription.length - len] = "&7Enable Sound: &e" + (enableSound.getValue() ? "&a&l✔" : "&c&l✘");
        len--;
        finalDescription[finalDescription.length - len] = "&7Sound: &e" + SoundUtils.getSounds().get(sound.getValue().get());
        len--;
        finalDescription[finalDescription.length - len] = "&7Model: &e" + model.getValue().orElse("");
        len--;
        finalDescription[finalDescription.length - len] = "&7Camera Overlay: &e" + cameraOverlay.getValue().orElse("");
        len--;
        finalDescription[finalDescription.length - len] = "&7Is Damageable On Hurt: &e" + (isDamageableOnHurt.getValue() ? "&a&l✔" : "&c&l✘");
        len--;
        finalDescription[finalDescription.length - len] = "&7Is Dispensable: &e" + (isDispensable.getValue() ? "&a&l✔" : "&c&l✘");
        len--;
        finalDescription[finalDescription.length - len] = "&7Is Swappable: &e" + (isSwappable.getValue() ? "&a&l✔" : "&c&l✘");
        len--;
        finalDescription[finalDescription.length - len] = "&7Allowed Entities: &e" + allowedEntities.getValue();
        len--;

        gui.createItem(getEditorMaterial(), 1, slot, GUI.TITLE_COLOR + getEditorName(), false, false, finalDescription);
        return this;
    }

    @Override
    public void updateItemParentEditor(GUI gui) {

    }

    @Override
    public EquippableFeatures clone(FeatureParentInterface newParent) {
        EquippableFeatures dropFeatures = new EquippableFeatures(newParent);
        dropFeatures.setEnable(enable.clone(dropFeatures));
        dropFeatures.setSlot(slot.clone(dropFeatures));
        dropFeatures.setEnableSound(enableSound.clone(dropFeatures));
        dropFeatures.setSound(sound.clone(dropFeatures));
        dropFeatures.setModel(model.clone(dropFeatures));
        dropFeatures.setCameraOverlay(cameraOverlay.clone(dropFeatures));
        dropFeatures.setIsDamageableOnHurt(isDamageableOnHurt.clone(dropFeatures));
        dropFeatures.setIsDispensable(isDispensable.clone(dropFeatures));
        dropFeatures.setIsSwappable(isSwappable.clone(dropFeatures));
        dropFeatures.setAllowedEntities(allowedEntities.clone(dropFeatures));

        return dropFeatures;
    }

    @Override
    public List<FeatureInterface> getFeatures() {
        List<FeatureInterface> features = new ArrayList<>();
        features.add(enable);
        features.add(slot);
        features.add(enableSound);
        features.add(sound);
        features.add(model);
        features.add(cameraOverlay);
        features.add(isDamageableOnHurt);
        features.add(isDispensable);
        features.add(isSwappable);
        features.add(allowedEntities);
        return features;
    }

    @Override
    public String getParentInfo() {
        return getParent().getParentInfo();
    }

    @Override
    public ConfigurationSection getConfigurationSection() {
        return getParent().getConfigurationSection();
    }

    @Override
    public File getFile() {
        return getParent().getFile();
    }

    @Override
    public void reload() {
        for (FeatureInterface feature : (List<FeatureInterface>) getParent().getFeatures()) {
            if (feature instanceof EquippableFeatures) {
                EquippableFeatures hiders = (EquippableFeatures) feature;
                hiders.setEnable(enable);
                hiders.setSlot(slot);
                hiders.setEnableSound(enableSound);
                hiders.setSound(sound);
                hiders.setModel(model);
                hiders.setCameraOverlay(cameraOverlay);
                hiders.setIsDamageableOnHurt(isDamageableOnHurt);
                hiders.setIsDispensable(isDispensable);
                hiders.setIsSwappable(isSwappable);
                hiders.setAllowedEntities(allowedEntities);
            }
        }
    }

    @Override
    public void openBackEditor(@NotNull Player player) {
        getParent().openEditor(player);
    }

    @Override
    public void openEditor(@NotNull Player player) {
        GenericFeatureParentEditorManager.getInstance().startEditing(player, this);
    }

    @Override
    public boolean isAvailable() {
        return SCore.is1v21v2Plus();
    }

    @Override
    public boolean isApplicable(@NotNull FeatureForItemArgs args) {
        return true;
    }

    @Override
    public void applyOnItemMeta(@NotNull FeatureForItemArgs args) {
        if (isAvailable()) {
            if (enable.getValue()) {
                ItemMeta meta = args.getMeta();
                EquippableComponent equippable = meta.getEquippable();
                equippable.setSlot(slot.getEquipmentSlotValue().get());
                if (enableSound.getValue()) {
                    equippable.setEquipSound(sound.getValue().get());
                }
                if (!model.getValue().orElse("").isEmpty()) {
                    equippable.setModel(NamespacedKey.fromString(model.getValue().get()));
                }
                if (!cameraOverlay.getValue().orElse("").isEmpty()) {
                    equippable.setCameraOverlay(NamespacedKey.fromString(cameraOverlay.getValue().get()));
                }
                equippable.setDispensable(isDispensable.getValue());
                equippable.setDamageOnHurt(isDamageableOnHurt.getValue());
                equippable.setSwappable(isSwappable.getValue());

                equippable.setAllowedEntities(allowedEntities.getValue());

                meta.setEquippable(equippable);
            }
        }
    }

    @Override
    public void loadFromItemMeta(@NotNull FeatureForItemArgs args) {

        if (isAvailable()){
            ItemMeta meta = args.getMeta();
            if(meta.hasEquippable()){
                EquippableComponent equippable = meta.getEquippable();
                enable.setValue(true);
                slot.setValue(Optional.ofNullable(AttributeSlot.fromEquipmentSlot(equippable.getSlot())));
                enableSound.setValue(equippable.getEquipSound() != null);
                sound.setValue(Optional.ofNullable(equippable.getEquipSound()));
                model.setValue(Optional.of(equippable.getModel().toString()));
                cameraOverlay.setValue(Optional.of(equippable.getCameraOverlay().toString()));
                isDamageableOnHurt.setValue(equippable.isDamageOnHurt());
                isDispensable.setValue(equippable.isDispensable());
                isSwappable.setValue(equippable.isSwappable());
                allowedEntities.setValues(new ArrayList<>(equippable.getAllowedEntities()));
            }
        }
    }

    @Override
    public ResetSetting getResetSetting() {
        return ResetSetting.EQUIPPABLE;
    }
}
