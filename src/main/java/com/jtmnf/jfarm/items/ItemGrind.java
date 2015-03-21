package com.jtmnf.jfarm.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemGrind extends InitItems {

    public ItemGrind() {
        super();
        this.setUnlocalizedName("grind");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bool) {
        list.add("Temporary Item");
    }
}
