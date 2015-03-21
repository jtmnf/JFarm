package com.jtmnf.jfarm.init;

import com.jtmnf.jfarm.items.InitItems;
import com.jtmnf.jfarm.items.ItemGrind;
import com.jtmnf.jfarm.items.ItemGrindWheat;
import com.jtmnf.jfarm.reference.ModReference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(ModReference.MOD_ID)
public class JFarmItems {

    public static final InitItems grind = new ItemGrind();
    public static final InitItems grindWheat = new ItemGrindWheat();

    public static void initJFarmItems(){
        GameRegistry.registerItem(grind, "grind");
        GameRegistry.registerItem(grindWheat, "grindWheat");
    }
}
