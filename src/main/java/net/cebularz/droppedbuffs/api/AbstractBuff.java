package net.cebularz.droppedbuffs.api;

import net.minecraft.resources.Identifier;

public abstract class AbstractBuff implements Buff {
    protected Identifier id;

    public static boolean configactive = true;


    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public void setId(Identifier id) {
        this.id = id;
    }
}

