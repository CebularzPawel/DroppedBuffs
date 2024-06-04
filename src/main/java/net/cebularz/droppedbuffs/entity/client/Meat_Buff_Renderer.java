package net.cebularz.droppedbuffs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.custom.Meat_Buff_Entity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class Meat_Buff_Renderer extends EntityRenderer<Meat_Buff_Entity> {
    private final Meat_Buff_Model<Meat_Buff_Entity> model;
    public Meat_Buff_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Meat_Buff_Model<>(context.bakeLayer(ModModelLayers.MEAT_BUFF_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(Meat_Buff_Entity pEntity) {
        return new ResourceLocation(DroppedBuffs.MOD_ID, "textures/entity/meat_buff.png");
    }

    @Override
    public void render(Meat_Buff_Entity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        pPoseStack.pushPose();
        pPoseStack.translate(0.0D, 2.0D, 0.0D);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pEntity.rotationY));
        pPoseStack.scale( 1.5F, 1.5F, 1.5F);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));

        VertexConsumer consumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        model.renderToBuffer(pPoseStack, consumer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, 1.0F);
        pPoseStack.popPose();

        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }
}