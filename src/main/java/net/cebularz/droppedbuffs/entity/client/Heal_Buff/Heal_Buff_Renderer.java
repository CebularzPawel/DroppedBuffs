package net.cebularz.droppedbuffs.entity.client.Heal_Buff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.entities.Heal_Buff_Entity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class Heal_Buff_Renderer extends EntityRenderer<Heal_Buff_Entity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DroppedBuffs.MOD_ID, "textures/entity/heal_buff.png");

    private final Heal_Buff_Model<Heal_Buff_Entity> model;
    public Heal_Buff_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Heal_Buff_Model<>(context.bakeLayer(ModModelLayers.HEAL_BUFF_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(Heal_Buff_Entity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(Heal_Buff_Entity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        pPoseStack.pushPose();
        double bobOffset = Math.sin((pEntity.tickCount + pPartialTick) * 0.075) * 0.075;
        pPoseStack.translate(0.0D, 0.75D + bobOffset, 0.0D);
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