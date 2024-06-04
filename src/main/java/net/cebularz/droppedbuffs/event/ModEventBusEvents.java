package net.cebularz.droppedbuffs.event;


import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.client.Health_Drop;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.custom.BuffEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=DroppedBuffs.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BUFFENTITY.get(), BuffEntity.createAttributes().build());
    }
}
