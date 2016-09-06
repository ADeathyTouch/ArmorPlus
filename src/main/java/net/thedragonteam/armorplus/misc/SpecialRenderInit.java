/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package net.thedragonteam.armorplus.misc;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SpecialRenderInit {

    public static final HashMap<String, RenderSpecial> SPECIAL_LIST = new HashMap<String, RenderSpecial>();

    public SpecialRenderInit() {
        new ThreadSpecialFetcher();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void parse(Properties properties) {
        for (String key : properties.stringPropertyNames()) {
            String[] values = properties.getProperty(key).split("@");
            if (values.length > 0) {
                String itemName = values[0];

                int meta;
                try {
                    meta = Integer.parseInt(values[1]);
                } catch (Exception e) {
                    meta = 0;
                }

                ItemStack stack = null;
                //Get the Item from the String
                ResourceLocation resLoc = new ResourceLocation(itemName);
                if (Item.REGISTRY.containsKey(resLoc)) {
                    stack = new ItemStack(Item.REGISTRY.getObject(resLoc), 1, meta);
                } else {
                    if (Block.REGISTRY.containsKey(resLoc)) {
                        stack = new ItemStack(Block.REGISTRY.getObject(resLoc), 1, meta);
                    }
                }

                //Add a new Special Renderer to the list
                if (stack != null) {
                    SPECIAL_LIST.put(key, new RenderSpecial(stack));
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerRender(RenderPlayerEvent.Pre event) {
        if (!SPECIAL_LIST.isEmpty()) {
            for (Map.Entry<String, RenderSpecial> entry : SPECIAL_LIST.entrySet()) {
                //Does the player have one of the names from the list?
                String playerName = event.getEntityPlayer().getName();
                if (entry.getKey() != null && playerName != null) {
                    if (entry.getKey().equalsIgnoreCase(playerName)) {
                        //Render the special Item/Block
                        entry.getValue().render(event.getEntityPlayer(), event.getPartialRenderTick());
                        break;
                    }
                }
            }
        }
    }

}