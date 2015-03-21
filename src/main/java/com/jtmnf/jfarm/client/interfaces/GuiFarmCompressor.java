package com.jtmnf.jfarm.client.interfaces;

import com.jtmnf.jfarm.tileentities.TileEntityFarmCompressor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiFarmCompressor extends GuiContainer {
    private TileEntityFarmCompressor farmCompressor;

    public GuiFarmCompressor(InventoryPlayer inventoryPlayer, TileEntityFarmCompressor farmCompressor){
        super(new ContainerFarmCompressor(inventoryPlayer, farmCompressor));
        this.farmCompressor = farmCompressor;

        xSize = 175;
        ySize = 165;
    }

    private static final ResourceLocation texture = new ResourceLocation("jfarm", "textures/gui/guiFarmCompressor.png");

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
        GL11.glColor4f(1, 1, 1, 1);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String st = "Farm Compressor";

        fontRendererObj.drawString(st, 6, 6, 0x404040);
    }
}
