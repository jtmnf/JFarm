package com.jtmnf.jfarm.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class JFarmRecipes {
    public static void initJFarmRecipes() {
        GameRegistry.addSmelting(new JFarmItems().grindWheat, new ItemStack(Items.bread, 1), 0);
        GameRegistry.addRecipe(new ItemStack(JFarmBlocks.farmCompressor, 1),
                "SSS",
                "SGS",
                "SPS",
                'S', new ItemStack(Blocks.stone),
                'G', new ItemStack(JFarmItems.grind),
                'P', new ItemStack(Blocks.piston));
        GameRegistry.addRecipe(new ItemStack(JFarmItems.grind, 2),
                "S S",
                " S ",
                "S S",
                'S', new ItemStack(Items.stick));
    }
}
