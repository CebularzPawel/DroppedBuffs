package net.cebularz.droppedbuffs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.custom.BuffEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BuffRenderer extends EntityRenderer<BuffEntity> {
    private final ModelPart bone;

    public BuffRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        ModelPart bone = pContext.bakeLayer(ModModelLayers.BUFF_LAYER);
        this.bone = bone;
        this.shadowRadius = 0.5F;

    }

    @Override
    public ResourceLocation getTextureLocation(BuffEntity buffEntity) {
        return new ResourceLocation(DroppedBuffs.MOD_ID,"textures/entity/health_drop.png");
    }

    @Override
    public void render(BuffEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
