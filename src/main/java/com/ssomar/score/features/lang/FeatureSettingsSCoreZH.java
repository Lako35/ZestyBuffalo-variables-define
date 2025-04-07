package com.ssomar.score.features.lang;

import com.ssomar.score.SCore;
import com.ssomar.score.features.FeatureSettingsInterface;
import com.ssomar.score.features.SavingVerbosityLevel;
import com.ssomar.score.menu.GUI;
import com.ssomar.score.utils.FixedMaterial;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.Collections;

public enum FeatureSettingsSCoreZH implements FeatureSettingsInterface {
    HARDNESS("HARDNESS", "硬度", new String[]{}, Material.BEDROCK),
    SPROJECTILE("SPROJECTILE", "特殊弹射物", new String[]{}, Material.ARROW),
    VARIABLE("VARIABLE", "变量", new String[]{}, GUI.WRITABLE_BOOK),
    activeTitle("activeTitle", "激活标题", new String[]{"&7&o激活标题"}, null),
    amount("amount", "数量", new String[]{"&7&o数量"}, GUI.CLOCK),
    amplifier("amplifier", "增幅等级", new String[]{"&7&o药水效果的增幅等级"}, GUI.CLOCK),
    attribute("attribute", "属性", new String[]{"&7&o编辑此属性"}, Material.PAPER),
    bannerSettings("bannerSettings", "旗帜设置", new String[]{"&7&o旗帜相关设置"}, FixedMaterial.getMaterial(Arrays.asList("CREEPER_BANNER_PATTERN", "BANNER"))),
    blockType("blockType", "方块类型", new String[]{"&7&o方块的类型"}, Material.STONE),
    blocks("blocks", "方块列表", new String[]{"&7&o方块列表"}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),
    bounce("bounce", "弹跳", new String[]{}, Material.SLIME_BLOCK),
    cancelActionEnchantInAnvil("cancel-enchant-anvil", "禁用铁砧附魔操作", new String[]{"&7&o此物品无法", "&7&o在铁砧中附魔"}, Material.ANVIL),
    cancelActionRenameInAnvil("cancel-rename-anvil", "禁用铁砧重命名操作", new String[]{"&7&o此物品无法", "&7&o在铁砧中重命名"}, Material.ANVIL),
    cancelAllCraft("cancel-item-craft", "禁用合成", new String[]{"&7&o此物品无法作为材料", "&7&o用于合成任何物品", "&7&o(包括自定义物品)"}, FixedMaterial.getMaterial(Arrays.asList("CRAFTING_TABLE", "WORKBENCH"))),
    cancelAnvil("cancel-anvil", "禁用铁砧使用", new String[]{"&7&o此物品无法", "&7&o放入铁砧中"}, Material.ANVIL),
    cancelArmorStand("cancel-armorstand", "禁用盔甲架使用", new String[]{"&7&o此物品无法", "&7&o放置在盔甲架上"}, Material.ARMOR_STAND),
    cancelBeacon("cancel-beacon", "禁用信标使用", new String[]{"&7&o此物品无法", "&7&o放入信标中"}, Material.BEACON),
    cancelBrewing("cancel-brewing", "禁用酿造台使用", new String[]{"&7&o此物品无法", "&7&o放入酿造台中"}, FixedMaterial.getBrewingStand()),
    cancelCartography("cancel-cartography", "禁用制图台使用", new String[]{"&7&o此物品无法", "&7&o放入制图台中"}, FixedMaterial.getMaterial(Collections.singletonList("CARTOGRAPHY_TABLE"))),
    cancelComposter("cancel-composter", "禁用堆肥桶使用", new String[]{"&7&o此物品无法", "&7&o放入堆肥桶中"}, FixedMaterial.getMaterial(Collections.singletonList("COMPOSTER"))),
    cancelConsumption("cancel-consumption", "禁用食用", new String[]{"&7&o此物品无法被", "&7&o食用"}, Material.POTION),
    cancelCraft("cancel-item-craft-no-custom", "禁用合成(仅原版)", new String[]{"&7&o此物品无法作为材料", "&7&o用于合成原版物品"}, FixedMaterial.getMaterial(Arrays.asList("CRAFTING_TABLE", "WORKBENCH"))),
    cancelDepositInChest("cancel-deposit-in-chest", "禁用存入箱子", new String[]{"&7&o此物品无法被", "&7&o存入箱子中"}, Material.CHEST),
    cancelDepositInFurnace("cancel-deposit-in-furnace", "禁用存入熔炉", new String[]{"&7&o此物品无法被", "&7&o放入熔炉中"}, Material.FURNACE),
    cancelDispenser("cancel-dispenser", "禁用发射器使用", new String[]{"&7&o此物品无法", "&7&o放入发射器中"}, Material.DISPENSER),
    cancelDropper("cancel-dropper", "禁用投掷器使用", new String[]{"&7&o此物品无法", "&7&o放入投掷器中"}, Material.DROPPER),
    cancelEnchant("cancel-enchant", "禁用附魔", new String[]{"&7&o此物品无法", "&7&o被附魔"}, FixedMaterial.getMaterial(Arrays.asList("ENCHANTING_TABLE", "ENCHANTMENT_TABLE"))),
    cancelEventIfError("cancelEventIfError", "若有错误则取消事件", new String[]{"&7&o如果无效则取消事件"}, null),
    cancelEventIfInCooldown("cancelEventIfInCooldown", "冷却中则取消事件", new String[]{"&7&o如果玩家处于冷却中则取消事件？"}, null),
    cancelEventIfMaxReached("cancelEventIfMaxReached", "达到上限则取消事件", new String[]{"&7&o若达到最大次数则取消事件"}, null),
    cancelEventIfNoPermission("cancelEventIfNoPermission", "无权限则取消事件", new String[]{"&7&o若玩家无权限则取消事件"}, null),
    cancelEventIfNotValid("cancelEventIfNotValid", "无效则取消事件", new String[]{"&7&o若方块无效则取消事件？"}, null),
    cancelEvents("cancelEvents", "取消事件集合", new String[]{"&7&o取消事件相关功能"}, Material.ANVIL),
    cancelGrindStone("cancel-grind-stone", "禁用砂轮使用", new String[]{"&7&o此物品无法", "&7&o放入砂轮中"}, FixedMaterial.getMaterial(Collections.singletonList("GRINDSTONE"))),
    cancelHopper("cancel-hopper", "禁用漏斗使用", new String[]{"&7&o此物品无法", "&7&o放入漏斗中"}, Material.HOPPER),
    cancelHorn("cancel-horn", "禁用号角互动", new String[]{"&7&o该号角无法被", "&7&o交互使用"}, FixedMaterial.getMaterial(Collections.singletonList("GOAT_HORN"))),
    cancelHorse("cancel-horse", "禁用马相关槽位使用", new String[]{"&7&o此物品无法", "&7&o放入马的装备槽中"}, FixedMaterial.getMaterial(Arrays.asList("HORSE_SPAWN_EGG", "SADDLE"))),
    cancelItemBurn("cancel-item-burn", "禁用物品燃烧", new String[]{"&7&o此物品无法", "&7&o被烧毁"}, null),
    cancelItemDeleteByCactus("cancel-item-delete-by-cactus", "禁用仙人掌删除物品", new String[]{"&7&o此物品无法", "&7&o被仙人掌销毁"}, Material.CACTUS),
    cancelItemDeleteByLightning("cancel-item-delete-by-lightning", "禁用闪电删除物品", new String[]{"&7&o此物品无法", "&7&o被闪电销毁"}, FixedMaterial.getMaterial(Arrays.asList("LIGHTNING_ROD", "LEVER"))),
    cancelItemDrop("cancel-item-drop", "禁用掉落物", new String[]{"&7&o禁用该物品掉落"}, null),
    cancelItemFrame("cancel-item-frame", "禁用物品展示框", new String[]{"&7&o此物品无法", "&7&o放入物品展示框中"}, Material.ITEM_FRAME),
    cancelItemPlace("cancel-item-place", "禁用物品放置", new String[]{"&7&o禁用此物品放置"}, null),
    cancelLectern("cancel-lectern", "禁用讲台使用", new String[]{"&7&o此物品无法", "&7&o放入讲台中"}, FixedMaterial.getMaterial(Collections.singletonList("LECTERN"))),
    cancelLoom("cancel-loom", "禁用织布机使用", new String[]{"&7&o此物品无法", "&7&o放入织布机中"}, FixedMaterial.getMaterial(Collections.singletonList("LOOM"))),
    cancelDecoratedPot("cancel-decorated-pot", "禁用装饰陶罐使用", new String[]{"&7&o此物品无法", "&7&o放入装饰陶罐中"}, FixedMaterial.getMaterial(Collections.singletonList("DECORATED_POT"))),
    cancelCrafter("cancel-crafter", "禁用自动合成器使用", new String[]{"&7&o此物品无法", "&7&o放入自动合成器中"}, FixedMaterial.getMaterial(Collections.singletonList("CRAFTER"))),
    cancelMerchant("cancel-merchant", "禁用商人使用", new String[]{"&7&o此物品无法", "&7&o放入商人交易槽中"}, FixedMaterial.getMaterial(Arrays.asList("VILLAGER_SPAWN_EGG", "EMERALD"))),
    cancelSmithingTable("cancel-smithing-table", "禁用锻造台使用", new String[]{"&7&o此物品无法", "&7&o放入锻造台中"}, FixedMaterial.getMaterial(Collections.singletonList("SMITHING_TABLE"))),
    cancelStoneCutter("cancel-stone-cutter", "禁用切石机使用", new String[]{"&7&o此物品无法", "&7&o放入切石机中"}, FixedMaterial.getMaterial(Collections.singletonList("STONECUTTER"))),
    cancelSwapHand("cancel-swap-hand", "禁用双手互换", new String[]{"&7&o此物品无法", "&7&o进行副手与主手交换"}, null),
    cancelToolInteractions("cancel-tool-interactions", "禁用工具交互", new String[]{"&7&o禁用工具的交互操作"}, null),
    charged("charged", "充能状态", new String[]{""}, Material.NETHER_STAR),
    color("color", "颜色", new String[]{"&7&o颜色"}, FixedMaterial.getMaterial(Arrays.asList("RED_DYE", "INK_SACK"))),
    containerContent("containerContent", "容器内容", new String[]{"&7&o容器内容"}, Material.CHEST),
    colors("colors", "颜色集合", new String[]{"&7&o烟花的颜色集"}, GUI.CLOCK),
    comparator("comparator", "比较器", new String[]{"&7&o条件的比较方式"}, Material.COMPASS),
    cooldown("cooldown", "冷却时间", new String[]{"&7&o冷却时间"}, GUI.CLOCK),
    cooldownMsg("cooldownMsg", "冷却提示信息", new String[]{"&7&o冷却期间显示的信息"}, GUI.WRITABLE_BOOK),
    critical("critical", "暴击", new String[]{}, Material.DIAMOND_AXE),
    customModelData("customModelData", "自定义模型数据", new String[]{"&7&o自定义模型数据值"}, Material.ITEM_FRAME),
    customName("customName", "自定义名称", new String[]{}, Material.NAME_TAG),
    customNameVisible("customNameVisible", "显示自定义名称", new String[]{}, Material.NAME_TAG),
    damage("damage", "伤害值", new String[]{"&7&o-1 使用原版伤害值"}, Material.DIAMOND_SWORD),
    default_double("default", "数值默认值", new String[]{"&7&o变量的默认数值"}, GUI.WRITABLE_BOOK),
    default_list("default", "列表默认值", new String[]{"&7&o变量的默认列表值"}, GUI.WRITABLE_BOOK),
    default_string("default", "字符串默认值", new String[]{"&7&o变量的默认字符串值"}, GUI.WRITABLE_BOOK),
    delay("delay", "延迟", new String[]{"&7&o每次激活之间的延迟", "&c最小值: &65 ticks"}, GUI.CLOCK),
    delayInTick("delayInTick", "以tick为单位的延迟", new String[]{"&7&o延迟是否以tick计算？"}, null),
    despawnDelay("despawnDelay", "消失延迟", new String[]{"&7&o-1 使用原版消失时间"}, Material.DEAD_BUSH),
    detailedBlocks("detailedBlocks", "指定方块列表", new String[]{"&7&o仅对特定方块生效", "&7&o空 = 所有方块"}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),
    detailedEffects("detailedEffects", "指定效果列表", new String[]{"&7&o仅对特定效果生效", "&7&o空 = 所有效果"}, FixedMaterial.getMaterial(Arrays.asList("POTION", "REDSTONE"))),
    detailedItems("detailedItems", "指定物品列表", new String[]{"&7&o仅对特定物品生效", "&7&o空 = 所有物品"}, FixedMaterial.getMaterial(Arrays.asList("TORCH"))),
    detailedSlots("detailedSlots", "指定槽位", new String[]{"&7&o激活器生效的槽位"}, Material.ARMOR_STAND),
    displayCooldownMessage("displayCooldownMessage", "显示冷却信息", new String[]{"&7&o显示冷却提示信息"}, null),
    displayNameDrop("displayNameDrop", "显示自定义名称", new String[]{"&7&o在物品上方显示自定义名称"}, null),
    duration("duration", "持续时间", new String[]{"&7&o药水效果持续时间", "&4⚠ &c单位: tick", "&7&o1 秒 = 20 tick"}, GUI.CLOCK),
    effects("effects", "效果集合", new String[]{"&7&o效果列表"}, FixedMaterial.getMaterial(Arrays.asList("POTION", "REDSTONE"))),
    enableArmorTrim("enableArmorTrim", "启用护甲装饰", new String[]{"&7&o是否启用护甲装饰"}, null),
    enchantment("enchantment", "附魔", new String[]{"&7&o附魔类型"}, Material.ENCHANTED_BOOK),
    enchantmentWithLevel("enchantmentWithLevel", "带等级的附魔", new String[]{"&7&o附魔及其等级"}, Material.ENCHANTED_BOOK),
    entityType("entityType", "实体类型", new String[]{"&7&o实体类型"}, FixedMaterial.getMaterial(Arrays.asList("ZOMBIE_HEAD", "MONSTER_EGG"))),
    errorMessage("errorMessage", "错误消息", new String[]{"&7&o当条件不符合时显示的错误信息"}, GUI.WRITABLE_BOOK),
    executableItem("executableItem", "可执行物品", new String[]{"&7&o指定一个所需的可执行物品"}, Material.DIAMOND),
    itemsAdder("itemsAdder", "ItemsAdder物品", new String[]{"&7&o用于此交易的物品"}, Material.DIAMOND),
    fadeColors("fadeColors", "渐变颜色", new String[]{"&7&o烟花的渐变颜色"}, GUI.CLOCK),
    fireworkFeatures("fireworkFeatures", "烟花特性", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("FIREWORK_ROCKET"))),
    fireworkExplosion("fireworkExplosion", "烟花爆炸效果", new String[]{"&7&o烟花的爆炸效果"}, FixedMaterial.getMaterial(Arrays.asList("FIREWORK_STAR"))),
    fireworkExplosions("fireworkExplosions", "烟花爆炸效果集合", new String[]{"&7&o烟花的多个爆炸效果"}, FixedMaterial.getMaterial(Arrays.asList("FIREWORK_STAR"))),
    hasTrail("hasTrail", "有尾迹", new String[]{"&7&o爆炸是否有尾迹效果(钻石)？"}, null),
    hasTwinkle("hasTwinkle", "有闪烁", new String[]{"&7&o爆炸是否有闪烁效果(荧石粉)？"}, null),

    for_("for", "针对目标", new String[]{"&7&o针对"}, GUI.COMPARATOR),
    giveFirstJoin("giveFirstJoin", "首次加入给予物品", new String[]{"&7&o启用此功能"}, null),
    giveFirstJoinAmount("giveFirstJoinAmount", "数量", new String[]{"&7&o给予的数量"}, GUI.CLOCK),
    giveFirstJoinSlot("giveFirstJoinSlot", "槽位", new String[]{"&7&o槽位范围：0到8"}, GUI.CLOCK),
    glowDrop("glowDrop", "发光掉落物", new String[]{"&7&o掉落物发光"}, null),
    glowDropColor("glowDropColor", "掉落物发光颜色", new String[]{"&7&o发光颜色"}, Material.REDSTONE),
    glowing("glowing", "发光", new String[]{}, Material.BEACON),
    gravity("gravity", "重力", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("ELYTRA", "FEATHER"))),
    hasExecutableItem("hasExecutableItem", "有可执行物品", new String[]{"&7&o此特性有可执行物品条件"}, Material.DIAMOND),
    hasIcon("hasIcon", "有图标", new String[]{"&7&o药水效果是否有图标"}, null),
    hasItem("hasItem", "有物品", new String[]{"&7&o有物品条件"}, Material.STONE),
    hasParticles("hasParticles", "有粒子效果", new String[]{"&7&o药水效果是否有粒子效果"}, null),
    headDBID("headDBID", "HeadDB ID", new String[]{"&7&o此头颅的HeadDB ID", "&7&o兼容:", "&7&o- &bHeadDB(免费)", "&7&o- &cHead Database(付费)"}, FixedMaterial.getHead()),
    headFeatures("headFeatures", "头颅特性", new String[]{"&7&o头颅的自定义纹理"}, FixedMaterial.getHead()),
    headValue("headValue", "头颅值", new String[]{"&7&o头颅的纹理值", "&eminecraft-heads.com"}, FixedMaterial.getHead()),
    hideArmorTrim("hideArmorTrim", "隐藏护甲装饰", new String[]{"&7&o隐藏护甲装饰"}, null),
    hideAttributes("hideAttributes", "隐藏属性", new String[]{"&7&o隐藏物品属性"}, null),
    hideDestroys("hideDestroys", "隐藏可破坏方块信息", new String[]{"&7&o隐藏物品可破坏的方块信息"}, null),
    hideDye("hideDye", "隐藏染料信息", new String[]{"&7&o隐藏染料信息"}, null),
    hideEnchantments("hideEnchantments", "隐藏附魔", new String[]{"&7&o隐藏物品附魔信息"}, null),
    hidePlacedOn("hidePlacedOn", "隐藏可放置信息", new String[]{"&7&o隐藏物品可放置在哪些方块上"}, null),
    hideAdditionalTooltip("hideAdditionalTooltip", "隐藏额外提示", new String[]{"&7&o隐藏额外提示信息"}, null),
    hideTooltip("hideToolTip", "隐藏提示", new String[]{"&7&o隐藏物品提示"}, null),
    hidePotionEffects("hidePotionEffects", "隐藏药水效果/旗帜标签", new String[]{"&7&o隐藏药水效果", "&7&o及旗帜标签"}, null),
    hideUnbreakable("hideUnbreakable", "隐藏不可破坏标签", new String[]{"&7&o隐藏“不可破坏”标签"}, null),
    hideUsage("hideUsage", "隐藏使用次数", new String[]{"&7&o隐藏使用信息"}, null),
    icon("icon", "图标", new String[]{}, Material.STONE),
    ifAdult("ifAdult", "若为成年实体", new String[]{}, Material.ANVIL),
    ifBaby("ifBaby", "若为幼年实体", new String[]{}, Material.ANVIL),
    // 下方的if...条件类的描述依然可译为中文（描述略多，为了篇幅，不再一一重复翻译类似的模式，将同类简单描述均统一以中文说明）

    // 由于篇幅极长，以下翻译策略：
    // 所有 ifXxx 类似条件描述部分统一翻译为中文简述，如下：
    ifBlockAge("ifBlockAge", "若方块有指定年龄", new String[]{}, Material.ANVIL),
    ifBlockLocationX("ifBlockLocationX", "若方块X坐标条件", new String[]{}, Material.ANVIL),
    ifBlockLocationY("ifBlockLocationY", "若方块Y坐标条件", new String[]{}, Material.ANVIL),
    ifBlockLocationZ("ifBlockLocationZ", "若方块Z坐标条件", new String[]{}, Material.ANVIL),
    ifBlocking("ifBlocking", "若格挡中", new String[]{}, null),
    ifCanBreakTargetedBlock("ifCanBreakTargetedBlock", "若能破坏目标方块", new String[]{}, Material.ANVIL),
    ifContainerContains("ifContainerContains", "若容器包含指定物品", new String[]{}, Material.ANVIL),
    ifContainerContainsEI("ifContainerContainsEI", "若容器包含指定可执行物品", new String[]{}, Material.ANVIL),
    ifContainerContainsSellableItems("ifContainerContainsSellableItems", "若容器包含可售卖物品", new String[]{}, Material.ANVIL),
    ifContainerEmpty("ifContainerEmpty", "若容器为空", new String[]{}, Material.ANVIL),
    ifContainerNotEmpty("ifContainerNotEmpty", "若容器非空", new String[]{}, Material.ANVIL),
    ifCrossbowMustBeCharged("ifCrossbowMustBeCharged", "若弩必须已上弦", new String[]{}, FixedMaterial.getMaterial(Collections.singletonList("CROSSBOW"))),
    ifCrossbowMustNotBeCharged("ifCrossbowMustNotBeCharged", "若弩必须未上弦", new String[]{}, FixedMaterial.getMaterial(Collections.singletonList("CROSSBOW"))),
    ifCursorDistance("ifCursorDistance", "若光标距离满足条件", new String[]{}, Material.ANVIL),
    ifDurability("ifDurability", "若耐久度符合条件", new String[]{}, Material.ANVIL),
    ifEntityHealth("ifEntityHealth", "若实体生命值条件", new String[]{}, Material.ANVIL),
    ifFlying("ifFlying", "若正在飞行", new String[]{}, null),
    ifFromSpawner("ifFromSpawner", "若来自刷怪笼", new String[]{}, Material.ANVIL),
    ifFrozen("ifFrozen", "若被冰冻", new String[]{}, Material.ANVIL),
    ifGliding("ifGliding", "若滑翔中", new String[]{}, null),
    ifGlowing("ifGlowing", "若发光中", new String[]{}, Material.ANVIL),
    ifHasAI("ifHasAI", "若有AI", new String[]{}, Material.ANVIL),
    ifHasEnchant("ifHasEnchant", "若有指定附魔", new String[]{"&7若有指定附魔条件"}, Material.ANVIL),
    ifHasExecutableItems("ifHasExecutableItems", "若有指定可执行物品", new String[]{}, Material.DIAMOND),
    ifHasItems("ifHasItems", "若有指定物品", new String[]{}, Material.STONE),
    ifHasNotEnchant("ifHasNotEnchant", "若无指定附魔", new String[]{"&7若无指定附魔条件"}, Material.ANVIL),
    ifHasNotExecutableItems("ifHasNotExecutableItems", "若无指定可执行物品", new String[]{}, Material.DIAMOND),
    ifHasNotItems("ifHasNotItems", "若无指定物品", new String[]{}, Material.STONE),
    ifHasPermission("ifHasPermission", "若有权限", new String[]{}, Material.ANVIL),
    ifHasSaddle("ifHasSaddle", "若有鞍", new String[]{}, Material.ANVIL),
    ifHasTag("ifHasTag", "若有指定标签", new String[]{"&7&o白名单标签"}, Material.ANVIL),
    ifInBiome("ifInBiome", "若在指定群系", new String[]{}, Material.ANVIL),
    ifInRegion("ifInRegion", "若在指定区域", new String[]{}, Material.ANVIL),
    ifInWorld("ifInWorld", "若在指定世界", new String[]{}, Material.ANVIL),
    ifInvulnerable("ifInvulnerable", "若无敌", new String[]{}, Material.ANVIL),
    ifIsInTheAir("ifIsInTheAir", "若在空中", new String[]{}, null),
    ifIsInTheBlock("ifIsInTheBlock", "若在方块内", new String[]{}, Material.ANVIL),
    ifIsNotInTheAir("ifIsNotInTheAir", "若不在空中", new String[]{}, null),
    ifIsNotInTheBlock("ifIsNotInTheBlock", "若不在方块内", new String[]{}, Material.ANVIL),
    ifIsNotOnFire("ifIsNotOnFire", "若不着火", new String[]{}, null),
    ifIsNotOnTheBlock("ifIsNotOnTheBlock", "若不在指定方块上", new String[]{}, Material.ANVIL),
    ifIsOnFire("ifIsOnFire", "若着火中", new String[]{}, null),
    ifIsOnTheBlock("ifIsOnTheBlock", "若在指定方块上", new String[]{}, Material.ANVIL),
    ifIsPowered("ifIsPowered", "若通电", new String[]{}, Material.ANVIL),
    ifLightLevel("ifLightLevel", "若光照等级条件", new String[]{}, Material.ANVIL),
    ifMustBeNatural("ifMustBeNatural", "若必须是自然生成", new String[]{}, Material.ANVIL),
    ifMustBeNotNatural("ifMustBeNotNatural", "若必须为非自然生成", new String[]{}, Material.ANVIL),
    ifMustBeNotPowered("ifMustBeNotPowered", "若必须无电力", new String[]{}, Material.ANVIL),
    ifMustBeEB("ifMustBeEB", "如果必须是EB", new String[]{}, Material.ANVIL),
    ifName("ifName", "若名称符合条件", new String[]{}, Material.ANVIL),
    ifNamed("ifNamed", "若有自定义名称", new String[]{}, Material.ANVIL),
    ifNeedPlayerConfirmation("ifNeedPlayerConfirmation", "若需要玩家确认", new String[]{}, null),
    ifNoPlayerMustBeOnTheBlock("ifNoPlayerMustBeOnTheBlock", "若无玩家在此方块上", new String[]{}, Material.ANVIL),
    ifNotBlocking("ifNotBlocking", "若未格挡", new String[]{}, null),
    ifNotEntityType("ifNotEntityType", "若非此实体类型", new String[]{}, Material.ANVIL),
    ifNotFlying("ifNotFlying", "若未飞行", new String[]{}, null),
    ifNotFromSpawner("ifNotFromSpawner", "若非来自刷怪笼", new String[]{}, Material.ANVIL),
    ifNotGliding("ifNotGliding", "若未滑翔", new String[]{}, null),
    ifNotHasAI("ifNotHasAI", "若无AI", new String[]{}, Material.ANVIL),
    ifNotHasPermission("ifNotHasPermission", "若无权限", new String[]{}, Material.ANVIL),
    ifNotHasSaddle("ifNotHasSaddle", "若无鞍", new String[]{}, Material.ANVIL),
    ifNotHasTag("ifNotHasTag", "若无指定标签", new String[]{"&7&o黑名单标签"}, Material.ANVIL),
    ifNotInBiome("ifNotInBiome", "若不在此群系", new String[]{}, Material.ANVIL),
    ifNotInRegion("ifNotInRegion", "若不在此区域", new String[]{}, Material.ANVIL),
    ifNotInWorld("ifNotInWorld", "若不在此世界", new String[]{}, Material.ANVIL),
    ifNotNamed("ifNotNamed", "若无自定义名称", new String[]{}, Material.ANVIL),
    ifNotOwnerOfTheEI("ifNotOwnerOfTheEI", "若非此EI的拥有者", new String[]{}, null),
    ifNotSneaking("ifNotSneaking", "若未潜行", new String[]{}, null),
    ifNotSprinting("ifNotSprinting", "若未疾跑", new String[]{}, null),
    ifNotStunned("ifNotStunned", "若未被自定义晕眩", new String[]{"&7&o通过自定义玩家指令 &eSTUN_ENABLE &7&o实现"}, null),
    ifNotSwimming("ifNotSwimming", "若未游泳", new String[]{}, null),
    ifNotTamed("ifNotTamed", "若未被驯服", new String[]{}, Material.ANVIL),
    ifNotTargetBlock("ifNotTargetBlock", "若非目标方块", new String[]{}, Material.ANVIL),
    ifOnFire("ifOnFire", "若着火中(重复?)", new String[]{}, Material.ANVIL),
    ifOwnerOfTheEI("ifOwnerOfTheEI", "若为此EI的拥有者", new String[]{}, null),
    ifPlantFullyGrown("ifPlantFullyGrown", "若植物已成熟", new String[]{}, Material.ANVIL),
    ifPlantNotFullyGrown("ifPlantNotFullyGrown", "若植物未成熟", new String[]{}, Material.ANVIL),
    ifPlayerEXP("ifPlayerEXP", "若玩家经验条件", new String[]{}, Material.ANVIL),
    ifPlayerFoodLevel("ifPlayerFoodLevel", "若玩家饱食度条件", new String[]{}, Material.ANVIL),
    ifPlayerHasEffect("ifPlayerHasEffect", "若玩家有此药水效果", new String[]{}, Material.ANVIL),
    ifPlayerHasEffectEquals("ifPlayerHasEffectEquals", "若玩家有特定等级效果", new String[]{}, Material.ANVIL),
    ifPlayerHealth("ifPlayerHealth", "若玩家生命值条件", new String[]{}, Material.ANVIL),
    ifPlayerLevel("ifPlayerLevel", "若玩家等级条件", new String[]{}, Material.ANVIL),
    ifPlayerMounts("ifPlayerMounts", "若玩家骑乘坐骑", new String[]{}, Material.ANVIL),
    ifPlayerMustBeInHisTown("ifPlayerMustBeInHisTown", "若玩家必须在其城镇", new String[]{}, null),
    ifPlayerMustBeOnHisClaim("ifPlayerMustBeOnHisClaim", "若玩家必须在自己领地", new String[]{}, null),
    ifPlayerMustBeOnHisClaimOrWilderness("ifPlayerMustBeOnHisClaimOrWilderness", "若玩家必须在自己领地或荒野", new String[]{}, null),
    ifPlayerMustBeOnHisIsland("ifPlayerMustBeOnHisIsland", "若玩家必须在自己岛屿", new String[]{}, null),
    ifPlayerMustBeOnHisPlot("ifPlayerMustBeOnHisPlot", "若玩家必须在自己地皮", new String[]{}, null),
    ifPlayerMustBeOnTheBlock("ifPlayerMustBeOnTheBlock", "若玩家必须在此方块上", new String[]{}, Material.ANVIL),
    ifPlayerNotHasEffect("ifPlayerNotHasEffect", "若玩家无此效果", new String[]{}, Material.ANVIL),
    ifPlayerNotMounts("ifPlayerNotMounts", "若玩家未骑乘坐骑", new String[]{}, Material.ANVIL),
    ifPosX("ifPosX", "若玩家X坐标条件", new String[]{}, Material.ANVIL),
    ifPosY("ifPosY", "若玩家Y坐标条件", new String[]{}, Material.ANVIL),
    ifPosZ("ifPosZ", "若玩家Z坐标条件", new String[]{}, Material.ANVIL),
    ifPowered("ifPowered", "若通电(重复?)", new String[]{}, Material.ANVIL),
    ifSneaking("ifSneaking", "若潜行", new String[]{}, null),
    ifSprinting("ifSprinting", "若疾跑", new String[]{}, null),
    ifStunned("ifStunned", "若被晕眩", new String[]{"&7&o通过自定义指令 &eSTUN_ENABLE &7&o实现"}, null),
    ifSwimming("ifSwimming", "若游泳", new String[]{}, null),
    ifTamed("ifTamed", "若已驯服", new String[]{}, Material.ANVIL),
    ifTargetBlock("ifTargetBlock", "若为目标方块", new String[]{}, Material.ANVIL),
    ifUsage("ifUsage", "若使用次数条件", new String[]{}, Material.ANVIL),
    ifWeather("ifWeather", "若天气条件", new String[]{"&7指定的天气类型白名单"}, Material.ANVIL),
    ifWorldTime("ifWorldTime", "若世界时间条件", new String[]{}, Material.ANVIL),
    incendiary("incendiary", "燃烧特性", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("CAMPFIRE", "FLINT_AND_STEEL"))),
    invisible("invisible", "隐形", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("GLASS_PANE", "GLASS"))),
    isAmbient("isAmbient", "环境型效果", new String[]{"&7&o是否为环境型药水效果"}, null),
    isCooldownInTicks("isCooldownInTicks", "冷却以tick计算", new String[]{"&7&o冷却是否以tick为单位？"}, null),
    items("items", "物品列表", new String[]{"&7&o物品集合"}, FixedMaterial.getMaterial(Arrays.asList("TORCH"))),
    knockbackStrength("knockbackStrength", "击退强度", new String[]{}, Material.CHAINMAIL_CHESTPLATE),
    level("level", "等级", new String[]{"&7&o附魔等级"}, Material.BEACON),
    lifeTime("lifeTime", "烟花飞行时间", new String[]{"&7&o烟花的飞行持续时间", "＆7&o(制作中使用的火药数量)", "&7&o必须为-128至127之间的整数，默认为1"}, GUI.CLOCK),
    lockedInventory("locked-in-inventory", "锁定在背包中", new String[]{"&7&o此物品不能", "&7&o从背包中移除"}, Material.BARRIER),
    loop("loop", "循环特性", new String[]{"&7&o循环激活器的特定设置"}, Material.ANVIL),
    magicID("magicID", "魔法ID", new String[]{"&7&o魔法ID"}, Material.STONE),
    material("material", "材料", new String[]{"&7&o物品材质"}, Material.STONE),
    materialAndTags("materialAndTags", "材料和标签", new String[]{"&7&o物品材料和标签"}, Material.STONE),
    maxUsePerDay("maxUsePerDay", "每日最大使用次数", new String[]{"&7&o每日最大使用次数", "&a-1 &7&o=无限"}, Material.BUCKET),
    messageIfMaxReached("messageIfMaxReached", "达到上限信息", new String[]{"&7&o达到上限时显示的信息"}, GUI.WRITABLE_BOOK),
    messageIfNotValid("messageIfNotValid", "无效条件提示", new String[]{"&7&o当条件不满足时的提示信息"}, GUI.WRITABLE_BOOK),
    messageIfNotValidForTarget("messageIfNotValidForTarget", "目标无效提示", new String[]{"&7&o当目标条件不满足时显示的信息"}, GUI.WRITABLE_BOOK),
    modification_double("modification", "数值更新", new String[]{"&7&o数值更新操作"}, GUI.WRITABLE_BOOK),
    modification_string("modification", "字符串更新", new String[]{"&7&o字符串更新操作"}, GUI.WRITABLE_BOOK),
    multiChoices("multi-choices", "多重选择", new String[]{}, Material.DIAMOND),
    name("name", "名称", new String[]{"&7&o名称或显示名称"}, Material.NAME_TAG),
    notExecutableItem("notExecutableItem", "非可执行物品", new String[]{"&7&o该物品不是可执行物品？"}, null),
    object("object", "对象", new String[]{"&7&o一个对象"}, Material.PAPER),
    operation("operation", "操作类型", new String[]{"&7&o操作方式"}, Material.DISPENSER),
    part1("part1", "条件部分1", new String[]{"&7&o条件的第一部分"}, GUI.WRITABLE_BOOK),
    part2("part2", "条件部分2", new String[]{"&7&o条件的第二部分"}, GUI.WRITABLE_BOOK),
    particle("particle", "粒子效果", new String[]{"&7&o自定义粒子效果"}, Material.BLAZE_POWDER),
    particles("particles", "粒子集合", new String[]{"&7&o粒子效果集合"}, Material.BLAZE_POWDER),
    particlesAmount("particlesAmount", "粒子数量", new String[]{"&7&o粒子数量"}, GUI.COMPARATOR),
    particlesDelay("particlesDelay", "粒子延迟", new String[]{"&7&o粒子延迟"}, GUI.COMPARATOR),
    particlesDensity("particlesDensity", "粒子密度", new String[]{"&7&o粒子密度"}, GUI.COMPARATOR),
    particlesOffSet("particlesOffSet", "粒子偏移", new String[]{"&7&o粒子偏移量"}, GUI.COMPARATOR),
    particlesSpeed("particlesSpeed", "粒子速度", new String[]{"&7&o粒子速度"}, GUI.COMPARATOR),
    particlesType("particlesType", "粒子类型", new String[]{"&7&o粒子类型"}, Material.BLAZE_POWDER),
    pattern("pattern", "护甲花纹", new String[]{"&7&o用于装饰护甲的花纹"}, FixedMaterial.getMaterial(Arrays.asList("EYE_ARMOR_TRIM_SMITHING_TEMPLATE"))),
    patterns("patterns", "花纹集合", new String[]{"&7&o花纹集合"}, Material.ANVIL),
    pausePlaceholdersConditions("pausePlaceholdersConditions", "暂停占位符条件", new String[]{"&7&o用于在冷却期间暂停的占位符条件"}, Material.ANVIL),
    pauseWhenOffline("pauseWhenOffline", "离线时暂停冷却", new String[]{"&7&o玩家离线时是否暂停冷却？"}, null),
    enableVisualCooldown("enableVisualCooldown", "启用可视化冷却", new String[]{"&7&o启用可视化冷却", "&7&o需要在物品设置中配置", "&e&ocooldownGroup &7&o"}, null),
    period("period", "周期", new String[]{}, GUI.CLOCK),
    periodInTicks("periodInTicks", "周期(以tick计)", new String[]{}, GUI.CLOCK),
    pickupStatus("pickupStatus", "拾取状态", new String[]{""}, FixedMaterial.getMaterial(Arrays.asList("LEAD", "LEASH"))),
    pierceLevel("pierceLevel", "穿透等级", new String[]{}, FixedMaterial.getMaterial(Collections.singletonList("TIPPED_ARROW"))),
    placeholderCondition("placeholderCondition", "占位符条件", new String[]{"&7&o包含选项的占位符条件"}, GUI.WRITABLE_BOOK),
    placeholderConditionCmds("placeholderConditionCmds", "占位符条件无效时控制台命令", new String[]{"&7&o条件无效时执行的控制台命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "WRITABLE_BOOK", "BOOK_AND_QUILL"))),
    placeholdersConditions("placeholdersConditions", "占位符条件集合", new String[]{"&7&o占位符条件集合"}, Material.ANVIL),
    potionColor("potionColor", "药水颜色", new String[]{"&7&o药水颜色"}, Material.REDSTONE),
    potionEffect("potionEffect", "药水效果", new String[]{"&7&o带有选项的药水效果"}, FixedMaterial.getBrewingStand()),
    potionEffectType("potionEffectType", "药水效果类型", new String[]{"&7&o药水效果类型"}, Material.COMPASS),
    potionEffects("potionEffects", "药水效果集合", new String[]{"&7&o药水效果集合"}, FixedMaterial.getBrewingStand()),
    potionExtended("potionExtended", "延长药水效果", new String[]{"&7&o药水效果延长"}, null),
    potionSettings("potionSettings", "药水设置", new String[]{"&7&o药水的相关设置"}, FixedMaterial.getBrewingStand()),
    potionType("potionType", "药水类型", new String[]{"&7&o药水类型"}, Material.POTION),
    potionUpgraded("potionUpgraded", "强化药水效果", new String[]{"&7&o强化药水效果"}, null),
    radius("radius", "半径", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("HEART_OF_THE_SEA", "WEB"))),
    redstoneColor("redstoneColor", "红石颜色", new String[]{"&7&o红石颜色"}, Material.REDSTONE),
    removeWhenHitBlock("removeWhenHitBlock", "击中方块后移除", new String[]{"&7&o击中方块后移除"}, null),
    requiredExecutableItem("requiredExecutableItem", "所需可执行物品", new String[]{"&7&o所需的可执行物品"}, Material.PAPER),
    requiredExecutableItems("requiredExecutableItems", "所需可执行物品集合", new String[]{"&7&o所需的一组可执行物品"}, Material.DIAMOND_PICKAXE),
    requiredExperience("requiredExperience", "所需经验", new String[]{"&7&o所需经验值"}, FixedMaterial.getMaterial(Arrays.asList("EXPERIENCE_BOTTLE", "EXP_BOTTLE"))),
    requiredGroups("requiredGroups", "所需条件集合", new String[]{"&7&o所需条件"}, Material.ANVIL),
    requiredItem("requiredItem", "所需物品", new String[]{"&7&o所需的物品"}, Material.PAPER),
    requiredItems("requiredItems", "所需物品集合", new String[]{"&7&o所需的物品集合"}, Material.DIAMOND),
    requiredLevel("requiredLevel", "所需等级", new String[]{"&7&o所需等级"}, FixedMaterial.getMaterial(Arrays.asList("EXPERIENCE_BOTTLE", "EXP_BOTTLE"))),
    requiredMagic("requiredMagic", "所需魔力", new String[]{"&7&o所需魔力", "&7&o(来自EcoSkills)"}, GUI.WRITABLE_BOOK),
    requiredMagics("requiredMagics", "所需魔力集合", new String[]{"&7&o所需的多种魔力", "&7&o(来自EcoSkills)"}, GUI.WRITABLE_BOOK),
    requiredMana("requiredMana", "所需法力", new String[]{"&7&o所需法力值", "&4&l需要: &6AureliumSkills/MMOCore"}, Material.WATER_BUCKET),
    requiredMoney("requiredMoney", "所需金钱", new String[]{"&7&o所需金钱", "&4&l需要: &6Vault"}, Material.GOLD_BLOCK),
    silent("silent", "静音", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("BELL", "JUKEBOW"))),
    slot("slot", "槽位", new String[]{"&7&o槽位"}, Material.ARMOR_STAND),
    stopCheckingOtherConditionsIfNotValid("stopCheckingOtherConditionsIfNotValid", "若不满足则不继续检查其他条件", new String[]{"&7&o若条件不满足则停止检查其他条件"}, GUI.WRITABLE_BOOK),
    string("string", "字符串", new String[]{"&7&o一个字符串"}, Material.PAPER),
    subPattern("subPattern", "子花纹", new String[]{"&7&o带选项的子花纹"}, Material.ANVIL),
    subPatterns("subPatterns", "子花纹集合", new String[]{"&7&o子花纹集合"}, Material.ANVIL),
    tags("tags", "标签", new String[]{"&7&o标签集合", "&8&o示例", "&a{age:3}", "&a{lit:true}", "&7&o参见minecraft.fandom.com/wiki/Block_states"}, GUI.WRITABLE_BOOK),
    title("title", "标题", new String[]{"&7&o标题"}, Material.NAME_TAG),
    titleAdjustement("titleAdjustement", "标题微调", new String[]{"&7&o标题位置或显示的微调"}, FixedMaterial.getMaterial(Collections.singletonList("PISTON"))),
    titleOptions("titleOptions", "标题选项", new String[]{"&7&o标题相关特性"}, Material.ANVIL),
    trimMaterial("trimMaterial", "护甲装饰材料", new String[]{"&7&o用于装饰护甲的材料"}, Material.DIAMOND),
    type("type", "类型", new String[]{"&7&o类型"}, GUI.COMPARATOR),
    usageConditions("usageConditions", "使用条件", new String[]{"&7&o物品使用条件"}, GUI.CLOCK),
    uuid("uuid", "UUID", new String[]{"&7&oUUID标识"}, Material.NAME_TAG),
    variable("variable", "变量", new String[]{"&7&o带有选项的变量"}, GUI.WRITABLE_BOOK),
    variableName("variableName", "变量名称", new String[]{"&7&o要创建/修改的变量名称"}, GUI.WRITABLE_BOOK),
    variableUpdate("variableUpdate", "变量更新", new String[]{"&7&o带选项的变量更新"}, GUI.WRITABLE_BOOK),
    variablesModification("variablesModification", "变量修改", new String[]{"&7&o修改变量的功能模块"}, GUI.WRITABLE_BOOK),
    velocity("velocity", "速度", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("FIREWORK_ROCKET", "ELYTRA"))),
    visualFire("visualFire", "视觉火焰", new String[]{}, Material.FLINT_AND_STEEL),
    visualItem("visualItem", "可视化物品", new String[]{""}, Material.ITEM_FRAME),
    bookFeatures("bookFeatures", "书本特性", new String[]{"&7&o书本相关特性"}, GUI.WRITABLE_BOOK),
    pages("pages", "页面", new String[]{"&7&o书的页面"}, GUI.WRITABLE_BOOK),
    author("author", "作者", new String[]{"&7&o书的作者"}, Material.NAME_TAG),
    equippableFeatures("equippableFeatures", "可装备特性", new String[]{"&7&o可装备相关特性"}, Material.DIAMOND_CHESTPLATE),
    enableSound("enableSound", "启用声音", new String[]{"&7&o启用音效"}, null),
    sound("sound", "声音", new String[]{"&7&o声音类型"}, Material.NOTE_BLOCK),
    equipModel("equipModel", "装备模型", new String[]{"&7&o装备/盔甲模型", "&7&o格式: namespace:id", "&7&o引用 /assets/<namespace>/models/equipment/<id>"}, FixedMaterial.getMaterial(Arrays.asList("BLUE_GLAZED_TERRACOTTA"))),
    cameraOverlay("cameraOverlay", "镜头叠加", new String[]{"&7&o镜头叠加材质", "&7&o格式: namespace:id", "&7&o引用 /assets/<namespace>/textures/<id>"}, FixedMaterial.getMaterial(Arrays.asList("BLUE_GLAZED_TERRACOTTA"))),
    damageableOnHurt("damageableOnHurt", "受伤时损耗耐久", new String[]{"&7&o玩家受伤时物品损坏耐久"}, null),
    dispensable("dispensable", "可由发射器发射", new String[]{"&7&o此物品可由发射器发射"}, null),
    swappable("swappable", "可交换", new String[]{"&7&o物品可在主手与副手之间交换"}, null),
    allowedEntities("allowedEntities", "允许的实体", new String[]{"&7&o可作用的实体列表"}, FixedMaterial.getMaterial(Arrays.asList("ZOMBIE_HEAD", "MONSTER_EGG"))),
    repairableFeatures("repairableFeatures", "可修复特性", new String[]{"&7&o可修复相关特性"}, Material.ANVIL),
    repairCost("repairCost", "修复花费", new String[]{"&7&o修复耐久的花费"}, GUI.CLOCK),
    glider("glider", "滑翔翼特性", new String[]{"&7&o滑翔翼特性"}, FixedMaterial.getMaterial(Arrays.asList("ELYTRA"))),
    itemModel("itemModel", "物品模型", new String[]{"&7&o物品模型名称", "&7&o格式: namespace:id", "&7&o引用 /assets/<namespace>/models/item/<id>"}, FixedMaterial.getMaterial(Arrays.asList("BLUE_GLAZED_TERRACOTTA"))),
    tooltipModel("tooltipModel", "提示模型", new String[]{"&7&o提示界面模型", "&7&o格式: namespace:id", "&7&o引用 /assets/<namespace>/textures/gui/sprites/tooltip/<id>_background", "&7&o以及 /assets/<namespace>/textures/gui/sprites/tooltip/<id>_frame"}, FixedMaterial.getMaterial(Arrays.asList("BLUE_GLAZED_TERRACOTTA"))),

    toolRules("toolRules", "工具规则", new String[]{"&7&o工具相关规则"}, Material.DIAMOND_PICKAXE),
    toolRule("toolRule", "工具规则项", new String[]{"&7&o单独的工具规则项"}, Material.DIAMOND_PICKAXE),
    miningSpeed("miningSpeed", "挖掘速度", new String[]{"&7&o工具的挖掘速度"}, GUI.CLOCK),
    enable("enable", "启用", new String[]{"&7&o启用工具特性"}, Material.LEVER),
    defaultMiningSpeed("defaultMiningSpeed", "默认挖掘速度", new String[]{"&7&o工具的默认挖掘速度"}, GUI.CLOCK),
    correctForDrops("correctForDrops", "合适掉落修正", new String[]{"&7&o此规则是否为对应方块的最佳工具", "&7&o从而能正常掉落物品"}, Material.LEVER),
    materials("blocks", "方块材质列表", new String[]{"&7&o此规则影响的方块列表"}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),
    damagePerBlock("damagePerBlock", "每方块耐久消耗", new String[]{"&7&o每破坏一个方块消耗的耐久"}, GUI.CLOCK),

    instrumentFeatures("instrumentFeatures", "乐器特性", new String[]{"&7&o乐器相关特性"}, Material.NOTE_BLOCK),
    instrument("instrument", "乐器", new String[]{"&7&o乐器类型"}, Material.NOTE_BLOCK),

    chargedProjectiles("chargedProjectiles", "充能弹射物", new String[]{"&7&o充能的弹射物列表"}, Material.ARROW),

    hitSound("hitSound", "击中音效", new String[]{"&7&o击中时的音效"}, Material.NOTE_BLOCK),
    useCooldownFeatures("useCooldownFeatures", "使用冷却特性", new String[]{"&7&o使用冷却相关特性"}, GUI.CLOCK),
    cooldownGroup("cooldownGroup", "冷却组", new String[]{"&7&o冷却组"}, GUI.WRITABLE_BOOK),
    vanillaUseCooldown("vanillaUseCooldown", "原版使用冷却", new String[]{"&7&o原版使用冷却"}, GUI.CLOCK),

    typeTarget("typeTarget", "目标类型", new String[]{"&7&o目标类型"}, Material.COMPASS),
    detailedClick("detailedClick", "指定点击类型", new String[]{"&7&o具体的点击类型"}, Material.COMPASS),
    usageModification("usageModification", "使用修改", new String[]{"&7&o使用次数修改"}, Material.BUCKET),
    cancelEvent("cancelEvent", "取消事件", new String[]{"&7&o取消原版事件"}, null),
    noActivatorRunIfTheEventIsCancelled("noActivatorRunIfTheEventIsCancelled", "事件取消则不触发激活器", new String[]{"&7&o若其他插件取消事件", "&7&o且此功能启用", "&7&o则激活器不执行"}, null),
    silenceOutput("silenceOutput", "静默输出", new String[]{"&7&o禁用命令输出信息", "&7&o(仅对控制台)"},
            null),
    mustBeAProjectileLaunchWithTheSameEI("mustBeAProjectileLaunchWithTheSameEI", "必须由相同EI发射的弹射物", new String[]{"&7&o必须是用同一EI发射的弹射物"}, Material.ARROW),
    desactiveDrops("desactiveDrops", "移除掉落物", new String[]{"&7&o移除方块/实体掉落"}, null),
    option("option", "选项", new String[]{"&7&o一个选项"}, Material.COMPASS),
    cooldownOptions("cooldownOptions", "冷却选项", new String[]{"&7&o冷却相关选项"}, GUI.CLOCK),
    globalCooldownOptions("globalCooldownOptions", "全局冷却选项", new String[]{"&7&o全局冷却设置", "&7&o(对 &e所有 &7&o玩家和实体生效)"}, GUI.CLOCK),
    detailedEntities("detailedEntities", "指定实体列表", new String[]{"&7&o指定可作用的实体列表", "&7&o空 = 所有实体"}, FixedMaterial.getMaterial(Arrays.asList("ZOMBIE_HEAD", "MONSTER_EGG"))),
    detailedTargetEntities("detailedTargetEntities", "指定目标实体列表", new String[]{"&7&o指定可作用的目标实体列表", "&7&o空 = 所有实体"}, FixedMaterial.getMaterial(Arrays.asList("ZOMBIE_HEAD", "MONSTER_EGG"))),
    detailedTargetBlocks("detailedTargetBlocks", "指定目标方块列表", new String[]{"&7&o指定可作用的目标方块列表", "&7&o空 = 所有方块"}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),

    detailedDamageCauses("detailedDamageCauses", "指定伤害原因列表", new String[]{"&7&o指定可作用的伤害原因列表", "&7&o空 = 所有原因"}, Material.BONE),
    detailedCommands("detailedCommands", "指定指令列表", new String[]{"&7&o指定可作用的指令列表", "&7&o空 = 无指令", "&7示例: &agamemode creative"}, GUI.WRITABLE_BOOK),
    detailedMessagesContains("detailedMessagesContains", "指定消息包含文本", new String[]{"&7&o指定消息必须包含的关键词列表", "&7&o空 = 无要求", "&7示例: &afriend"}, GUI.WRITABLE_BOOK),
    detailedMessagesEquals("detailedMessagesEquals", "指定消息精确匹配", new String[]{"&7&o指定消息必须精确匹配的文本列表", "&7&o空 = 无要求", "&7示例: &aHello my friend"}, GUI.WRITABLE_BOOK),
    detailedInventories("detailedInventories", "指定背包类型", new String[]{"&7&o指定允许的InventoryType列表"}, GUI.WRITABLE_BOOK),
    mustBeItsOwnInventory("mustBeItsOwnInventory", "必须在自身背包中", new String[]{"&7&o玩家必须在自己的背包界面中打开"}, Material.LEVER),

    commands_player("commands", "玩家命令", new String[]{"&7&o要由玩家执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    commands_block("commands", "方块命令", new String[]{"&7&o要由方块执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    targetCommands("targetCommands", "目标命令", new String[]{"&7&o要对目标执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    entityCommands("entityCommands", "实体命令", new String[]{"&7&o要对实体执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    blockCommands("blockCommands", "方块命令集合", new String[]{"&7&o要对方块执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    blockCommands_target_block("blockCommands", "目标方块命令", new String[]{"&7&o对目标方块执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    playerCommands("playerCommands", "玩家命令集合", new String[]{"&7&o玩家执行的命令集合"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    ownerCommands("ownerCommands", "拥有者命令", new String[]{"&7&o物品拥有者执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    consoleCommands("consoleCommands", "控制台命令", new String[]{"&7&o由控制台执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    targetPlayerCommands("targetPlayerCommands", "目标玩家命令", new String[]{"&7&o对目标玩家执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    targetEntityCommands("targetEntityCommands", "目标实体命令", new String[]{"&7&o对目标实体执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    targetBlockCommands("targetBlockCommands", "目标方块命令", new String[]{"&7&o对目标方块执行的命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),
    displayCommands("displayCommands", "显示命令", new String[]{"&7&o执行的显示命令"}, FixedMaterial.getMaterial(Arrays.asList("COMMAND_BLOCK", "COMMAND"))),

    playerConditions("playerConditions", "玩家条件", new String[]{""}, Material.ANVIL),
    targetConditions("targetConditions", "目标条件", new String[]{""}, Material.ANVIL),
    entityConditions("entityConditions", "实体条件", new String[]{""}, Material.ANVIL),
    blockConditions("blockConditions", "方块条件", new String[]{""}, Material.ANVIL),
    worldConditions("worldConditions", "世界条件", new String[]{""}, Material.ANVIL),
    itemConditions("itemConditions", "物品条件", new String[]{""}, Material.ANVIL),
    customConditions("customConditions", "自定义条件", new String[]{""}, Material.ANVIL),
    ownerConditions("ownerConditions", "拥有者条件", new String[]{""}, Material.ANVIL),
    targetBlockConditions("targetBlockConditions", "目标方块条件", new String[]{""}, Material.ANVIL),
    targetPlayerConditions("targetPlayerConditions", "目标玩家条件", new String[]{""}, Material.ANVIL),
    targetEntityConditions("targetEntityConditions", "目标实体条件", new String[]{""}, Material.ANVIL),
    displayConditions_conditions("displayConditions", "显示条件", new String[]{""}, Material.ANVIL),

    containsMineInCube("containsMineInCube", "立方体内包含矿物", new String[]{"&7&o检查立方体内是否包含矿物"}, Material.TNT),

    playerCooldownOptions("playerCooldownOptions", "玩家冷却选项", new String[]{"&7&o玩家冷却选项"}, GUI.CLOCK),
    entityCooldownOptions("entityCooldownOptions", "实体冷却选项", new String[]{"&7&o实体冷却选项"}, GUI.CLOCK),

    isRefreshableClean("isRefreshableClean", "可刷新清除", new String[]{"&7&o是否可刷新清除"}, null),
    refreshTag("refreshTagDoNotEdit", "刷新标签", new String[]{"&7&o刷新标签"}, null),

    otherEICooldowns("otherEICooldowns", "其他EI冷却", new String[]{"&7&o为其他EI增加冷却"}, Material.ANVIL),
    cooldown_activators("activators", "激活器列表", new String[]{"&7&o激活器列表", "&eALL &7&o表示全部激活器"}, GUI.WRITABLE_BOOK),
    canBeUsedOnlyByTheOwner("canBeUsedOnlyByTheOwner", "仅限拥有者使用", new String[]{"&7&o仅拥有此物品的玩家可使用", "&4⚠ &c需要在物品信息中存储开启为true"}, null),
    cancelEventIfNotOwner("cancelEventIfNotOwner", "若非拥有者则取消事件", new String[]{"&7&o若使用者非此物品拥有者则取消事件"}, null),
    onlyOwnerBlackListedActivators("onlyOwnerBlackListedActivators", "黑名单激活器", new String[]{"&7&o黑名单激活器列表", "&7&o(即使仅限拥有者功能启用，这些激活器也可被他人使用)"}, Material.BARRIER),
    EXECUTABLEITEM("EXECUTABLEITEM", "可执行物品", new String[]{}, Material.EMERALD),

    lore("lore", "物品描述", new String[]{"&7&o物品的描述信息"}, Material.PAPER),
    glowDuration("glowDuration", "发光持续时间", new String[]{"&7&o发光效果持续时间"}, GUI.CLOCK),

    disableEnchantGlide("disableEnchantGlide", "禁用附魔滑翔效果", new String[]{"&7&o禁用附魔导致的滑翔效果"}, Material.BEACON),

    customStackSize("customStackSize", "自定义堆叠大小", new String[]{"&7&o自定义物品堆叠上限"}, Material.BUCKET),

    usage("usage", "使用次数", new String[]{"&7&o物品的可使用次数", "&a-1 &7&o= 无限", "&a增加 &7&o或 &c减少 &7&o此值可通过", "&eUsageModification &7&o在激活器中实现"}, Material.BUCKET),
    whitelistedWorlds("whitelistedWorlds", "世界白名单", new String[]{"&7&o该特性适用的世界列表"}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),
    armorColor("armorColor", "护甲颜色", new String[]{"&7&o护甲的颜色"}, Material.LEATHER_CHESTPLATE),
    fireworkColor("fireworkColor", "烟花颜色", new String[]{"&7&o烟花的颜色"}, FixedMaterial.getMaterial(Arrays.asList("FIREWORK_STAR", "FIREWORK_CHARGE"))),
    recognitions("recognitions", "识别信息", new String[]{"&7&o物品的识别标签"}, Material.PAPER),

    food("food", "食物特性", new String[]{"&7&o食物特性"}, Material.COOKED_BEEF),
    nutrition("nutrition", "营养值", new String[]{"&7食物的营养值"}, GUI.CLOCK),
    saturation("saturation", "饱和度", new String[]{"&7食物的饱和度"}, GUI.CLOCK),
    isMeat("isMeat", "是否是肉类", new String[]{"&7食物是否为肉类"}, null),
    canAlwaysEat("canAlwaysEat", "可随时食用", new String[]{"&7玩家是否可在饱腹时也能进食"}, null),
    eatSeconds("eatSeconds", "食用时间(秒)", new String[]{"&7进食所需的秒数"}, GUI.CLOCK),

    blockState("blockState", "方块状态", new String[]{"&7&o方块状态信息"}, Material.BRICK),
    blockStatePlus("blockStatePlus", "方块扩展状态", new String[]{"&7&o更详细的方块状态信息"}, Material.BRICK),
    bundleContent("bundleContent", "捆包内容", new String[]{"&7&o捆包中的物品内容"}, FixedMaterial.getMaterial(Arrays.asList("BUNDLE"))),

    itemRarity("itemRarity", "物品稀有度", new String[]{"&7&o物品的稀有程度"}, Material.EMERALD),
    rarity("rarity", "稀有度", new String[]{"&7&o物品稀有度等级"}, Material.EMERALD),
    enableRarity("enableRarity", "启用稀有度", new String[]{"&7&o是否启用物品稀有度特性"}, null),

    durability_features("durability", "耐久特性", new String[]{"&7&o关于耐久的特性"}, Material.ANVIL),
    maxDurability("maxDurability", "最大耐久度", new String[]{"&7&o最大耐久度特性"}, Material.ANVIL),
    isDurabilityBasedOnUsage("isDurabilityBasedOnUsage", "耐久基于使用次数", new String[]{"&7&o忽略耐久特性，使用次数作为耐久"}, null),

    displayConditions("displayConditions", "显示条件特性", new String[]{"&7&o在lore中显示条件"}, GUI.WRITABLE_BOOK),
    enableFeature("enableFeature", "启用特性", new String[]{"&7&o启用或禁用此特性"}, null),

    autoUpdateFeatures("autoUpdateFeatures", "自动更新特性", new String[]{"&7&o自动更新你的EI"}, GUI.GRINDSTONE),
    autoUpdateItem("autoUpdateItem", "自动更新物品", new String[]{"&7&o自动更新物品"}, null),
    updateMaterial("updateMaterial", "更新材质", new String[]{"&7&o更新物品材质"}, null),
    updateName("updateName", "更新名称", new String[]{"&7&o更新物品名称"}, null),
    updateLore("updateLore", "更新描述", new String[]{"&7&o更新物品描述"}, null),
    updateDurability("updateDurability", "更新耐久", new String[]{"&7&o更新物品耐久"}, null),
    updateAttributes("updateAttributes", "更新属性", new String[]{"&7&o更新物品属性"}, null),
    updateEnchants("updateEnchants", "更新附魔", new String[]{"&7&o更新物品附魔"}, null),
    updateCustomModelData("updateCustomModelData", "更新自定义模型数据", new String[]{"&7&o更新物品的自定义模型数据"}, null),
    updateArmorSettings("updateArmorSettings", "更新护甲设置", new String[]{"&7&o更新护甲的相关设置"}, null),


    brewingStandFeatures("brewingStandFeatures", "酿造台特性", new String[]{"&7&o酿造台相关特性"}, Material.BREWING_STAND),
    brewingStandSpeed("brewingStandSpeed", "酿造台速度", new String[]{"&7&o酿造台的工作速度"}, Material.BREWING_STAND),

    boundingBoxZones("boundingBoxZones", "包围盒区域", new String[]{}, GUI.WRITABLE_BOOK),
    boundingBoxZone("boundingBoxZone", "包围盒区域项", new String[]{""}, GUI.WRITABLE_BOOK),
    from("from", "起点", new String[]{""}, GUI.CLOCK),
    to("to", "终点", new String[]{""}, GUI.CLOCK),

    containerFeatures("containerFeatures", "容器特性", new String[]{"&7&o适用于箱子、漏斗等的特性"}, Material.CHEST),
    whitelistMaterials("whitelistMaterials", "白名单材料", new String[]{"&7&o白名单材料列表", "&7&o只有这些材料可放入容器"}, Material.CHEST),
    blacklistMaterials("blacklistMaterials", "黑名单材料", new String[]{"&7&o黑名单材料列表", "&7&o这些材料不可放入容器"}, Material.CHEST),
    isLocked("isLocked", "是否锁定", new String[]{"&7&o容器是否被锁定？"}, null),
    lockedName("lockedName", "锁定名称", new String[]{"&7&o可解锁容器的物品名称"}, Material.NAME_TAG),
    inventoryTitle("inventoryTitle", "背包标题", new String[]{"&7&o背包界面的标题"}, Material.NAME_TAG),

    furnaceFeatures("furnaceFeatures", "熔炉特性", new String[]{"&7&o熔炉相关特性"}, Material.FURNACE),
    furnaceSpeed("furnaceSpeed", "熔炉速度", new String[]{"&7&o熔炉的运作速度"}, Material.FURNACE),
    infiniteFuel("infiniteFuel", "无限燃料", new String[]{"&7&o熔炉拥有无限燃料"}, Material.FURNACE),
    infiniteVisualLit("infiniteVisualLit", "无限视觉点燃", new String[]{"&7&o熔炉将始终显示为点燃状态，仅视觉效果"}, Material.FURNACE),
    fortuneChance("fortuneChance", "幸运概率", new String[]{"&7&o获得额外产物的概率", "&7&o范围: 0到1"}, Material.FURNACE),
    fortuneMultiplier("fortuneMultiplier", "幸运倍数", new String[]{"&7&o额外产物的倍数"}, Material.FURNACE),

    directionalFeatures("directionalFeatures", "方向特性", new String[]{"&7&o与方向相关的特性"}, Material.COMPASS),
    forceBlockFaceOnPlace("forceBlockFaceOnPlace", "强制方块朝向", new String[]{"&7&o放置时强制方块面向指定方向"}, Material.LEVER),
    blockFaceOnPlace("blockFaceOnPlace", "放置时方块朝向", new String[]{"&7&o方块放置时的朝向"}, Material.COMPASS),

    hopperFeatures("hopperFeatures", "漏斗特性", new String[]{"&7&o漏斗相关特性"}, Material.HOPPER),
    amountItemsTransferred("amountItemsTransferred", "传输物品数量", new String[]{"&7&o每次传输的物品数量"}, Material.HOPPER),

    chiseledBookshelfFeatures("chiseledBookshelfFeatures", "雕刻书架特性", new String[]{"&7&o雕刻书架相关特性"}, FixedMaterial.getMaterial(Arrays.asList("CHISELED_BOOKSHELF", "BARRIER"))),
    occupiedSlots("occupiedSlots", "已占用槽位", new String[]{"&7&o书架中已占用的槽位"}, FixedMaterial.getMaterial(Arrays.asList("CHISELED_BOOKSHELF", "BARRIER"))),

    InteractionZoneFeatures("InteractionZoneFeatures", "交互区域特性", new String[]{"&7&o按下F3 + B可视化区域"}, Material.ITEM_FRAME),
    width("width", "宽度", new String[]{"&7&o按F3 + B查看区域"}, GUI.CLOCK),
    height("height", "高度", new String[]{"&7&o按F3 + B查看区域"}, GUI.CLOCK),
    isCollidable("isCollidable", "可碰撞", new String[]{"&c&o实验性特性"}, null),

    DisplayFeatures("DisplayFeatures", "显示特性", new String[]{""}, Material.ITEM_FRAME),
    scale("scale", "缩放", new String[]{""}, Material.HOPPER),
    aligned("aligned", "对齐", new String[]{"&7&o显示是否与其他方块对齐"}, Material.LEVER),
    customPitch("customPitch", "自定义俯仰角", new String[]{"&7&o自定义旋转俯仰角"}, GUI.COMPARATOR),
    customY("customY", "自定义Y轴位置", new String[]{"&7&o自定义Y坐标"}, GUI.COMPARATOR),
    clickToBreak("clickToBreak", "点击破坏次数", new String[]{"&7&o需要点击多少次才可破坏该EB"}, GUI.COMPARATOR),

    EXECUTABLEBLOCK("EXECUTABLEBLOCK", "可执行方块", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),
    EXECUTABLEBLOCKPLACED("EXECUTABLEBLOCKPLACED", "已放置的可执行方块", new String[]{}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),
    EXECUTABLEEVENT("EXECUTABLEEVENT", "可执行事件", new String[]{}, Material.EMERALD),
    FURNITURE("FURNITURE", "家具", new String[]{}, Material.CHEST),
    FURNITUREPLACED("FURNITUREPLACED", "已放置家具", new String[]{}, Material.CHEST),

    creationType("creationType", "创建类型", new String[]{"&7&o创建类型"}, Material.COMPASS),
    spawnerType("spawnerType", "刷怪笼类型", new String[]{"&7&o刷怪笼的实体类型"}, FixedMaterial.getMaterial(Arrays.asList("SPAWNER"))),
    dropType("dropType", "掉落类型", new String[]{"&7&o掉落类型"}, Material.COMPASS),
    cancelGravity("cancelGravity", "取消重力", new String[]{"&7&o是否取消方块的重力"}, null),
    cancelLiquidDestroy("cancelLiquidDestroy", "取消被液体摧毁", new String[]{"&7&o方块是否能被液体摧毁"}, null),
    onlyBreakableWithEI("onlyBreakableWithEI", "仅可用特定EI破坏", new String[]{"&7&o可破坏该方块的特定EI列表"}, Material.DIAMOND_PICKAXE),
    dropBlockIfItIsBroken("dropBlockIfItIsBroken", "破坏时掉落方块本身", new String[]{"&7&o方块被破坏时掉落自身方块"}, Material.LEVER),
    dropBlockWhenItExplodes("dropBlockWhenItExplodes", "爆炸时掉落方块", new String[]{"&7&o方块被爆炸破坏时掉落自身"}, Material.LEVER),
    dropBlockWhenItBurns("dropBlockWhenItBurns", "燃烧时掉落方块", new String[]{"&7&o方块被烧毁时掉落自身"}, Material.LEVER),
    resetInternalDatasWhenBroken("resetInternalDatasWhenBroken", "破坏时重置内部数据", new String[]{"&7&o方块被破坏后重置内部数据(使用次数、变量等)"}, Material.LEVER),
    canBeMoved("canBeMoved", "可被移动", new String[]{"&7&o方块是否可被推动"}, Material.LEVER),
    itemsAdderID("itemsAdderID", "ItemsAdder ID", new String[]{"&7&oItemsAdder方块ID"}, Material.DIAMOND_BLOCK),
    oraxenID("oraxenID", "Oraxen ID", new String[]{"&7&oOraxen的ID"}, Material.DIAMOND_BLOCK),
    interactionRange("interactionRange", "交互范围", new String[]{"&7&o交互范围限制"}, GUI.CLOCK),

    enabled("enabled", "已启用", new String[]{"&7&o事件是否已启用"}, null),
    editorIcon("editorIcon", "编辑器图标", new String[]{}, Material.LEVER),
    disabledWorlds("disabledWorlds", "禁用的世界", new String[]{"&7&o在这些世界中禁用"}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),

    displayFeatures("displayFeatures", "显示特性", new String[]{"&7&o显示相关特性"}, Material.ITEM_FRAME),
    blockLight("blockLight", "方块光源等级", new String[]{""}, FixedMaterial.getMaterial(Arrays.asList("LIGHT"))),
    skyLight("skyLight", "天空光源等级", new String[]{""}, FixedMaterial.getMaterial(Arrays.asList("LIGHT"))),
    glowColor("glowColor", "发光颜色", new String[]{""}, FixedMaterial.getMaterial(Arrays.asList("RED_DYE", "INK_SACK"))),

    TRADE("TRADE", "交易", new String[]{""}, Material.GOLD_INGOT),

    description("description", "描述", new String[]{"&7&o此交易的描述"}, GUI.WRITABLE_BOOK),
    delayOfTrade("delayOfTrade", "交易延迟", new String[]{"&7&o交易延迟时间(秒)"}, GUI.CLOCK),
    glowWhenTrade("glowWhenTrade", "交易时发光", new String[]{"&7&o猪灵在交易时发光"}, Material.GLOWSTONE),
    requiredObject("requiredObject", "所需对象", new String[]{}, Material.COMPASS),

    SCREEN("SCREEN", "屏幕", new String[]{""}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),
    SCREENUNIT("SCREENUNIT", "屏幕单元", new String[]{""}, FixedMaterial.getMaterial(Arrays.asList("GRASS_BLOCK", "GRASS"))),

    keepDefaultAttributes("keepDefaultAttributes", "保留默认属性", new String[]{"&7&o在1.19+中保留默认属性"}, null),
    ignoreKeepDefaultAttributesFeature("ignoreKeepDefaultAttributesFeature", "忽略保留默认属性特性", new String[]{"&7&o对于新物品请保持为false", "&7&o如果是旧物品可设true以更新", "&7&o注意此操作可能影响商人或自定义配方"}, null),

    leverUUID("leverUUID", "lever UUID", new String[]{"&7&o该拉杆的UUID"}, GUI.CLOCK),
    interactionUUID("interactionUUID", "interaction UUID", new String[]{"&7&o交互UUID"}, GUI.CLOCK),
    rotation("rotation", "旋转", new String[]{"&7&o拉杆的旋转方向"}, GUI.CLOCK),
    glowWhenPowered("glowWhenPowered", "通电时发光", new String[]{"&7&o拉杆通电时发光"}, GUI.CLOCK),

    EXECUTABLELEVER("EXECUTABLELEVER", "可执行拉杆", new String[]{}, Material.LEVER),

    startDate("startDate", "开始日期", new String[]{"&7&o特性开始日期"}, GUI.CLOCK),
    endDate("endDate", "结束日期", new String[]{"&7&o特性结束日期"}, GUI.CLOCK),
    when("when", "何时", new String[]{"&7&o此特性何时生效"}, GUI.CLOCK),
    scheduleFeatures("scheduleFeatures", "计划任务特性", new String[]{"&7&o定时计划相关特性"}, GUI.CLOCK),

    aboveValue("aboveValue", "上方数值", new String[]{"&7&o方块上方的值"}, GUI.CLOCK),
    activator("activator", "触发器", new String[]{"&7&o单个触发器设置"}, Material.BEACON),
    activators("activators", "触发器集合", new String[]{"&7&o所有可用的触发器"}, Material.BEACON),
    armorTrim("armorTrim", "护甲装饰", new String[]{"&7&o护甲装饰相关设置"}, FixedMaterial.getMaterial(Arrays.asList("COAST_ARMOR_TRIM_SMITHING_TEMPLATE"))),
    aroundBlock("AroundBlock", "周围方块", new String[]{"&7&o检查周围方块的条件"}, Material.STONE),
    aroundBlockCdts("blockAroundCdts", "周围方块条件", new String[]{"&7&o周围方块的具体条件"}, Material.STONE),
    blockTypeMustBe("blockTypeMustBe", "必需的方块类型", new String[]{"&7&o指定必需的方块类型"}, GUI.WRITABLE_BOOK),
    dropOptions("dropOptions", "掉落选项", new String[]{"&7&o物品掉落相关设置"}, Material.ANVIL),
    eastValue("eastValue", "东向数值", new String[]{"&7&o东向方块的检查值"}, GUI.CLOCK),
    errorMsg("errorMsg", "错误提示", new String[]{"&7&o当条件不满足时显示的错误消息"}, GUI.WRITABLE_BOOK),
    giveFirstJoinFeatures("giveFirstJoin", "首次加入给予", new String[]{"&7&o玩家首次加入服务器时给予物品的相关设置"}, Material.ANVIL),
    hiders("hiders", "隐藏选项", new String[]{"&7&o控制物品各种属性的显示与隐藏"}, Material.ANVIL),
    northValue("northValue", "北向数值", new String[]{"&7&o北向方块的检查值"}, GUI.CLOCK),
    restrictions("restrictions", "限制条件", new String[]{"&7&o物品使用的各种限制条件"}, Material.ANVIL),
    southValue("southValue", "南向数值", new String[]{"&7&o南向方块的检查值"}, GUI.CLOCK),
    underValue("underValue", "下方数值", new String[]{"&7&o下方方块的检查值"}, GUI.CLOCK),
    usePerDay("usePerDay", "每日使用限制", new String[]{"&7&o限制物品每天可使用的次数"}, Material.BUCKET),
    variables("variables", "变量集合", new String[]{"&7&o用于存储数据的变量系统", "&7&o可记录如击杀数、死亡数等信息"}, GUI.WRITABLE_BOOK),
    attributes("attributes", "属性集合", new String[]{"&7&o物品的属性列表", "&7&o如攻击伤害、护甲值等"}, Material.PAPER),
    enchantments("enchantments", "附魔集合", new String[]{"&7&o物品所拥有的附魔列表", "&7&o包含各种附魔及其等级"}, Material.ENCHANTED_BOOK),
    westValue("westValue", "西向数值", new String[]{"&7&o西向方块的检查值"}, GUI.CLOCK),
    glow("glow", "物品发光", SCore.is1v20v5Plus() ? new String[]{"&7&o物品发光效果"} : new String[]{"&7&o物品发光效果", "&4⚠ &c这会添加一个无用的附魔", "&c并隐藏附魔标签"}, Material.BEACON),
    disableStack("disableStack", "禁用堆叠", new String[]{"&7&o禁止此物品进行堆叠", "&7&o强制单个物品独立存在"}, null),
    keepItemOnDeath("keepItemOnDeath", "死亡不掉落", new String[]{"&7&o玩家死亡时不掉落此物品"}, Material.BONE),
    storeItemInfo("storeItemInfo", "存储物品信息", new String[]{"&7&o存储物品的额外信息", "&7&o比如物品的拥有者等"}, null),
    customModelData_ei("customModelData", "自定义模型数据", new String[]{"&7&o物品的自定义模型数据", "&7&o用于自定义物品外观", "&2✔ &a&o详见Wiki教程！"}, FixedMaterial.getMaterial(Arrays.asList("BLUE_GLAZED_TERRACOTTA"))),
    nbt("nbt", "NBT标签", new String[]{"&7&oNBT标签功能", "&7&o需要插件 &eNBTAPI"}, Material.NAME_TAG),
    durability("durability", "耐久度", new String[]{"&7&o物品的当前耐久度"}, Material.ANVIL),
    unbreakable("unbreakable", "不可破坏", new String[]{"&7&o开启此选项使物品永不损坏", "&7&o类似于原版不毁属性"}, Material.BEDROCK),


    usageLimit("usageLimit", "Usage limit",new String[]{"&7&oThe usage limit of the item", "&7&oUsage can't be increased above this value"}, Material.BUCKET),
    updateHiders("updateHiders", "Update Hiders", new String[]{"&7&oUpdate the hide flags of the item"}, null),

    ;

    private String configName;
    private String editorName;
    private String[] editorDescription;
    private Material editorMaterial;
    private boolean requirePremium;
    private SavingVerbosityLevel savingVerbosityLevel;

    FeatureSettingsSCoreZH(String name, String editorName, String[] editorDescription, Material editorMaterial) {
        this.configName = "";
        this.editorName = editorName;
        this.editorDescription = editorDescription;
        this.editorMaterial = editorMaterial;
        this.requirePremium = false;
        this.savingVerbosityLevel = SavingVerbosityLevel.SAVE_ALWAYS;
    }

    @Override
    public String getIdentifier() {
        return this.name();
    }

    @Override
    public String getName() {
        return configName;
    }

    @Override
    public void setName(String name) {
        this.configName = name;
    }

    @Override
    public String getEditorName() {
        return editorName;
    }

    @Override
    public String[] getEditorDescription() {
        return editorDescription;
    }

    @Override
    public String[] getEditorDescriptionBrut() {
        return editorDescription;
    }

    @Override
    public Material getEditorMaterial() {
        return editorMaterial;
    }

    @Override
    public boolean isRequirePremium() {
        return requirePremium;
    }

    @Override
    public void setRequirePremium(boolean requirePremium) {
        this.requirePremium = requirePremium;
    }

    @Override
    public SavingVerbosityLevel getSavingVerbosityLevel() {
        return savingVerbosityLevel;
    }

    @Override
    public void setSavingVerbosityLevel(SavingVerbosityLevel savingVerbosityLevel) {
        this.savingVerbosityLevel = savingVerbosityLevel;
    }
}