package com.ssomar.score.sobject.sactivator.conditions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

import com.google.common.base.Charsets;
import com.iridium.iridiumskyblock.dependencies.ormlite.stmt.query.In;
import com.ssomar.executableitems.items.ExecutableItem;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.ssomar.executableitems.ExecutableItems;
import com.ssomar.executableitems.configs.Message;
import com.ssomar.executableitems.items.Item;
import com.ssomar.score.configs.messages.MessageMain;
import com.ssomar.score.sobject.SObject;
import com.ssomar.score.sobject.sactivator.SActivator;
import com.ssomar.score.splugin.SPlugin;
import com.ssomar.score.utils.StringCalculation;

public class ItemConditions extends Conditions{

	//Item
	private String ifDurability;
	private static final String IF_DURABILITY_MSG = " &cThis item must have a valid durability to active the activator: &6%activator% &cof this item!";
	private String ifDurabilityMsg;
	
	private String ifUsage;
	private static final String IF_USAGE_MSG = " &cThis item must have the valid usage to active the activator: &6%activator% &cof this item!";
	private String ifUsageMsg;

	private String ifUsage2;
	private String ifUsage2Msg;

	private Map<Enchantment, Integer> ifHasEnchant;
	private static final String IF_HAS_ENCHANT_MSG = " &cThis item must have the good enchantments to active the activator: &6%activator% &cof this item!";
	private String ifHasEnchantMsg;

	private Map<Enchantment, Integer> ifHasNotEnchant;
	private static final String IF_HAS_NOT_ENCHANT_MSG = " &cThis item must have the good enchantments to active the activator: &6%activator% &cof this item!";
	private String ifHasNotEnchantMsg;

	
	//private String ifKillWithItem="";

	//private String ifBlockBreakWithItem="";
	
	@Override
	public void init() {
		this.ifDurability = "";
		this.ifDurabilityMsg = IF_DURABILITY_MSG;
		
		this.ifUsage = "";
		this.ifUsageMsg = IF_USAGE_MSG;
		
		this.ifUsage2 = "";
		this.ifUsage2Msg = IF_USAGE_MSG;

		this.ifHasEnchant = new HashMap<>();
		this.ifHasEnchantMsg = IF_HAS_ENCHANT_MSG;

		this.ifHasNotEnchant = new HashMap<>();
		this.ifHasNotEnchantMsg = IF_HAS_NOT_ENCHANT_MSG;
	}
	
	@SuppressWarnings("deprecation")
	public boolean verifConditions(ItemStack i, Item infoItem, Player p) {

		ItemMeta itemMeta = null;
		boolean hasItemMeta = i.hasItemMeta();
		if(hasItemMeta) itemMeta = i.getItemMeta();

		if(this.hasIfDurability()) {
			if(!StringCalculation.calculation(this.ifDurability, i.getDurability())) {
				this.getSm().sendMessage(p, this.getIfDurabilityMsg());
				return false;
			}
		}
		
		if(this.hasIfUsage()) {
			ExecutableItem ei = new ExecutableItem(i);
			Optional<Integer> usageOpt;
			if(!ei.isValid() || !(usageOpt = ei.getUsage()).isPresent()) return false;

			int usage = usageOpt.get();
			
			if(!StringCalculation.calculation(this.ifUsage, usage)) {
				this.getSm().sendMessage(p, this.getIfUsageMsg());
				return false;
			}
		}



		if(this.hasIfUsage2()) {
			if(!hasItemMeta) return false;
			List<String> lore = itemMeta.getLore();
			int usage2;

			if(itemMeta.hasLore() && lore.get(lore.size()-1).contains(MessageMain.getInstance().getMessage(ExecutableItems.plugin, Message.USE))) usage2= Integer.parseInt(lore.get(lore.size()-1).split(MessageMain.getInstance().getMessage(ExecutableItems.plugin, Message.USE))[1]);
			else if(infoItem.getUse() == -1) usage2 = -1;
			else if(infoItem.getUse() == 0) usage2 = 1;
			else if(infoItem.isHideUse()) {
				usage2 = 1;
				NamespacedKey key = new NamespacedKey(ExecutableItems.getPluginSt(), "EI-USAGE");
				if(itemMeta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER) != null) {
					usage2 = itemMeta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
				}
			}
			else usage2 = 1;
			
			if(!StringCalculation.calculation(this.ifUsage2, usage2)) {
				this.getSm().sendMessage(p, this.getIfUsage2Msg());
				return false;
			}
		}

		if(this.ifHasEnchant.size() != 0){
			if(!hasItemMeta) return false;
			Map<Enchantment, Integer> enchants = itemMeta.getEnchants();
			for(Enchantment enchant : ifHasEnchant.keySet()){
				if(!enchants.containsKey(enchant) || !Objects.equals(ifHasEnchant.get(enchant), enchants.get(enchant))) return false;
			}
		}

		if(this.ifHasNotEnchant.size() != 0){
			if(!hasItemMeta) return false;
			Map<Enchantment, Integer> enchants = itemMeta.getEnchants();
			for(Enchantment enchant : ifHasNotEnchant.keySet()){
				if(enchants.containsKey(enchant) && ifHasNotEnchant.get(enchant).equals(enchants.get(enchant))) return false;
			}
		}

			
		return true;
	}
	
	public static ItemConditions getItemConditions(ConfigurationSection itemCdtSection, List<String> errorList, String pluginName) {

		ItemConditions iCdt = new ItemConditions();

		iCdt.setIfDurability(itemCdtSection.getString("ifDurability", ""));
		iCdt.setIfDurabilityMsg(itemCdtSection.getString("ifDurabilityMsg", "&4&l"+pluginName+IF_DURABILITY_MSG));

		iCdt.setIfUsage(itemCdtSection.getString("ifUsage", ""));
		iCdt.setIfUsageMsg(itemCdtSection.getString("ifUsageMsg", "&4&l"+pluginName+IF_USAGE_MSG));

		iCdt.setIfUsage2(itemCdtSection.getString("ifUsage2", ""));
		iCdt.setIfUsage2Msg(itemCdtSection.getString("ifUsage2Msg", "&4&l"+pluginName+IF_USAGE_MSG));

		Map<Enchantment, Integer> hasEnchants = transformEnchants(itemCdtSection.getStringList("ifHasEnchant"));
		iCdt.setIfHasEnchant(hasEnchants);
		iCdt.setIfHasEnchantMsg(itemCdtSection.getString("ifHasEnchantMsg", "&4&l"+pluginName+IF_HAS_ENCHANT_MSG));

		Map<Enchantment, Integer> hasNotEnchants = transformEnchants(itemCdtSection.getStringList("ifHasNotEnchant"));
		iCdt.setIfHasNotEnchant(hasNotEnchants);
		iCdt.setIfHasNotEnchantMsg(itemCdtSection.getString("ifHasNotEnchantMsg", "&4&l"+pluginName+IF_HAS_NOT_ENCHANT_MSG));

		return iCdt;
	}

	public static Map<Enchantment, Integer> transformEnchants(List<String> enchantsConfig){
		Map<Enchantment, Integer> result = new HashMap<>();
		for(String s : enchantsConfig){
			Enchantment enchant;
			int level;
			String [] decomp;

			if(s.contains(":")){
				decomp = s.split(":");
				try {
					enchant = Enchantment.getByName(decomp[0]);
					level = Integer.parseInt(decomp[1]);
					result.put(enchant, level);
				}catch(Exception e){ e.printStackTrace();}
			}
		}
		return result;
	}
	
	/*
	 *  @param sPlugin The plugin of the conditions
	 *  @param sObject The object
	 *  @param sActivator The activator that contains the conditions
	 *  @param iC the item conditions object
	 */
	@SuppressWarnings("deprecation")
	public static void saveItemConditions(SPlugin sPlugin, SObject sObject, SActivator sActivator, ItemConditions iC, String detail) {

		if (!new File(sObject.getPath()).exists()) {
			sPlugin.getPlugin().getLogger().severe(sPlugin.getNameDesign() + " Error can't find the file in the folder ! (" + sObject.getID() + ".yml)");
			return;
		}
		File file = new File(sObject.getPath());
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);

		ConfigurationSection activatorConfig = config.getConfigurationSection("activators." + sActivator.getID());
		activatorConfig.set("conditions." + detail + ".ifDurability", ">50");


		ConfigurationSection pCConfig = config.getConfigurationSection("activators." + sActivator.getID() + ".conditions." + detail);

		if (iC.hasIfDurability()) pCConfig.set("ifDurability", iC.getIfDurability());
		else pCConfig.set("ifDurability", null);
		pCConfig.set("ifDurabilityMsg", iC.getIfDurabilityMsg());

		if (iC.hasIfUsage()) pCConfig.set("ifUsage", iC.getIfUsage());
		else pCConfig.set("ifUsage", null);
		pCConfig.set("ifUsageMsg", iC.getIfUsageMsg());

		if (iC.hasIfUsage2()) pCConfig.set("ifUsage2", iC.getIfUsage2());
		else pCConfig.set("ifUsage2", null);
		pCConfig.set("ifUsage2Msg", iC.getIfUsage2Msg());

		if (iC.ifHasEnchant.size() != 0) {
			List<String> result = new ArrayList<>();
			for(Enchantment enchant : iC.ifHasEnchant.keySet()){
				result.add(enchant.getName() +":"+iC.ifHasEnchant.get(enchant));
			}
			pCConfig.set("ifHasEnchant", result);
		}
		else pCConfig.set("ifHasEnchant", null);
		pCConfig.set("ifHasEnchantMsg", iC.getIfHasEnchantMsg());

		if (iC.ifHasNotEnchant.size() != 0) {
			List<String> result = new ArrayList<>();
			for(Enchantment enchant : iC.ifHasNotEnchant.keySet()){
				result.add(enchant.getName() +":"+iC.ifHasNotEnchant.get(enchant));
			}
			pCConfig.set("ifHasNotEnchant", result);
		}
		else pCConfig.set("ifHasNotEnchant", null);
		pCConfig.set("ifHasNotEnchantMsg", iC.getIfHasNotEnchantMsg());

		try {
			Writer writer = new OutputStreamWriter(new FileOutputStream(file), Charsets.UTF_8);

			try {
				writer.write(config.saveToString());
			} finally {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getIfDurability() {
		return ifDurability;
	}
	public void setIfDurability(String ifDurability) {
		this.ifDurability = ifDurability;
	}
	public boolean hasIfDurability() {
		return ifDurability.length()!=0;
	}

	public String getIfUsage() {
		return ifUsage;
	}
	public void setIfUsage(String ifUsage) {
		this.ifUsage = ifUsage;
	}
	public boolean hasIfUsage() {
		return ifUsage.length()!=0;
	}
	
	public String getIfUsage2() {
		return ifUsage2;
	}
	public void setIfUsage2(String ifUsage2) {
		this.ifUsage2 = ifUsage2;
	}
	public boolean hasIfUsage2() {
		return ifUsage2.length()!=0;
	}


	public String getIfDurabilityMsg() {
		return ifDurabilityMsg;
	}
	public void setIfDurabilityMsg(String ifDurabilityMsg) {
		this.ifDurabilityMsg = ifDurabilityMsg;
	}
	public String getIfUsageMsg() {
		return ifUsageMsg;
	}
	public String getIfUsage2Msg() {
		return ifUsage2Msg;
	}
	public void setIfUsageMsg(String ifUsageMsg) {
		this.ifUsageMsg = ifUsageMsg;
	}
	public void setIfUsage2Msg(String ifUsage2Msg) {
		this.ifUsage2Msg = ifUsage2Msg;
	}

	public Map<Enchantment, Integer> getIfHasEnchant() {
		return ifHasEnchant;
	}

	public void setIfHasEnchant(Map<Enchantment, Integer> ifHasEnchant) {
		this.ifHasEnchant = ifHasEnchant;
	}

	public String getIfHasEnchantMsg() {
		return ifHasEnchantMsg;
	}

	public void setIfHasEnchantMsg(String ifHasEnchantMsg) {
		this.ifHasEnchantMsg = ifHasEnchantMsg;
	}

	public Map<Enchantment, Integer> getIfHasNotEnchant() {
		return ifHasNotEnchant;
	}

	public void setIfHasNotEnchant(Map<Enchantment, Integer> ifHasNotEnchant) {
		this.ifHasNotEnchant = ifHasNotEnchant;
	}

	public String getIfHasNotEnchantMsg() {
		return ifHasNotEnchantMsg;
	}

	public void setIfHasNotEnchantMsg(String ifHasNotEnchantMsg) {
		this.ifHasNotEnchantMsg = ifHasNotEnchantMsg;
	}
}
