package com.jtmnf.jfarm.blocks;

import com.jtmnf.jfarm.JFarm;
import com.jtmnf.jfarm.tileentities.TileEntityFarmCompressor;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class BlockFarmCompressor extends InitBlocks{

    public IIcon[] icons = new IIcon[6];
    public String[] sides = {"front", "side", "side", "side", "side", "side"};

    public BlockFarmCompressor(){
        super(Material.piston);

        this.setHarvestLevel("pickaxe", 1);
        this.setBlockName("farmCompressor");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        for (int i = 0; i < 6; i ++) {
            this.icons[i] = register.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)+ "_" + sides[i]);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        if(!world.isRemote){
            FMLNetworkHandler.openGui(player, JFarm.instance, 0, world, x, y, z);
        }

        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack stack) {
        int directionFacing = MathHelper.floor_double((double) (livingBase.rotationYaw * 4.0F / 360.0F) +2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, directionFacing, 2);
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        if (side == 1) return this.icons[1];
        else if (side == 0) return this.icons[1];
        else if (metadata == 2 && side == 2) return this.icons[0];
        else if (metadata == 3 && side == 5) return this.icons[0];
        else if (metadata == 0 && side == 3) return this.icons[0];
        else if (metadata == 1 && side == 4) return this.icons[0];
        else return this.icons[5];
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te != null && te instanceof IInventory){
            IInventory iInventory = (IInventory) te;

            for (int i = 0; i < iInventory.getSizeInventory(); ++i){
                ItemStack stack = iInventory.getStackInSlotOnClosing(i);

                if(stack != null){
                    float spawnX = x + world.rand.nextFloat();
                    float spawnY = y + world.rand.nextFloat();
                    float spawnZ = z + world.rand.nextFloat();

                    EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);

                    float mult = 0.05F;

                    droppedItem.motionY = (-0.5F + world.rand.nextFloat()) * mult;
                    droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
                    droppedItem.motionZ = (-0.5F + world.rand.nextFloat()) * mult;

                    world.spawnEntityInWorld(droppedItem);
                }
            }
        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int parameter) {
        return new TileEntityFarmCompressor();
    }
}
