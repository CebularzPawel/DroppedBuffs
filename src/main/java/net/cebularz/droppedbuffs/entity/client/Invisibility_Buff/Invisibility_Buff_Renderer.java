package net.cebularz.droppedbuffs.entity.client.Invisibility_Buff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.Meat_Buff.Meat_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.custom.Invisibility_Buff_Entity;
import net.cebularz.droppedbuffs.entity.custom.Meat_Buff_Entity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class Invisibility_Buff_Renderer extends EntityRenderer<Invisibility_Buff_Entity> {
    private final Invisibility_Buff_Model<Invisibility_Buff_Entity> model;
    public Invisibility_Buff_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Invisibility_Buff_Model<>(context.bakeLayer(ModModelLayers.INVISIBILITY_BUFF_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(Invisibility_Buff_Entity pEntity) {
        return new ResourceLocation(DroppedBuffs.MOD_ID, "textures/entity/invisibility_buff.png");
    }

    @Override
    public void render(Invisibility_Buff_Entity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        pPoseStack.pushPose();
        pPoseStack.translate(0.0D, 2.0D, 0.0D);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pEntity.rotationY));
        float size = pEntity.size;
        pPoseStack.scale( size, size,size);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));

        VertexConsumer consumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        model.renderToBuffer(pPoseStack, consumer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, 1.0F);
        pPoseStack.popPose();

        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }
}