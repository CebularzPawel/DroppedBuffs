package net.cebularz.droppedbuffs.entity.client;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation MEAT_BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"meat_buff_layer"),"main");
    public static final ModelLayerLocation INVISIBILITY_BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"invisibility_buff_layer"),"main");
}
