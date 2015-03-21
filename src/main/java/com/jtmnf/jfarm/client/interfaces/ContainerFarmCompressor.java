package com.jtmnf.jfarm.client.interfaces;

import com.jtmnf.jfarm.tileentities.TileEntityFarmCompressor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFarmCompressor extends Container {
    TileEntityFarmCompressor farmCompressor;

    public ContainerFarmCompressor(InventoryPlayer inventoryPlayer, TileEntityFarmCompressor farmCompressor){
        this.farmCompressor = farmCompressor;

        for (int x = 0; x < 9; ++x){
            addSlotToContainer(new Slot(inventoryPlayer, x, (8+18*x), 142));
        }

        for (int y = 0; y < 3; ++y){
            for (int x = 0; x < 9; ++x){
                addSlotToContainer(new Slot(inventoryPlayer, (x+y*9+9), (8+18*x), (84+y*18)));
            }
        }

        addSlotToContainer(new SlotWheat(farmCompressor, 0, 62, 30));
        addSlotToContainer(new SlotGrindWheat(farmCompressor, 1, 98, 30));
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return farmCompressor.isUseableByPlayer(p_75145_1_);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i){
        Slot slot = getSlot(i);

        if(slot != null && slot.getHasStack()){
            ItemStack stack = slot.getStack();
            ItemStack result = stack.copy();

            if(i >= 36){
                if(!mergeItemStack(stack, 0, 36, false)) {
                    return null;
                }
            }
            else if(stack.getDisplayName() != Blocks.wheat.getLocalizedName() || !mergeItemStack(stack, 36, 36 + farmCompressor.getSizeInventory(), false)){
                return null;
            }

            if(stack.stackSize == 0){
                slot.putStack(null);
            }
            else{
                slot.onSlotChanged();
            }

            slot.onPickupFromSlot(player, stack);
            return result;
        }

        return null;
    }
}
