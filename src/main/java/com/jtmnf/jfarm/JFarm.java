package com.jtmnf.jfarm;

import com.jtmnf.jfarm.handler.GuiHandler;
import com.jtmnf.jfarm.init.JFarmBlocks;
import com.jtmnf.jfarm.init.JFarmItems;
import com.jtmnf.jfarm.init.JFarmRecipes;
import com.jtmnf.jfarm.init.JFarmTileEntities;
import com.jtmnf.jfarm.proxy.IProxy;
import com.jtmnf.jfarm.reference.ModReference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModReference.MOD_ID, name = ModReference.MOD_NAME, version = ModReference.VERSION)
public class JFarm {

    @Mod.Instance(ModReference.MOD_ID)
    public static JFarm instance;

    @SidedProxy(clientSide = ModReference.CLIENT_PROXY_CLASS, serverSide = ModReference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        JFarmBlocks.initJFarmBlocks();
        JFarmItems.initJFarmItems();
        JFarmTileEntities.initJFarmTileEntities();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        JFarmRecipes.initJFarmRecipes();
        new GuiHandler();
    }

    @Mod.EventHandler
    public void posInit(FMLPostInitializationEvent event){

    }
}
