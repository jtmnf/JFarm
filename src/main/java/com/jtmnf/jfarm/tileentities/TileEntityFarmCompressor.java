package com.jtmnf.jfarm.tileentities;

import com.jtmnf.jfarm.init.JFarmItems;
import com.jtmnf.jfarm.items.InitItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFarmCompressor extends TileEntity implements IInventory {

    private ItemStack[] items;
    public TileEntityFarmCompressor(){
        items = new ItemStack[2];
    }

    @Override
    public int getSizeInventory() {
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {
        return items[p_70301_1_];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        ItemStack itemStack = getStackInSlot(p_70298_1_);

        if(itemStack != null){
            if(itemStack.stackSize <= p_70298_2_){
                setInventorySlotContents(p_70298_1_, null);
            }
            else{
                itemStack = itemStack.splitStack(p_70298_2_);
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        ItemStack stack = getStackInSlot(i);

        setInventorySlotContents(i, null);

        return stack;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        items[i] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()){
            stack.stackSize = getInventoryStackLimit();
        }

        if(stack != null){
            items[1] = new ItemStack(new JFarmItems().grindWheat, stack.stackSize);
            items[i].stackSize = 0;
        }

        markDirty();
    }

    @Override
    public String getInventoryName() {
        return "InventoryFarmCompressor";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return p_70300_1_.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack stack) {
        return stack.getDisplayName() == "Wheat";
    }

    public int getWheat(){
        int count = 0;

        if(getStackInSlot(0) != null){
            count = getStackInSlot(0).stackSize;
        }

        return count;
    }

    @Override
    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);

        NBTTagList items = new NBTTagList();

        for(int i = 0; i < getSizeInventory(); ++i){
            ItemStack stack = getStackInSlot(i);

            if (stack != null){
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", (byte) i);

                stack.writeToNBT(item);
                items.appendTag(item);
            }
        }

        p_145841_1_.setTag("Items", items);
    }

    @Override
    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);

        NBTTagList items = p_145839_1_.getTagList("Items", p_145839_1_.getId());

        for (int i = 0; i < items.tagCount(); ++i){
            NBTTagCompound item = items.getCompoundTagAt(i);

            int slot = item.getByte("Slot");

            if(slot >= 0 && slot < getSizeInventory()){
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
            }
        }
    }
}
