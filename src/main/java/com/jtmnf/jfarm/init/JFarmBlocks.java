package com.jtmnf.jfarm.init;

import com.jtmnf.jfarm.blocks.BlockFarmCompressor;
import com.jtmnf.jfarm.blocks.InitBlocks;
import com.jtmnf.jfarm.reference.ModReference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(ModReference.MOD_ID)
public class JFarmBlocks {
    public static final InitBlocks farmCompressor = new BlockFarmCompressor();

    public static void initJFarmBlocks(){
        GameRegistry.registerBlock(farmCompressor, "farmCompressor");
    }
}
