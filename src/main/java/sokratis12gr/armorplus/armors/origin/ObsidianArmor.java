package sokratis12gr.armorplus.armors.origin;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import sokratis12gr.armorplus.ARPConfig;
import sokratis12gr.armorplus.ArmorPlus;
import sokratis12gr.armorplus.registry.ModBlocks;

import java.util.List;

public class ObsidianArmor {

    public static Item helmet;
    public static Item chestplate;
    public static Item legs;
    public static Item boots;

    static {
        ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("OBSIDIANARMOR", ArmorPlus.MODID + ":" + "ObsidianArmor", 40, new int[]
                {3, 7, 10, 5}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);

        int armorPreffix = 0;
        helmet = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.HEAD) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                int obsidianArmorEffectlevel = ARPConfig.obsidianArmorEffectlevel + 1;
                if (ARPConfig.enableObsidianHResistance) {
                    infoList.add("\2479Ability: " + "\247rResistance " + obsidianArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip A Piece");
                }
                if (ARPConfig.enableFullObsidianArmorEffect) {
                    infoList.add("\2479Ability: " + "\247rResistance " + obsidianArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip The Full Set");
                }
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ARPConfig.enableObsidianHResistance && entity instanceof EntityLivingBase && !ARPConfig.enableFullObsidianArmorEffect) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 120, ARPConfig.obsidianArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_GRAY + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }


            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                if (ARPConfig.recipes == 0) {
                    return repair.getItem() == Item.getItemFromBlock(Blocks.OBSIDIAN);
                }
                if (ARPConfig.recipes == 1) {
                    return repair.getItem() == Item.getItemFromBlock(ModBlocks.BLOCK_LAVA_CRYSTAL);
                }
                return true;
            }
        }).setUnlocalizedName("ObsidianHelmet");
        helmet.setMaxStackSize(1);
        chestplate = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.CHEST) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                int obsidianArmorEffectlevel = ARPConfig.obsidianArmorEffectlevel + 1;
                if (ARPConfig.enableObsidianHResistance) {
                    infoList.add("\2479Ability: " + "\247rResistance " + obsidianArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip A Piece");
                }
                if (ARPConfig.enableFullObsidianArmorEffect) {
                    infoList.add("\2479Ability: " + "\247rResistance " + obsidianArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip The Full Set");
                }
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ARPConfig.enableObsidianCResistance && entity instanceof EntityLivingBase && !ARPConfig.enableFullObsidianArmorEffect) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 120, ARPConfig.obsidianArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_GRAY + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }


            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                if (ARPConfig.recipes == 0) {
                    return repair.getItem() == Item.getItemFromBlock(Blocks.OBSIDIAN);
                }
                if (ARPConfig.recipes == 1) {
                    return repair.getItem() == Item.getItemFromBlock(ModBlocks.BLOCK_LAVA_CRYSTAL);
                }
                return true;
            }
        }).setUnlocalizedName("ObsidianChestplate");
        chestplate.setMaxStackSize(1);
        legs = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.LEGS) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                int obsidianArmorEffectlevel = ARPConfig.obsidianArmorEffectlevel + 1;
                if (ARPConfig.enableObsidianHResistance) {
                    infoList.add("\2479Ability: " + "\247rResistance " + obsidianArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip A Piece");
                }
                if (ARPConfig.enableFullObsidianArmorEffect) {
                    infoList.add("\2479Ability: " + "\247rResistance " + obsidianArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip The Full Set");
                }
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ARPConfig.enableObsidianLResistance && entity instanceof EntityLivingBase && !ARPConfig.enableFullObsidianArmorEffect) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 120, ARPConfig.obsidianArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_GRAY + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }


            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                if (ARPConfig.recipes == 0) {
                    return repair.getItem() == Item.getItemFromBlock(Blocks.OBSIDIAN);
                }
                if (ARPConfig.recipes == 1) {
                    return repair.getItem() == Item.getItemFromBlock(ModBlocks.BLOCK_LAVA_CRYSTAL);
                }
                return true;
            }
        }).setUnlocalizedName("ObsidianLeggings");
        legs.setMaxStackSize(1);
        boots = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.FEET) {
            @Override
            public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean par4) {
                int obsidianArmorEffectlevel = ARPConfig.obsidianArmorEffectlevel + 1;
                if (ARPConfig.enableObsidianHResistance) {
                    infoList.add("\2479Ability: " + "\247rResistance " + obsidianArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip A Piece");
                }
                if (ARPConfig.enableFullObsidianArmorEffect) {
                    infoList.add("\2479Ability: " + "\247rResistance " + obsidianArmorEffectlevel);
                    infoList.add("\2473Use: " + "\247rEquip The Full Set");
                }
            }

            public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
                if (ARPConfig.enableObsidianBResistance && entity instanceof EntityLivingBase && !ARPConfig.enableFullObsidianArmorEffect) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 120, ARPConfig.obsidianArmorEffectlevel, true, true));
                }
            }

            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return (TextFormatting.DARK_GRAY + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
            }

            public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
                if (ARPConfig.recipes == 0) {
                    return repair.getItem() == Item.getItemFromBlock(Blocks.OBSIDIAN);
                }
                if (ARPConfig.recipes == 1) {
                    return repair.getItem() == Item.getItemFromBlock(ModBlocks.BLOCK_LAVA_CRYSTAL);
                }
                return true;
            }
        }).setUnlocalizedName("ObsidianBoots");
        boots.setMaxStackSize(1);

        GameRegistry.registerItem(helmet, "obsidian_helmet");
        GameRegistry.registerItem(chestplate, "obsidian_chestplate");
        GameRegistry.registerItem(legs, "obsidian_leggings");
        GameRegistry.registerItem(boots, "obsidian_boots");

    }

    public Object instance;

    public ObsidianArmor() {
    }

    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:ObsidianHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:ObsidianChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:ObsidianLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:ObsidianBoots", "inventory"));
        }
        helmet.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        chestplate.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        legs.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
        boots.setCreativeTab(ArmorPlus.TAB_ARMORPLUS);
    }

    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            ModelLoader.setCustomModelResourceLocation(helmet, 0,
                    new ModelResourceLocation("armorplus:ObsidianHelmet", "inventory"));
            ModelLoader.setCustomModelResourceLocation(chestplate, 0,
                    new ModelResourceLocation("armorplus:ObsidianChestplate", "inventory"));
            ModelLoader.setCustomModelResourceLocation(legs, 0,
                    new ModelResourceLocation("armorplus:ObsidianLeggings", "inventory"));
            ModelLoader.setCustomModelResourceLocation(boots, 0,
                    new ModelResourceLocation("armorplus:ObsidianBoots", "inventory"));
        }
    }

    public void registerRenderers() {
    }

}