package net.cebularz.droppedbuffs.api;

import net.cebularz.droppedbuffs.entity.entities.Basic_Buff_Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public interface Buff {

    void onPickup(Player player);
    int getColor();
    ResourceLocation getId();
    EntityType<? extends Basic_Buff_Entity> getEntityType();

    boolean canSpawn(LivingDeathEvent event);

    default void setId(ResourceLocation id) {
        throw new UnsupportedOperationException("No ID");
    }
}
