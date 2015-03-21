package com.jtmnf.jfarm.creativetab;

import com.jtmnf.jfarm.reference.ModReference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class InitCreativeTab {
    //TODO
    public static final CreativeTabs JFARM_TAB = new CreativeTabs(ModReference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return Items.arrow;
        }
    };
}
