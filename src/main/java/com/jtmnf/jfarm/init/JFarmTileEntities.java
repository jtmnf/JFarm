package com.jtmnf.jfarm.init;

import com.jtmnf.jfarm.reference.ModReference;
import com.jtmnf.jfarm.tileentities.TileEntityFarmCompressor;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(ModReference.MOD_ID)
public class JFarmTileEntities {
    public static void initJFarmTileEntities(){
        GameRegistry.registerTileEntity(TileEntityFarmCompressor.class, "tileentityfarmcompressor");
    }
}
