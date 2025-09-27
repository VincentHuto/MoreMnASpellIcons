package com.vincenthuto.moremnaspellicons;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = MoreMnASpellIcons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientConfig
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static List<? extends String> customIconLocations;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CUSTOM_ICONS= BUILDER
            .comment("List of custom spell icons or resource locations to be loaded.")
            .comment("Spell Icons must be loaded in as resource pack in the 'textures/item/sorcery/icons/your_spell_icon.png' ")
            .comment("Icon Models must be loaded in as resource pack in the 'models/spell_icon/your_spell_icon.json' ")
            .comment("Spell Icons should also be 32x32px for best appearance.")
            .defineList(
                    "customIcons",
                    List.of("moremnaspellicons:spell_icon/sample_icon"),
                    o -> o instanceof String && ResourceLocation.isValidResourceLocation((String) o)
            );

    static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        customIconLocations  = CUSTOM_ICONS.get();
    }
}
