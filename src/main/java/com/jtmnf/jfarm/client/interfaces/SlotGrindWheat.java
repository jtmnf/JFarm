package com.jtmnf.jfarm.client.interfaces;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGrindWheat extends Slot{
    public SlotGrindWheat(IInventory iInventory, int id, int x, int y) {
        super(iInventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack p_75214_1_) {
        return "Grinded Wheat".equals(p_75214_1_.getDisplayName());
    }
}
