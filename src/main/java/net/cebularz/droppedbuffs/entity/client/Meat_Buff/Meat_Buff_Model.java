package net.cebularz.droppedbuffs.entity.client.Meat_Buff;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.EntityRenderState;


public class Meat_Buff_Model<T extends EntityRenderState> extends EntityModel<T> {
	private final ModelPart bone;

	public Meat_Buff_Model(ModelPart root) {
		super(root);
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		float totalHeight = 16.0F;

		float centerOffsetY = totalHeight / 2;

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create()
						.texOffs(0, 16).addBox(-1.0F, centerOffsetY - 13.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(0, 16).addBox(-1.0F, centerOffsetY - 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(0, 0).addBox(-3.0F, centerOffsetY - 10.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T state) {

	}
}