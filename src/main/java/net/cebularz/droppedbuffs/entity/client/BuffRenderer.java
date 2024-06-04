package net.cebularz.droppedbuffs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.custom.BuffEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BuffRenderer extends MobRenderer<BuffEntity, Health_Drop<BuffEntity>> {
    public BuffRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Health_Drop<>(pContext.bakeLayer(ModModelLayers.BUFF_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(BuffEntity pEntity) {
        return new ResourceLocation(DroppedBuffs.MOD_ID, "textures/entity/health_drop");
    }

    @Override
    public void render(BuffEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}