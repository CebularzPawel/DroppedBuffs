package net.cebularz.droppedbuffs.api;

import net.cebularz.droppedbuffs.entity.entities.Basic_Buff_Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;

public interface Buff {
    void onPickup(Player player);
    int getColor();
    ResourceLocation getId();
    EntityType<? extends Basic_Buff_Entity> getEntityType();

    default void setId(ResourceLocation id) {
        throw new UnsupportedOperationException("No ID");
    }
}
