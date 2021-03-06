/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.armorplus.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import static net.minecraft.potion.Potion.getPotionFromResourceLocation;
import static net.thedragonteam.thedragonlib.util.TextHelper.localize;

public class PotionUtils {

    public static void addEffect(EntityLivingBase entity, Potion potion, int duration, int amplifier, boolean ambientIn, boolean showParticlesIn) {
        entity.addPotionEffect(new PotionEffect(potion, duration, amplifier, ambientIn, showParticlesIn));
    }

    public static void addEffect(EntityLivingBase entity, Potion potion, int duration, int amplifier, boolean ambientIn, char isGoodOrBad) {
        switch (isGoodOrBad) {
            case 'G':
                addEffect(entity, potion, duration, amplifier, ambientIn, false);
                break;
            case 'B':
                addEffect(entity, potion, duration, amplifier, ambientIn, true);
                break;
        }
    }

    public static void addEffect(EntityLivingBase entity, Potion potion, int duration, int amplifier, char isGoodOrBad) {
        switch (isGoodOrBad) {
            case 'G':
                addEffect(entity, potion, duration, amplifier, false, false);
                break;
            case 'B':
                addEffect(entity, potion, duration, amplifier, false, true);
                break;
        }
    }

    public static void addEffect(EntityLivingBase entity, Potion potion, int amplifier, char isGoodOrBad) {
        switch (isGoodOrBad) {
            case 'G':
                addEffect(entity, potion, 120, amplifier, false, false);
                break;
            case 'B':
                addEffect(entity, potion, 120, amplifier, false, true);
                break;
        }
    }

    public static void removeEffect(EntityLivingBase entity, Potion potion) {
        entity.removePotionEffect(potion);
    }

    public static String localizePotion(String resourceLocation) {
        return localize(getPotion(resourceLocation).getName() + ".name").trim();
    }

    public static Potion getPotion(String resourceLocation) {
        return getPotionFromResourceLocation(resourceLocation);
    }
}
