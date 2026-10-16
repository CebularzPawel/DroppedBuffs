package net.cebularz.droppedbuffs.entity.client.Buff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.entities.Buff_Entity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.LightCoordsUtil;
import org.jetbrains.annotations.NotNull;

public class Buff_Renderer extends EntityRenderer<Buff_Entity, Buff_RenderState> {
    private final Buff_Model<Buff_RenderState> model;

    public Buff_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Buff_Model<>(context.bakeLayer(ModModelLayers.BUFF_LAYER));
    }

    @Override
    public Buff_RenderState createRenderState() {
        return new Buff_RenderState();
    }

    @Override
    public void extractRenderState(Buff_Entity entity, Buff_RenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.textureIndex = entity.getTextureIndex();
        state.colorMultiplier = entity.getColorMultiplier();
        state.alpha = entity.alpha;
        state.yRot = entity.getYRot();
    }

    public @NotNull Identifier getTextureLocation(@NotNull Buff_RenderState state) {
        int textureIndex = state.textureIndex;
        return Identifier.fromNamespaceAndPath(DroppedBuffs.MOD_ID, "textures/entity/buffeffects/buffeffect_" + textureIndex + ".png");
    }

    @Override
    public void submit(Buff_RenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.75D, 0.0D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-state.yRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
        poseStack.scale(1.1F, 1.0F, 1.1F);
        int color = state.colorMultiplier;
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
        float alpha = state.alpha;
        collector.submitModel(model, state, poseStack, RenderTypes.entityTranslucent(this.getTextureLocation(state)), LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, ARGB.colorFromFloat(alpha, red, green, blue), null, state.outlineColor, null);
        poseStack.popPose();
        super.submit(state, poseStack, collector, camera);
    }
}
