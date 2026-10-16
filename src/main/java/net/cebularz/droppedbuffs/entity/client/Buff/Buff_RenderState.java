package net.cebularz.droppedbuffs.entity.client.Buff;

import net.minecraft.client.renderer.entity.state.EntityRenderState;

// Values copied from a Buff_Entity each frame, used by Buff_Renderer
public class Buff_RenderState extends EntityRenderState {
    public int textureIndex;
    public int colorMultiplier;
    public float alpha;
    public float yRot;
}
