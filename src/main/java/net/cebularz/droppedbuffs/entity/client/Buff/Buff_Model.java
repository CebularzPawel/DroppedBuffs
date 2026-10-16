package net.cebularz.droppedbuffs.entity.client.Buff;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class Buff_Model<T extends EntityRenderState> extends EntityModel<T> {
    //public static final ModelLayerLocation BUFF_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("modid", "buff"), "main");
    private final ModelPart buff;

    public Buff_Model(ModelPart root) {
        super(root);
        this.buff = root.getChild("buff");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition buff = partdefinition.addOrReplaceChild(
                "buff",
                CubeListBuilder.create().texOffs(
                        0, 0)
                        .addBox(-7.0F,
                                -32.0F,
                                -8.0F,
                                16.0F,
                                32.0F,
                                16.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T state) {

    }
}