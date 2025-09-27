package com.vincenthuto.moremnaspellicons;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MoreMnASpellIcons.MODID)
public class MoreMnASpellIcons {
    public static final String MODID = "moremnaspellicons";

    public MoreMnASpellIcons(FMLJavaModLoadingContext context) {
        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
    }
}
