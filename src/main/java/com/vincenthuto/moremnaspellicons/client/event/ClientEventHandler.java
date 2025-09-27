package com.vincenthuto.moremnaspellicons.client.event;

import com.mna.items.SpellIconList;
import com.vincenthuto.moremnaspellicons.ClientConfig;
import com.vincenthuto.moremnaspellicons.MoreMnASpellIcons;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = MoreMnASpellIcons.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEventHandler {

    @Mod.EventBusSubscriber(modid = MoreMnASpellIcons.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {


        public static final ResourceLocation[] CACHED_ICONS = SpellIconList.ALL;

        @SubscribeEvent
        public static void onRegisterSpecialModels(ModelEvent.RegisterAdditional event) {

            List<ResourceLocation> iconList = new ArrayList<>(Arrays.asList(CACHED_ICONS));

            for (String spell : ClientConfig.customIconLocations) {
                event.register(ResourceLocation.parse(spell));
                System.out.println("REGISTERING SPELL ICONS: " + spell);
                iconList.add(ResourceLocation.parse(spell));
            }
            SpellIconList.ALL = iconList.toArray(new ResourceLocation[0]);

        }

    }

}
