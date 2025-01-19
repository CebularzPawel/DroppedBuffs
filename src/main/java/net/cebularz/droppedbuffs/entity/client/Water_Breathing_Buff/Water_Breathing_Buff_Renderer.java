package net.cebularz.droppedbuffs.entity.client.Water_Breathing_Buff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.cebularz.droppedbuffs.DroppedBuffsConfig;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.entities.Water_Breathing_Buff_Entity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class Water_Breathing_Buff_Renderer extends EntityRenderer<Water_Breathing_Buff_Entity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DroppedBuffs.MOD_ID, "textures/entity/water_breathing_buff.png");

    private final Water_Breathing_Buff_Model<Water_Breathing_Buff_Entity> model;
    public Water_Breathing_Buff_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Water_Breathing_Buff_Model<>(context.bakeLayer(ModModelLayers.WATER_BREATHING_BUFF_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(Water_Breathing_Buff_Entity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(Water_Breathing_Buff_Entity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        pPoseStack.pushPose();
        double bobOffset = Math.sin((pEntity.tickCount + pPartialTick) * 0.075) * 0.075;
        pPoseStack.translate(0.0D, 0.75D + bobOffset, 0.0D);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(pEntity.rotationX));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pEntity.rotationY));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(pEntity.rotationZ));
        float size = 1.5F* DroppedBuffsConfig.buff_size;
        pPoseStack.scale( size, size,size);

        float alpha = pEntity.alpha;

        VertexConsumer consumer = pBuffer.getBuffer(RenderType.entityTranslucent(TEXTURE));
        model.renderToBuffer(pPoseStack, consumer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, alpha);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }
}