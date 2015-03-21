package com.jtmnf.jfarm.handler;

import com.jtmnf.jfarm.JFarm;
import com.jtmnf.jfarm.client.interfaces.ContainerFarmCompressor;
import com.jtmnf.jfarm.client.interfaces.GuiFarmCompressor;
import com.jtmnf.jfarm.tileentities.TileEntityFarmCompressor;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    public GuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler(JFarm.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID){
            case 0:
                TileEntity tileEntity = world.getTileEntity(x, y, z);

                if(tileEntity != null && tileEntity instanceof TileEntityFarmCompressor){
                    return new ContainerFarmCompressor(player.inventory, (TileEntityFarmCompressor) tileEntity);
                }
                break;
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID){
            case 0:
                TileEntity tileEntity = world.getTileEntity(x, y, z);

                if(tileEntity != null && tileEntity instanceof TileEntityFarmCompressor){
                    return new GuiFarmCompressor(player.inventory, (TileEntityFarmCompressor) tileEntity);
                }
                break;
        }

        return null;
    }
}
