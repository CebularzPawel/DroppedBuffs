package net.cebularz.droppedbuffs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.custom.BuffEntity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;

public class BuffRenderer extends EntityRenderer<BuffEntity> {
    private final Health_Drop<BuffEntity> model;
    public BuffRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Health_Drop<>(context.bakeLayer(ModModelLayers.BUFF_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(BuffEntity pEntity) {
        return new ResourceLocation(DroppedBuffs.MOD_ID, "textures/entity/health_drop");
    }

    @Override
    public void render(BuffEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        pPoseStack.pushPose();
        pPoseStack.mulPose(Vector3f.YP.rotationDegrees(-pEntity.getYRot()));
        pPoseStack.scale( 1.5F, 1.5F, 1.5F);
        VertexConsumer consumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        model.renderToBuffer(pPoseStack, consumer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, 1.0F);
        pPoseStack.popPose();

        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }
}