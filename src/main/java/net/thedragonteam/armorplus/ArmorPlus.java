/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.armorplus;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.armorplus.client.gui.ARPTab;
import net.thedragonteam.armorplus.client.gui.GuiHandler;
import net.thedragonteam.armorplus.proxy.CommonProxy;
import net.thedragonteam.thedragonlib.config.ModConfigProcessor;
import net.thedragonteam.thedragonlib.config.ModFeatureParser;
import net.thedragonteam.thedragonlib.util.LogHelper;

@Mod(modid = ArmorPlus.MODID, name = ArmorPlus.MODNAME, version = ArmorPlus.VERSION, dependencies = ArmorPlus.DEPEND, guiFactory = ArmorPlus.GUIFACTORY, canBeDeactivated = ArmorPlus.CAN_BE_DEACTIVATED, updateJSON = ArmorPlus.UPDATE_JSON, modLanguage = ArmorPlus.MOD_LANGUAGE, serverSideOnly = ArmorPlus.SERVER_SIDE_ONLY)
public class ArmorPlus {

    /**
     * Updates every time the mod updates minecraft version,
     * Updates MAJOR with 1 after each version upgrade
     */
    public static final String MCVERSION = "1.11";
    /**
     * Updates every MAJOR change,
     * never resets
     */
    public static final int MAJOR = 9;
    /**
     * Updates every time a new block, item or features is added or change,
     * resets on MAJOR changes
     */
    public static final int MINOR = 0;
    /**
     * Updates every time a bug is fixed or issue solved or very minor code changes,
     * resets on MINOR changes
     */
    public static final int PATCH = 0;
    /**
     * Updates every time a build is created, mostly used for dev versions and
     * final versions for releases after for each Minor or Major update,
     * resets on MINOR and MAJOR changes
     */
    public static final int BUILD = 1;
    /**
     * The ArmorPlus Version
     */
    public static final String VERSION = ArmorPlus.MCVERSION + "-" + ArmorPlus.MAJOR + "." + ArmorPlus.MINOR + "." + ArmorPlus.PATCH + "." + ArmorPlus.BUILD + "";
    //    public static final String TESLA_VERSION = "1.2.1.49";
    public static final String LIB_VERSION = "1.11-2.0.0";
    //    public static final String MANTLE_VERSION = "1.10.2-1.0.0";
    //    public static final String TCONSTRUCT_VERSION = "1.10.2-2.5.6";
    //    public static final String BAUBLES_VERSION = "1.3.0";
    public static final String MODID = "armorplus";
    public static final String MODNAME = "ArmorPlus";
    public static final String MOD_LANGUAGE = "java";
    public static final boolean SERVER_SIDE_ONLY = false;
    public static final String UPDATE_JSON = "http://fdn.redstone.tech/TheDragonTeam/armorplus/update.json";
    public static final boolean CAN_BE_DEACTIVATED = false;
    public static final String DEPEND = "required-after:thedragonlib@[" + ArmorPlus.LIB_VERSION + ",);" /*+ "after:tesla@[" + ArmorPlus.TESLA_VERSION + ",);"*/ /*+ "after:mantle@[" + ArmorPlus.MANTLE_VERSION + ",);"*/ /*+ "after:tconstruct@[" + ArmorPlus.TCONSTRUCT_VERSION + ",);"*/ /*+ "after:Baubles;"*/;
    public static final String GUIFACTORY = "net.thedragonteam.armorplus.client.gui.ConfigGuiFactory";
    public static final String CLIENTPROXY = "net.thedragonteam.armorplus.proxy.ClientProxy";
    public static final String SERVERPROXY = "net.thedragonteam.armorplus.proxy.ServerProxy";

    @SidedProxy(clientSide = ArmorPlus.CLIENTPROXY, serverSide = ArmorPlus.SERVERPROXY)
    public static CommonProxy proxy;

    public static CreativeTabs tabArmorplus = new ARPTab(CreativeTabs.getNextID(), ArmorPlus.MODID, ArmorPlus.MODID + "." + "armors", 0);
    public static CreativeTabs tabArmorplusItems = new ARPTab(CreativeTabs.getNextID(), ArmorPlus.MODID, ArmorPlus.MODID + "." + "items", 1);
    public static CreativeTabs tabArmorplusBlocks = new ARPTab(CreativeTabs.getNextID(), ArmorPlus.MODID, ArmorPlus.MODID + "." + "blocks", 2);
    public static CreativeTabs tabArmorplusWeapons = new ARPTab(CreativeTabs.getNextID(), ArmorPlus.MODID, ArmorPlus.MODID + "." + "weapons", 3);
    public static CreativeTabs tabArmorplusTesla = new ARPTab(CreativeTabs.getNextID(), ArmorPlus.MODID, ArmorPlus.MODID + "." + "tesla", 4);
    public static ModFeatureParser featureParser = new ModFeatureParser(ArmorPlus.MODID, new CreativeTabs[]{
            tabArmorplus, tabArmorplusItems, tabArmorplusBlocks, tabArmorplusWeapons, tabArmorplusTesla
    });
    public static ModConfigProcessor configProcessor = new ModConfigProcessor();
    public static Configuration configuration;
    @Mod.Instance(ArmorPlus.MODID)
    public static ArmorPlus instance;
    private GuiHandler GuiHandler = new GuiHandler();

    public ArmorPlus() {
        LogHelper.info("Welcoming Minecraft");
    }

    public static String getVersion() {
        return ArmorPlus.VERSION;
    }

    public static boolean hasTesla() {
        return Loader.isModLoaded("tesla");
    }

    public static ResourceLocation getResourceLocation(String path) {
        return new ResourceLocation(ArmorPlus.MODID, path);
    }

    public static String getArmorPlusLocation(String path) {
        return ArmorPlus.MODID + ":" + path;
    }

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void initClient(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiHandler);
        proxy.init(event);
    }

    @SideOnly(Side.SERVER)
    @EventHandler
    public void initServer(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiHandler);
        proxy.init(event);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SharedMonsterAttributes.ARMOR = new RangedAttribute((IAttribute) null, "generic.armor", 0.0D, 0.0D, 500.0D).setShouldWatch(true);
        configuration = new Configuration(event.getSuggestedConfigurationFile());
        configProcessor.processConfig(ARPConfig.class, configuration);
        featureParser.registerFeatures();
        proxy.preInit(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void modMapping(FMLModIdMappingEvent event) {
        proxy.modMapping(event);
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        proxy.serverLoad(event);
    }
}