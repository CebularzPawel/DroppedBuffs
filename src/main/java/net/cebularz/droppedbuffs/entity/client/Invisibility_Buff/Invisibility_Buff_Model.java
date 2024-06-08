package net.cebularz.droppedbuffs.entity.client.Invisibility_Buff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class Invisibility_Buff_Model<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart invisibility;

	public Invisibility_Buff_Model(ModelPart root) {
		this.invisibility = root.getChild("invisibility");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		// Define the total height of the model
		float totalHeight = 13.0F;

		// Center offset for Y-axis
		float centerOffsetY = totalHeight / 2;

		// Define and position the "invisibility" part
		PartDefinition invisibility = partdefinition.addOrReplaceChild(
				"invisibility",
				CubeListBuilder.create()
						.texOffs(0, 13)
						.addBox(-1.0F, -centerOffsetY + 2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(0, 0)
						.addBox(-4.0F, -centerOffsetY, -1.0F, 8.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F - totalHeight, 0.0F)
		);

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// No animation for this model
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		invisibility.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return invisibility;
	}
}
