package net.cebularz.droppedbuffs.api;

import net.minecraft.resources.ResourceLocation;

public abstract class AbstractBuff implements Buff {
    protected ResourceLocation id;

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public void setId(ResourceLocation id) {
        this.id = id;
    }
}

