package net.thedragonteam.armorplus.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.thedragonteam.armorplus.util.Utils;

public class RenderSpecial{

    private final ItemStack theThingToRender;

    public RenderSpecial(ItemStack stack){
        this.theThingToRender = stack;
    }

    public void render(EntityPlayer player, float partialTicks){
        if(player.isInvisible() || !player.isWearing(EnumPlayerModelParts.CAPE) || player.isElytraFlying()){
            return;
        }
        boolean isBlock = this.theThingToRender.getItem() instanceof ItemBlock;

        GlStateManager.pushMatrix();

        Vec3d currentPos = Minecraft.getMinecraft().thePlayer.getPositionEyes(partialTicks);
        Vec3d playerPos = player.getPositionEyes(partialTicks);
        GlStateManager.translate(playerPos.xCoord-currentPos.xCoord, playerPos.yCoord-currentPos.yCoord, playerPos.zCoord-currentPos.zCoord);

        GlStateManager.translate(0D, 2.375D-(player.isSneaking() ? 0.125D : 0D)+(isBlock ? 0D : 0.1875D), 0D);
        GlStateManager.rotate(180F, 1.0F, 0.0F, 1.0F);

        float size = isBlock ? 0.5F : 0.4F;
        GlStateManager.scale(size, size, size);

        //Make the floaty stuff look nice using sine waves \o/ -xdjackiexd
        //Peck edit: What do you mean by "nice" you jackass? >_>
        double boop = Minecraft.getSystemTime()/1000D;
        GlStateManager.translate(0D, Math.sin(boop%(2*Math.PI))*0.25, 0D);
        GlStateManager.rotate((float)(((boop*40D)%360)), 0, 1, 0);

        GlStateManager.disableLighting();
        if(this.theThingToRender != null){
            GlStateManager.pushMatrix();
            if(!isBlock){
                GlStateManager.translate(0D, 0.5D, 0D);
            }
            GlStateManager.rotate(180F, 1F, 0F, 0F);
            Utils.renderItemInWorld(this.theThingToRender);
            GlStateManager.popMatrix();
        }
        GlStateManager.enableLighting();

        GlStateManager.popMatrix();
    }

}