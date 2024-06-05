package net.cebularz.droppedbuffs.event;


import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.Meat_Buff.Meat_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=DroppedBuffs.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ModEventBusClientEvents {


    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.MEAT_BUFF_LAYER, Meat_Buff_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.INVISIBILITY_BUFF_LAYER, Meat_Buff_Model::createBodyLayer);
    }

}
