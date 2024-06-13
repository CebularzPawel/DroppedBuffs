package net.cebularz.droppedbuffs.event;


import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.Buff.Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Haste_Buff.Haste_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Heal_Buff.Heal_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Invisibility_Buff.Invisibility_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Luck_Buff.Luck_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Meat_Buff.Meat_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.client.Resistance_Buff.Resistance_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Speed_Buff.Speed_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Strength_Buff.Strength_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Water_Breathing_Buff.Water_Breathing_Buff_Model;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=DroppedBuffs.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ModEventBusClientEvents {


    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.MEAT_BUFF_LAYER, Meat_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.INVISIBILITY_BUFF_LAYER, Invisibility_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RESISTANCE_BUFF_LAYER, Resistance_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.HEAL_BUFF_LAYER, Heal_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.STRENGTH_BUFF_LAYER, Strength_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.HASTE_BUFF_LAYER, Haste_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SPEED_BUFF_LAYER, Speed_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LUCK_BUFF_LAYER, Luck_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WATER_BREATHING_BUFF_LAYER, Water_Breathing_Buff_Model::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.BUFF_LAYER, Buff_Model::createBodyLayer);

    }

}
