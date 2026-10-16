package net.cebularz.droppedbuffs.entity.client.Resistance_Buff;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class Resistance_Buff_Model<T extends EntityRenderState> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart res;

	public Resistance_Buff_Model(ModelPart root) {
		super(root);
		this.res = root.getChild("res");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		float totalHeight = -32.0F;

		float centerOffsetY = totalHeight / 2;
		PartDefinition res = partdefinition.addOrReplaceChild("res", CubeListBuilder.create()
				.texOffs(14, 13).addBox(1.0F, centerOffsetY-2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, centerOffsetY, -1.0F, 10.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-3.0F, centerOffsetY+9.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-5.0F, centerOffsetY-2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T state) {

	}
}