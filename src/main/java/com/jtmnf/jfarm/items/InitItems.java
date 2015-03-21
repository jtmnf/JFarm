package com.jtmnf.jfarm.items;

import com.jtmnf.jfarm.blocks.InitBlocks;
import com.jtmnf.jfarm.creativetab.InitCreativeTab;
import com.jtmnf.jfarm.reference.ModReference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InitItems extends Item{

    public InitItems() {
        super();

        this.setCreativeTab(InitCreativeTab.JFARM_TAB);
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("item.%s%s", ModReference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return String.format("item.%s%s", ModReference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
        // item.modid:itemname.name
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }
}
