package net.cebularz.droppedbuffs.entity.client.Resistance_Buff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.cebularz.droppedbuffs.DroppedBuffsConfig;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.client.Basic_Buff_RenderState;
import net.cebularz.droppedbuffs.entity.client.ModModelLayers;
import net.cebularz.droppedbuffs.entity.entities.Resistance_Buff_Entity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.LightCoordsUtil;

public class Resistance_Buff_Renderer extends EntityRenderer<Resistance_Buff_Entity, Basic_Buff_RenderState> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DroppedBuffs.MOD_ID, "textures/entity/resistance_buff.png");

    private final Resistance_Buff_Model<Basic_Buff_RenderState> model;
    public Resistance_Buff_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Resistance_Buff_Model<>(context.bakeLayer(ModModelLayers.RESISTANCE_BUFF_LAYER));
    }

    @Override
    public Basic_Buff_RenderState createRenderState() {
        return new Basic_Buff_RenderState();
    }

    @Override
    public void extractRenderState(Resistance_Buff_Entity pEntity, Basic_Buff_RenderState pState, float pPartialTick) {
        super.extractRenderState(pEntity, pState, pPartialTick);
        pState.rotationX = pEntity.rotationX;
        pState.rotationY = pEntity.rotationY;
        pState.rotationZ = pEntity.rotationZ;
        pState.alpha = pEntity.alpha;
    }

    @Override
    public void submit(Basic_Buff_RenderState pState, PoseStack pPoseStack, SubmitNodeCollector pCollector, CameraRenderState pCamera) {

        pPoseStack.pushPose();
        double bobOffset = Math.sin(pState.ageInTicks * 0.075) * 0.075;
        pPoseStack.translate(0.0D, 0.75D + bobOffset, 0.0D);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(pState.rotationX));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pState.rotationY));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(pState.rotationZ));
        float size = 1.5F* DroppedBuffsConfig.buff_size;
        pPoseStack.scale( size, size,size);

        float alpha = pState.alpha;

        pCollector.submitModel(model, pState, pPoseStack, RenderTypes.entityTranslucent(TEXTURE), LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, ARGB.colorFromFloat(alpha, 1F, 1F, 1F), null, pState.outlineColor, null);
        pPoseStack.popPose();
        super.submit(pState, pPoseStack, pCollector, pCamera);
    }
}