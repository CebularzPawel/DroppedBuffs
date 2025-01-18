package net.cebularz.droppedbuffs.entity.client.Buff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.entities.Buff_Entity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class Buff_Renderer extends EntityRenderer<Buff_Entity> {
    private final Buff_Model<Buff_Entity> model;

    public Buff_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Buff_Model<>(context.bakeLayer(ModModelLayers.BUFF_LAYER));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Buff_Entity pEntity) {
        int textureIndex = pEntity.getTextureIndex();
        return new ResourceLocation(DroppedBuffs.MOD_ID, "textures/entity/buffeffects/buffeffect_" + textureIndex + ".png");
    }

    @Override
    public void render(Buff_Entity entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.75D, 0.0D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
        poseStack.scale(1.1F, 1.0F, 1.1F);
        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(entity)));
        int color = entity.getColorMultiplier();
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
        float alpha = entity.alpha;
        model.renderToBuffer(poseStack, consumer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, red, green, blue, alpha);
        poseStack.popPose();
        super.render(entity, yaw, partialTicks, poseStack, bufferSource, light);
    }
}
