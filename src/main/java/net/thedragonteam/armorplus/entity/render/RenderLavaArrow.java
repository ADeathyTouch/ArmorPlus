package net.thedragonteam.armorplus.entity.render;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.armorplus.ArmorPlus;
import net.thedragonteam.armorplus.entity.entityarrow.EntityLavaArrow;
import net.thedragonteam.armorplus.entity.entityarrow.EntityRedstoneArrow;

@SideOnly(Side.CLIENT)
public class RenderLavaArrow extends RenderArrow<EntityLavaArrow> {

    public static final ResourceLocation res = new ResourceLocation(ArmorPlus.MODID, "textures/entity/projectiles/lava_arrow.png");

    public RenderLavaArrow(RenderManager rm) {
        super(rm);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityLavaArrow entity) {
        return res;
    }

}