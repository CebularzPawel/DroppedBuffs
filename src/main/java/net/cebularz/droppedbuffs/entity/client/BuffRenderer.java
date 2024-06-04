package net.cebularz.droppedbuffs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.custom.BuffEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BuffRenderer extends MobRenderer<BuffEntity,Health_Drop<BuffEntity>> {


    public BuffRenderer(EntityRendererProvider.Context pContext, Health_Drop<BuffEntity> pModel, float pShadowRadius) {
        super(pContext, new Health_Drop<>(pContext.bakeLayer(ModModelLayers.BUFF_LAYER)), 0.5f);

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
