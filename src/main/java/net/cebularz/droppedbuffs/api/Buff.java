package net.cebularz.droppedbuffs.api;

import net.cebularz.droppedbuffs.entity.entities.Basic_Buff_Entity;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public interface Buff {

    void onPickup(Player player);
    int getColor();
    Identifier getId();
    EntityType<? extends Basic_Buff_Entity> getEntityType();

    boolean canSpawn(LivingDeathEvent event);

    default void setId(Identifier id) {
        throw new UnsupportedOperationException("No ID");
    }
}
