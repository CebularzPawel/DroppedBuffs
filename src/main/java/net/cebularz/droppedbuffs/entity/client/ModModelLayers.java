package net.cebularz.droppedbuffs.entity.client;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation MEAT_BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"meat_buff_layer"),"main");
    public static final ModelLayerLocation INVISIBILITY_BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"invisibility_buff_layer"),"main");
    public static final ModelLayerLocation RESISTANCE_BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"resistance_buff_layer"),"main");
    public static final ModelLayerLocation HEAL_BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"heal_buff_layer"),"main");
    public static final ModelLayerLocation STRENGTH_BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"strength_buff_layer"),"main");
    public static final ModelLayerLocation HASTE_BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"haste_buff_layer"),"main");
    public static final ModelLayerLocation BUFF_LAYER = new ModelLayerLocation(
            new ResourceLocation(DroppedBuffs.MOD_ID,"buff_layer"),"main");

}
