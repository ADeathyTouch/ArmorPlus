/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package net.thedragonteam.armorplus.items.battleaxes;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.thedragonteam.armorplus.items.base.BaseSword;
import net.thedragonteam.armorplus.registry.ModItems;

import java.util.List;

import static net.thedragonteam.thedragonlib.util.TextHelper.localize;

/**
 * net.thedragonteam.armorplus.items.battleaxes
 * ArmorPlus created by sokratis12GR on 4/19/2016.
 * - TheDragonTeam
 */
public class EmeraldBattleAxe extends BaseSword {

    public EmeraldBattleAxe() {
        super(ModItems.battleAxeEmeraldMaterial, "emerald_battle_axe");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target instanceof EntityLivingBase) {
            ((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 120, 1, false, true));
        }
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("\2479Ability: " + "\247rApplies Mining Fatigue 2");
        tooltip.add("\2473Use: " + "\247rHit a Target");
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.EMERALD;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return (TextFormatting.DARK_GREEN + localize(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }
}
