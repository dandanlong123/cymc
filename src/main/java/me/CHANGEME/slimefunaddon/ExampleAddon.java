package me.CHANGEME.slimefunaddon;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class  ExampleAddon extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // 例如，您可以启动自动更新程序
        }
        getLogger().info("****************");
        getLogger().info("*****我的插件*****");
        getLogger().info("****************");

        /*
         * 1. 创建新类别
         * 此类别将使用以下ItemStack
         */
        ItemStack itemGroupItem = new CustomItemStack(Material.DIAMOND, "&4附加类别", "", "&a> 点击打开");

        // 给你的类别一个唯一的id。
        NamespacedKey itemGroupId = new NamespacedKey(this, "addon_category");
        ItemGroup itemGroup = new ItemGroup(itemGroupId, itemGroupItem);

        /*
         * 2. 创建一个新的SlimefunItemStack
         * 这个类有很多构造函数，这非常重要
         * 给每个项目一个唯一的id.
         */
        SlimefunItemStack slimefunItem = new SlimefunItemStack("COOL_DIAMOND", Material.DIAMOND, "&4酷钻石", "&c+20% 冷静");

        /*
         * 3. 制作食谱
         * 配方是一个长度为9的ItemStack数组。
         * 它代表3x3工艺网格中的成型配方。
         * 指定了制作此配方的机器
         * 进一步向下为RecipeType。
         */
        ItemStack[] recipe = { new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD),
             null, new ItemStack(Material.DIAMOND), null, 
             new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD) };

        /*
         * 4. 登记项目
         * 现在您只需注册该项目。
         * RecipeType.ENHANCED_CRAFTING_TABLE是指中的机器
         * 在其中制作此项目。
         * Slimefun本身的配方类型将自动将配方添加到该机器。
         */
        SlimefunItem item = new SlimefunItem(itemGroup, slimefunItem, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(this);
    }

    @Override
    public void onDisable() {
        // 禁用插件的逻辑。。。
    }

    @Override
    public String getBugTrackerURL() {
        // 您可以在此处返回指向Bug跟踪器的链接，而不是null
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * 您需要在此处返回对插件的引用。
         * 如果您使用的是主类，只需返回“this”。
         */
        return this;
    }

}
