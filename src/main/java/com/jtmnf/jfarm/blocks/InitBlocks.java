package com.jtmnf.jfarm.blocks;

import com.jtmnf.jfarm.creativetab.InitCreativeTab;
import com.jtmnf.jfarm.reference.ModReference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class InitBlocks extends BlockContainer{
    public InitBlocks(){
        this(Material.rock);
    }

    public InitBlocks(Material material) {
        super(material);
        this.setCreativeTab(InitCreativeTab.JFARM_TAB);

        setHardness(2.5F);
        setStepSound(Block.soundTypePiston);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", ModReference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int parameter) {
        return null;
    }
}
