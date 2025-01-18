package net.cebularz.droppedbuffs.entity.client.Invisibility_Buff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.entities.Invisibility_Buff_Entity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class Invisibility_Buff_Renderer extends EntityRenderer<Invisibility_Buff_Entity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DroppedBuffs.MOD_ID, "textures/entity/invisibility_buff.png");

    private final Invisibility_Buff_Model<Invisibility_Buff_Entity> model;
    public Invisibility_Buff_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Invisibility_Buff_Model<>(context.bakeLayer(ModModelLayers.INVISIBILITY_BUFF_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(Invisibility_Buff_Entity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(Invisibility_Buff_Entity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        pPoseStack.pushPose();
        double bobOffset = Math.sin((pEntity.tickCount + pPartialTick) * 0.075) * 0.075;
        pPoseStack.translate(0.0D,bobOffset+0.75D, 0.0D);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(pEntity.rotationX));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pEntity.rotationY));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(pEntity.rotationZ));
        float size = 1.5F* Config.buff_size;
        pPoseStack.scale( size, size,size);

        float alpha = pEntity.alpha;

        VertexConsumer consumer = pBuffer.getBuffer(RenderType.entityTranslucent(TEXTURE));
        model.renderToBuffer(pPoseStack, consumer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, alpha);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }
}